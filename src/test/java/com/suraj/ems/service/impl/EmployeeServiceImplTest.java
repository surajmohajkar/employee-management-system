package com.suraj.ems.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.suraj.ems.dto.EmployeeResponseDTO;
import com.suraj.ems.entity.Employee;
import com.suraj.ems.exception.EmployeeNotFoundException;
import com.suraj.ems.repository.EmployeeRepository;
import com.suraj.ems.repository.EmployeeSalaryHistoryRepository;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceImplTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @Mock
    private EmployeeSalaryHistoryRepository salaryHistoryRepository;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    private Employee employee;

    @BeforeEach
    void setUp() {

        employee = new Employee();

        employee.setEmployeeId(1L);
        employee.setFirstName("Rahul");
        employee.setLastName("Sharma");
        employee.setEmail("rahul.sharma@gmail.com");
        employee.setPhoneNumber("9876543211");
        employee.setDepartment("Engineering");
        employee.setDesignation("Software Developer");
        employee.setSalary(new BigDecimal("85000"));
        employee.setJoiningDate(LocalDate.of(2026, 8, 24));
    }

    @Test
    void getEmployeeById_shouldReturnEmployee_whenEmployeeExists() {

        when(employeeRepository.findById(1L))
                .thenReturn(java.util.Optional.of(employee));

        EmployeeResponseDTO response = employeeService.getEmployeeById(1L);

        assertNotNull(response);

        assertEquals(1L, response.getEmployeeId());
        assertEquals("Rahul", response.getFirstName());
        assertEquals("Sharma", response.getLastName());
        assertEquals("rahul.sharma@gmail.com", response.getEmail());
        assertEquals("Engineering", response.getDepartment());
        assertEquals("Software Developer", response.getDesignation());
        assertEquals(new BigDecimal("85000"),response.getSalary());

        verify(employeeRepository).findById(1L);
    }

    @Test
    void getEmployeeById_shouldThrowException_whenEmployeeDoesNotExist() {

        when(employeeRepository.findById(99L)).thenReturn(java.util.Optional.empty());

        EmployeeNotFoundException exception = assertThrows(
                        EmployeeNotFoundException.class,
                        () -> employeeService.getEmployeeById(99L));

        assertEquals("Employee not found with ID : 99",exception.getMessage());

        verify(employeeRepository).findById(99L);
    }
}