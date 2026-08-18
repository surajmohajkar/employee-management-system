package com.suraj.ems.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="employee_salary_history")
public class EmployeeSalaryHistory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long historyId;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "employee_id", nullable = false)
	private Employee employee;
	
	@Column(nullable = false, precision = 12, scale=2)
	private BigDecimal oldSalary;
	
	@Column(nullable = false, precision = 12, scale=2)
	private BigDecimal newSalary;
	
	@Column(nullable = false)
	private String oldDesignation;
	
	@Column(nullable = false)
	private String newDesignation;
	
	@Column(nullable = false)
	private LocalDateTime changedAt;
	
	public EmployeeSalaryHistory() {
	}

	public Long getHistoryId() {
		return historyId;
	}

	public void setHistoryId(Long historyId) {
		this.historyId = historyId;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public BigDecimal getOldSalary() {
		return oldSalary;
	}

	public void setOldSalary(BigDecimal oldSalary) {
		this.oldSalary = oldSalary;
	}

	public BigDecimal getNewSalary() {
		return newSalary;
	}

	public void setNewSalary(BigDecimal newSalary) {
		this.newSalary = newSalary;
	}

	public String getOldDesignation() {
		return oldDesignation;
	}

	public void setOldDesignation(String oldDesignation) {
		this.oldDesignation = oldDesignation;
	}

	public String getNewDesignation() {
		return newDesignation;
	}

	public void setNewDesignation(String newDesignation) {
		this.newDesignation = newDesignation;
	}

	public LocalDateTime getChangedAt() {
		return changedAt;
	}

	public void setChangedAt(LocalDateTime changedAt) {
		this.changedAt = changedAt;
	}	
}
