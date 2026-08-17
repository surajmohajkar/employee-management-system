package com.suraj.ems.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.suraj.ems.dto.EmployeePatchDTO;
import com.suraj.ems.dto.EmployeeRequestDTO;
import com.suraj.ems.dto.EmployeeResponseDTO;
import com.suraj.ems.dto.PromotionRequestDTO;

public interface EmployeeService {

	EmployeeResponseDTO saveEmployee(EmployeeRequestDTO requestdto);

    List<EmployeeResponseDTO> getAllEmployees();
    
    Page<EmployeeResponseDTO>getAllEmployees(Pageable pageable);
    
    Page<EmployeeResponseDTO> searchEmployeesByDepartment(String department,Pageable pageable);

    EmployeeResponseDTO getEmployeeById(Long employeeId);

    EmployeeResponseDTO updateEmployee(Long employeeId, EmployeeRequestDTO requestdto);
    
    EmployeeResponseDTO patchEmployee(Long employeeId, EmployeePatchDTO patchDTO);
    
    EmployeeResponseDTO promoteEmployee(Long employeeId,PromotionRequestDTO requestDTO);

    void deleteEmployee(Long employeeId);
}