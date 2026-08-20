package com.suraj.ems.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.suraj.ems.entity.EmployeeSalaryHistory;

public interface EmployeeSalaryHistoryRepository
        extends JpaRepository<EmployeeSalaryHistory, Long> {

    @Query("""
            SELECT h
            FROM EmployeeSalaryHistory h
            JOIN FETCH h.employee
            WHERE h.historyId = :historyId
            """)
    Optional<EmployeeSalaryHistory> findByIdWithEmployee(
            @Param("historyId") Long historyId);
}