package com.suraj.ems.service.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.suraj.ems.entity.EmployeeSalaryHistory;
import com.suraj.ems.repository.EmployeeSalaryHistoryRepository;
import com.suraj.ems.dto.EmployeePatchDTO;
import com.suraj.ems.dto.EmployeeRequestDTO;
import com.suraj.ems.dto.EmployeeResponseDTO;
import com.suraj.ems.dto.EmployeeSalaryHistoryResponseDTO;
import com.suraj.ems.dto.PromotionRequestDTO;
import com.suraj.ems.entity.Employee;
import com.suraj.ems.exception.EmployeeNotFoundException;
import com.suraj.ems.mapper.EmployeeMapper;
import com.suraj.ems.repository.EmployeeRepository;
import com.suraj.ems.repository.EmployeeSalaryHistoryRepository;
import com.suraj.ems.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeSalaryHistoryRepository salaryHistoryRepository;
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, EmployeeSalaryHistoryRepository salaryHistoryRepository) {
        this.employeeRepository = employeeRepository;
        this.salaryHistoryRepository = salaryHistoryRepository;
    }

    @Override
    public EmployeeResponseDTO saveEmployee(EmployeeRequestDTO requestDTO) {

        Employee employee = EmployeeMapper.toEntity(requestDTO);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.toResponseDTO(savedEmployee);
    }

    @Override
    public List<EmployeeResponseDTO> getAllEmployees() {

        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map(EmployeeMapper::toResponseDTO).toList();
    }

    @Override
    public Page<EmployeeResponseDTO> getAllEmployees(Pageable pageable) {

        Page<Employee> employeePage =employeeRepository.findAll(pageable);

        return employeePage.map(EmployeeMapper::toResponseDTO);
    }
    
    @Override
    public EmployeeResponseDTO getEmployeeById(Long employeeId) {

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() ->new EmployeeNotFoundException("Employee not found with ID : " + employeeId));
        return EmployeeMapper.toResponseDTO(employee);
    }

    @Override
    public EmployeeResponseDTO updateEmployee(Long employeeId,EmployeeRequestDTO requestDTO) {

        Employee existingEmployee = employeeRepository.findById(employeeId)
                .orElseThrow(() ->new EmployeeNotFoundException("Employee not found with ID : " + employeeId));

        existingEmployee.setFirstName(requestDTO.getFirstName());
        existingEmployee.setLastName(requestDTO.getLastName());
        existingEmployee.setEmail(requestDTO.getEmail());
        existingEmployee.setPhoneNumber(requestDTO.getPhoneNumber());
        existingEmployee.setDepartment(requestDTO.getDepartment());
        existingEmployee.setDesignation(requestDTO.getDesignation());
        existingEmployee.setSalary(requestDTO.getSalary());
        existingEmployee.setJoiningDate(requestDTO.getJoiningDate());
        existingEmployee.setStatus(requestDTO.getStatus());
        Employee updatedEmployee = employeeRepository.save(existingEmployee);
        return EmployeeMapper.toResponseDTO(updatedEmployee);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() ->new EmployeeNotFoundException("Employee not found with ID : " + employeeId));
        employeeRepository.delete(employee);
    }
    
    @Override
    public EmployeeResponseDTO patchEmployee(Long employeeId, EmployeePatchDTO patchDTO) {
    	Employee existingEmployee = employeeRepository.findById(employeeId).orElseThrow(()-> new EmployeeNotFoundException("Employee not found with ID : "+ employeeId));
    	
    	if(patchDTO.getFirstName() != null) {
    		existingEmployee.setFirstName(patchDTO.getFirstName());
    	}
    	 if (patchDTO.getLastName() != null) {
    	        existingEmployee.setLastName(patchDTO.getLastName());
    	    }
    	 if (patchDTO.getEmail() != null) {
    	        existingEmployee.setEmail(patchDTO.getEmail());
    	    }
    	 if (patchDTO.getPhoneNumber() != null) {
    	        existingEmployee.setPhoneNumber(patchDTO.getPhoneNumber());
    	    }
    	 if (patchDTO.getDepartment() != null) {
    	        existingEmployee.setDepartment(patchDTO.getDepartment());
    	    }
    	 if (patchDTO.getDesignation() != null) {
    	        existingEmployee.setDesignation(patchDTO.getDesignation());
    	    }
    	 if (patchDTO.getSalary() != null) {
    	        existingEmployee.setSalary(patchDTO.getSalary());
    	    }
    	 if (patchDTO.getJoiningDate() != null) {
    	        existingEmployee.setJoiningDate(patchDTO.getJoiningDate());
    	    }
    	 if (patchDTO.getStatus() != null) {
    	        existingEmployee.setStatus(patchDTO.getStatus());
    	    }
    	 Employee updatedEmployee = employeeRepository.save(existingEmployee);

    	 return EmployeeMapper.toResponseDTO(updatedEmployee);
    }
    
    @Override
    public Page<EmployeeResponseDTO> searchEmployeesByDepartment(String department,Pageable pageable) {
        Page<Employee> employeePage =employeeRepository.findByDepartmentIgnoreCase(department,pageable);
        return employeePage.map(EmployeeMapper::toResponseDTO);
    }
    
    @Override
    @Transactional
    public EmployeeResponseDTO promoteEmployee(Long employeeId,PromotionRequestDTO requestDTO) {

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() ->new EmployeeNotFoundException("Employee not found with ID : " + employeeId));

        BigDecimal oldSalary = employee.getSalary();
        String oldDesignation = employee.getDesignation();

        employee.setSalary(requestDTO.getSalary());
        employee.setDesignation(requestDTO.getDesignation());

        EmployeeSalaryHistory history = new EmployeeSalaryHistory();

        history.setOldSalary(oldSalary);
        history.setNewSalary(requestDTO.getSalary());
        history.setOldDesignation(oldDesignation);
        history.setNewDesignation(requestDTO.getDesignation());
        history.setChangedAt(LocalDateTime.now());
        employee.addSalaryHistory(history);
        salaryHistoryRepository.save(history);
        
        return EmployeeMapper.toResponseDTO(employee);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<EmployeeSalaryHistoryResponseDTO> getSalaryHistory(Long employeeId) {

        List<EmployeeSalaryHistory> histories =salaryHistoryRepository.findHistoryWithEmployee(employeeId);

        return histories.stream().map(history -> {Employee employee = history.getEmployee();
        String employeeName =employee.getFirstName()+ " "+ employee.getLastName();

                    return new EmployeeSalaryHistoryResponseDTO(history.getHistoryId(),employee.getEmployeeId(),
                            employeeName,history.getOldSalary(),history.getNewSalary(),history.getOldDesignation(),
                            history.getNewDesignation(),history.getChangedAt());}).toList();
    }
    
}