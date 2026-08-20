package com.suraj.ems.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.suraj.ems.dto.EmployeeSalaryHistoryResponseDTO;
import com.suraj.ems.entity.Employee;
import com.suraj.ems.entity.EmployeeSalaryHistory;
import com.suraj.ems.repository.EmployeeSalaryHistoryRepository;

@Service
public class LazyLoadingDemoServiceImpl implements LazyLoadingDemoService {

    private final EmployeeSalaryHistoryRepository historyRepository;

    public LazyLoadingDemoServiceImpl(EmployeeSalaryHistoryRepository historyRepository) {

        this.historyRepository = historyRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public EmployeeSalaryHistoryResponseDTO getHistory(Long historyId) {

        EmployeeSalaryHistory history =historyRepository.findByIdWithEmployee(historyId)
                        .orElseThrow(() ->new RuntimeException("Salary history not found: " + historyId));

        Employee employee = history.getEmployee();

        String employeeName =employee.getFirstName() + " " + employee.getLastName();

        return new EmployeeSalaryHistoryResponseDTO(history.getHistoryId(),
                employee.getEmployeeId(),employeeName,history.getOldSalary(),history.getNewSalary(),
                history.getOldDesignation(),history.getNewDesignation(),history.getChangedAt());
    }
}