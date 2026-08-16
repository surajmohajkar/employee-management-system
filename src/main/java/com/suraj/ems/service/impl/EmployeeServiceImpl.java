package com.suraj.ems.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.suraj.ems.dto.EmployeePatchDTO;
import com.suraj.ems.dto.EmployeeRequestDTO;
import com.suraj.ems.dto.EmployeeResponseDTO;
import com.suraj.ems.entity.Employee;
import com.suraj.ems.exception.EmployeeNotFoundException;
import com.suraj.ems.mapper.EmployeeMapper;
import com.suraj.ems.repository.EmployeeRepository;
import com.suraj.ems.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
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
}