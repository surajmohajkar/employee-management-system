package com.suraj.ems.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class RegisterRequestDTO {
	
	@NotBlank(message = "Username is required")
	@Size(min=4, max=100, message = "Username must be between 4 and 100 characters")
	private String username;
	
	@NotBlank(message="Password is required")
	@Size(min=8, max=100, message="Password must be between 8 and 100 characters")
	private String password;
	
	public RegisterRequestDTO() {
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
