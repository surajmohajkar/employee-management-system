package com.suraj.ems.service;

import com.suraj.ems.dto.EmployeeSalaryHistoryResponseDTO;

public interface LazyLoadingDemoService {

    EmployeeSalaryHistoryResponseDTO getHistory(Long historyId);
}