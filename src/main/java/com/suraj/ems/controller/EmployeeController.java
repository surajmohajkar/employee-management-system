package com.suraj.ems.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.suraj.ems.dto.EmployeeRequestDTO;
import com.suraj.ems.dto.EmployeeResponseDTO;
import com.suraj.ems.service.EmployeeService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	private final EmployeeService employeeService;
	   
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	//Create Employee
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public EmployeeResponseDTO saveEmployee(@Valid @RequestBody EmployeeRequestDTO requestDTO) {
		return employeeService.saveEmployee(requestDTO);
	}
	
	//Get All Employee
	@GetMapping
	public List<EmployeeResponseDTO>getAllEmployees(){
		return employeeService.getAllEmployees();
	}
	
	//Get Employee By ID
	@GetMapping("/{id}")
	public EmployeeResponseDTO getEmployeeById(@PathVariable Long id) {
		return employeeService.getEmployeeById(id);
	}
	
	//Update Employee
	@PutMapping("/{id}")
    public EmployeeResponseDTO updateEmployee(@PathVariable Long id, @Valid @RequestBody EmployeeRequestDTO requestDTO) {
        return employeeService.updateEmployee(id, requestDTO);
    }
	
	//Delete Employee
	@DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }

}
