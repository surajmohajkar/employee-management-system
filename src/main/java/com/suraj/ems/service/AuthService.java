package com.suraj.ems.service;

import com.suraj.ems.dto.AuthResponseDTO;
import com.suraj.ems.dto.LoginRequestDTO;
import com.suraj.ems.dto.RegisterRequestDTO;;

public interface AuthService {
	AuthResponseDTO register(RegisterRequestDTO requestDTO);
	
	AuthResponseDTO login(LoginRequestDTO requestDTO);
}
