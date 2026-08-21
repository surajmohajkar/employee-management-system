package com.suraj.ems.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.suraj.ems.enums.EmployeeStatus;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="employees", indexes = {@Index(name = "idx_employee_department",columnList="department")})
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long employeeId;

    @Column(name = "first_name", nullable = false, length = 100)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 100)
    private String lastName;

    @Column(name = "email", nullable = false, unique = true, length = 150)
    private String email;

    @Column(name = "phone_number", unique = true, length = 15)
    private String phoneNumber;

    @Column(name = "department", nullable = false, length = 100)
    private String department;

    @Column(name = "designation", nullable = false, length = 100)
    private String designation;

    @Column(name = "salary", nullable = false, precision = 10, scale = 2)
    private BigDecimal salary;

    @Column(name = "joining_date", nullable = false)
    private LocalDate joiningDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private EmployeeStatus status;
    
    @OneToMany(
            mappedBy = "employee",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<EmployeeSalaryHistory> salaryHistories = new ArrayList<>();
    
    public void addSalaryHistory(EmployeeSalaryHistory history) {
        salaryHistories.add(history);
        history.setEmployee(this);
    }
    public void removeSalaryHistory(EmployeeSalaryHistory history) {
        salaryHistories.remove(history);
        history.setEmployee(null);
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
	
	public List<EmployeeSalaryHistory> getSalaryHistories() {
	    return salaryHistories;
	}

	public void setSalaryHistories(List<EmployeeSalaryHistory> salaryHistories) {
	    this.salaryHistories = salaryHistories;
	}
}
