package com.suraj.ems.exception;

public class EmployeeVersionConflictException extends RuntimeException {

    public EmployeeVersionConflictException(String message) {
        super(message);
    }
}