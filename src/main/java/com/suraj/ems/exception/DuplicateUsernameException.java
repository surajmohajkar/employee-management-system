package com.suraj.ems.exception;

public class DuplicateUsernameException extends RuntimeException{
	public DuplicateUsernameException(String message) {
		super(message);
	}
}
