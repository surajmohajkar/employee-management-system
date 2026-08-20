package com.suraj.ems.service;

public interface HibernateDemoService {
	void testFirstLevelCache(Long employeeId);
	void testDirtyChecking(Long employeeId);
}
