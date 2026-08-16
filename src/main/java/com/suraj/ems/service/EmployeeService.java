package com.suraj.ems.service;

import java.util.List;

import com.suraj.ems.dto.EmployeePatchDTO;
import com.suraj.ems.dto.EmployeeRequestDTO;
import com.suraj.ems.dto.EmployeeResponseDTO;

public interface EmployeeService {

	EmployeeResponseDTO saveEmployee(EmployeeRequestDTO requestdto);

    List<EmployeeResponseDTO> getAllEmployees();

    EmployeeResponseDTO getEmployeeById(Long employeeId);

    EmployeeResponseDTO updateEmployee(Long employeeId, EmployeeRequestDTO requestdto);
    
    EmployeeResponseDTO patchEmployee(Long employeeId, EmployeePatchDTO patchDTO);

    void deleteEmployee(Long employeeId);
}