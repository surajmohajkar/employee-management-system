package com.suraj.ems.service;

import java.util.List;

import com.suraj.ems.entity.Employee;

public interface EmployeeService {

    Employee saveEmployee(Employee employee);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(Long employeeId);

    Employee updateEmployee(Long employeeId, Employee employee);

    void deleteEmployee(Long employeeId);

}