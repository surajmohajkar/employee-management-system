package com.suraj.ems.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.suraj.ems.enums.EmployeeStatus;

public class EmployeeResponseDTO {
	private Long employeeId;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String department;
	private String designation;
	private BigDecimal salary;
	private LocalDate joiningDate;
	private EmployeeStatus status;
	private Long version;
	public EmployeeResponseDTO() {
		
	}
	public EmployeeResponseDTO(Long employeeId, String firstName,String lastName, String email, String phoneNumber,
			String department, String designation, BigDecimal salary, LocalDate joiningDate, EmployeeStatus status, Long version) {
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.department = department;
		this.designation = designation;
		this.salary = salary;
		this.joiningDate = joiningDate;
		this.status = status;
		this.version = version;
	}
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public BigDecimal getSalary() {
		return salary;
	}
	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}
	public LocalDate getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(LocalDate joiningDate) {
		this.joiningDate = joiningDate;
	}
	public EmployeeStatus getStatus() {
		return status;
	}
	public void setStatus(EmployeeStatus status) {
		this.status = status;
	}
	
	public Long getVersion() {
	    return version;
	}

	public void setVersion(Long version) {
	    this.version = version;
	}
	
}
