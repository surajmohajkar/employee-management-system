package com.suraj.ems.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class PromotionRequestDTO {
	
	@NotBlank(message = "Designation is required")
	private String designation;
	
	@NotNull(message="Salary is required")
	@DecimalMin(value = "0.0",inclusive = false, message="Salary must be greature than 0")
	private BigDecimal salary;
	
	public PromotionRequestDTO() {
		
	}
	public PromotionRequestDTO(String designation, BigDecimal salary) {
		this.designation = designation;
		this.salary = salary;
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
}
