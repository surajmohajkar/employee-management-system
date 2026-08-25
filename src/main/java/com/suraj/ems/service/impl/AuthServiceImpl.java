package com.suraj.ems.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import com.suraj.ems.dto.AuthResponseDTO;
import com.suraj.ems.dto.LoginRequestDTO;
import com.suraj.ems.dto.RegisterRequestDTO;
import com.suraj.ems.entity.User;
import com.suraj.ems.enums.Role;
import com.suraj.ems.repository.UserRepository;
import com.suraj.ems.security.JwtService;
import com.suraj.ems.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService{
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	private final AuthenticationManager authenticationManager;
	private final JwtService jwtService;
	
	public AuthServiceImpl(UserRepository userRepository,PasswordEncoder passwordEncoder,
			AuthenticationManager authenticationManager,JwtService jwtService) {

	    this.userRepository = userRepository;
	    this.passwordEncoder = passwordEncoder;
	    this.authenticationManager = authenticationManager;
	    this.jwtService=jwtService;
	}
	
	@Override
	@Transactional
	public AuthResponseDTO register(RegisterRequestDTO requestDTO) {

	    if (userRepository.existsByUsername(requestDTO.getUsername())) {
	        throw new IllegalArgumentException(
	                "Username already exists: " + requestDTO.getUsername());
	    }

	    User user = new User();

	    user.setUsername(requestDTO.getUsername());

	    String encodedPassword =
	            passwordEncoder.encode(requestDTO.getPassword());

	    user.setPassword(encodedPassword);

	    user.setRole(Role.EMPLOYEE);

	    user.setEnabled(true);

	    User savedUser = userRepository.save(user);

	    return new AuthResponseDTO(
	            savedUser.getUserId(),
	            savedUser.getUsername(),
	            savedUser.getRole(),
	            savedUser.isEnabled(),
	            null
	    );
	}
	
	@Override
	@Transactional(readOnly = true)
	public AuthResponseDTO login(LoginRequestDTO requestDTO) {

	    var authentication = authenticationManager.authenticate(
	            new UsernamePasswordAuthenticationToken(requestDTO.getUsername(),requestDTO.getPassword()));

	    User user = userRepository.findByUsername(requestDTO.getUsername()).orElseThrow(() ->
	            new IllegalArgumentException("User not found: "+ requestDTO.getUsername()));

	    String token = jwtService.generateToken(
	            (org.springframework.security.core.userdetails.UserDetails)authentication.getPrincipal());

	    return new AuthResponseDTO(
	            user.getUserId(),
	            user.getUsername(),
	            user.getRole(),
	            user.isEnabled(),
	            token
	    );
	}
}