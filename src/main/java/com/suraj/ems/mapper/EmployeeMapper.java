package com.suraj.ems.mapper;

import com.suraj.ems.dto.EmployeeRequestDTO;
import com.suraj.ems.dto.EmployeeResponseDTO;
import com.suraj.ems.entity.Employee;

public class EmployeeMapper {
	private EmployeeMapper() {
		
	}
	public static Employee toEntity(EmployeeRequestDTO dto) {
		Employee employee = new Employee();
		
		employee.setFirstName(dto.getFirstName());
		employee.setLastName(dto.getLastName());
		employee.setEmail(dto.getEmail());
		employee.setPhoneNumber(dto.getPhonenNumber());
		employee.setDepartment(dto.getDepartment());
		employee.setDesignation(dto.getDesignation());
		employee.setSalary(dto.getSalary());
		employee.setJoiningDate(dto.getJoiningDate());
		employee.setStatus(dto.getStatus());
		
		return employee;
	}
	
	public static EmployeeResponseDTO toResponseDTO(Employee employee) {
		EmployeeResponseDTO dto = new EmployeeResponseDTO();
		
		dto.setEmployeeId(employee.getEmployeeId());
		dto.setFirstName(employee.getFirstName());
		dto.setLastName(employee.getLastName());
		dto.setEmail(employee.getEmail());
		dto.setPhoneNumber(employee.getPhoneNumber());
		dto.setDepartment(employee.getDepartment());
		dto.setDesignation(employee.getDesignation());
		dto.setSalary(employee.getSalary());
		dto.setJoiningDate(employee.getJoiningDate());
		dto.setStatus(employee.getStatus());
		
		return dto;
	}
}
