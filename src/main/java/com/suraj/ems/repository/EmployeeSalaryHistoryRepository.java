package com.suraj.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.suraj.ems.entity.EmployeeSalaryHistory;

@Repository
public interface EmployeeSalaryHistoryRepository
        extends JpaRepository<EmployeeSalaryHistory, Long> {

}