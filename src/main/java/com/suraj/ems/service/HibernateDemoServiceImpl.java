package com.suraj.ems.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.suraj.ems.entity.Employee;
import com.suraj.ems.repository.EmployeeRepository;

@Service
public class HibernateDemoServiceImpl implements HibernateDemoService{
		private final EmployeeRepository employeeRepository;
		public HibernateDemoServiceImpl(EmployeeRepository employeeRepository) {
	        this.employeeRepository = employeeRepository;
	    }
		@Override
	    @Transactional(readOnly = true)
	    public void testFirstLevelCache(Long employeeId) {

	        System.out.println("========== FIRST DATABASE LOOKUP ==========");

	        Employee employee1 = employeeRepository.findById(employeeId)
	                .orElseThrow(() ->new RuntimeException("Employee not found: " + employeeId));

	        System.out.println("Employee object 1: " +System.identityHashCode(employee1));

	        System.out.println("========== SECOND DATABASE LOOKUP ==========");

	        Employee employee2 = employeeRepository.findById(employeeId).orElseThrow(() 
	        		->new RuntimeException("Employee not found: " + employeeId));

	        System.out.println("Employee object 2: " +System.identityHashCode(employee2));

	        System.out.println("Same Java object: " +(employee1 == employee2));
	    }

	    @Override
	    @Transactional
	    public void testDirtyChecking(Long employeeId) {

	        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() ->
	                        new RuntimeException("Employee not found: " + employeeId));

	        System.out.println("Original salary: " +employee.getSalary());

	        employee.setSalary(employee.getSalary().add(new java.math.BigDecimal("1000")));

	        System.out.println("New salary: " +employee.getSalary());

	        System.out.println("No explicit save() called.");
	    }
	}