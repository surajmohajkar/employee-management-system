package com.suraj.ems.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class EmployeeSalaryHistoryResponseDTO {

    private Long historyId;
    private Long employeeId;
    private String employeeName;

    private BigDecimal oldSalary;
    private BigDecimal newSalary;

    private String oldDesignation;
    private String newDesignation;

    private LocalDateTime changedAt;

    public EmployeeSalaryHistoryResponseDTO() {
    }

    public EmployeeSalaryHistoryResponseDTO(
            Long historyId,
            Long employeeId,
            String employeeName,
            BigDecimal oldSalary,
            BigDecimal newSalary,
            String oldDesignation,
            String newDesignation,
            LocalDateTime changedAt) {

        this.historyId = historyId;
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.oldSalary = oldSalary;
        this.newSalary = newSalary;
        this.oldDesignation = oldDesignation;
        this.newDesignation = newDesignation;
        this.changedAt = changedAt;
    }

    public Long getHistoryId() {
        return historyId;
    }

    public void setHistoryId(Long historyId) {
        this.historyId = historyId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
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