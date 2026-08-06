package com.suraj.ems.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.suraj.ems.enums.EmployeeStatus;

public class EmployeeRequestDTO {
	private String firstName;
	private String lastName;
	private String email;
	private String phonenNumber;
	private String department;
	private String designation;
	private BigDecimal salary;
	private LocalDate joiningDate;
	private EmployeeStatus status;
	public EmployeeRequestDTO() {
		
	}
	
	public EmployeeRequestDTO(String firstName,String lastName,String email, String phoneNumber,
			String department, BigDecimal salary, LocalDate joiningDate, EmployeeStatus status) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phonenNumber = phoneNumber;
		this.department = department;
		this.designation = designation;
		this.salary = salary;
		this.joiningDate = joiningDate;
		this.status =status;
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

	public String getPhonenNumber() {
		return phonenNumber;
	}

	public void setPhonenNumber(String phonenNumber) {
		this.phonenNumber = phonenNumber;
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
	
	
}
