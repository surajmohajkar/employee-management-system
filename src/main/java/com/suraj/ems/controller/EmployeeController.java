package com.suraj.ems.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.suraj.ems.dto.EmployeePatchDTO;
import com.suraj.ems.dto.EmployeeRequestDTO;
import com.suraj.ems.dto.EmployeeResponseDTO;
import com.suraj.ems.dto.EmployeeSalaryHistoryResponseDTO;
import com.suraj.ems.dto.EmployeeUpdateRequestDTO;
import com.suraj.ems.dto.PromotionRequestDTO;
import com.suraj.ems.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // =========================================================
    // CREATE EMPLOYEE
    // ADMIN + MANAGER
    // =========================================================

    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER')")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeResponseDTO saveEmployee(
            @Valid @RequestBody EmployeeRequestDTO requestDTO) {

        return employeeService.saveEmployee(requestDTO);
    }

    // =========================================================
    // GET ALL EMPLOYEES
    // ADMIN + MANAGER + EMPLOYEE
    // =========================================================

    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER', 'EMPLOYEE')")
    @GetMapping
    public Page<EmployeeResponseDTO> getAllEmployees(
            @PageableDefault(size = 10, sort = "employeeId") Pageable pageable) {

        return employeeService.getAllEmployees(pageable);
    }

    // =========================================================
    // GET EMPLOYEE BY ID
    // ADMIN + MANAGER + EMPLOYEE
    // =========================================================

    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER', 'EMPLOYEE')")
    @GetMapping("/{employeeId}")
    public EmployeeResponseDTO getEmployeeById(
            @PathVariable Long employeeId) {

        return employeeService.getEmployeeById(employeeId);
    }

    // =========================================================
    // UPDATE EMPLOYEE
    // ADMIN + MANAGER
    // =========================================================

    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER')")
    @PutMapping("/{id}")
    public EmployeeResponseDTO updateEmployee(
            @PathVariable Long id,@Valid @RequestBody EmployeeUpdateRequestDTO requestDTO) {

        return employeeService.updateEmployee(id, requestDTO);
    }

    // =========================================================
    // DELETE EMPLOYEE
    // ADMIN ONLY
    // =========================================================

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEmployee(
            @PathVariable Long id) {

        employeeService.deleteEmployee(id);
    }

    // =========================================================
    // PATCH EMPLOYEE
    // ADMIN + MANAGER
    // =========================================================

    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER')")
    @PatchMapping("/{id}")
    public EmployeeResponseDTO patchEmployee(
            @PathVariable Long id,@Valid @RequestBody EmployeePatchDTO patchDTO) {

        return employeeService.patchEmployee(id, patchDTO);
    }

    // =========================================================
    // SEARCH EMPLOYEES BY DEPARTMENT
    // ADMIN + MANAGER + EMPLOYEE
    // =========================================================

    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER', 'EMPLOYEE')")
    @GetMapping("/search")
    public Page<EmployeeResponseDTO> searchEmployeesByDepartment(
            @RequestParam String department,@PageableDefault(size = 10, sort = "employeeId") Pageable pageable) {

        return employeeService.searchEmployeesByDepartment(
                department,
                pageable
        );
    }

    // =========================================================
    // PROMOTE EMPLOYEE
    // ADMIN + MANAGER
    // =========================================================

    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER')")
    @PostMapping("/{id}/promotion")
    public EmployeeResponseDTO promoteEmployee(
            @PathVariable Long id,@Valid @RequestBody PromotionRequestDTO requestDTO) {

        return employeeService.promoteEmployee(id, requestDTO);
    }

    // =========================================================
    // GET SALARY HISTORY
    // ADMIN + MANAGER + EMPLOYEE
    // =========================================================

    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER', 'EMPLOYEE')")
    @GetMapping("/{id}/salary-history")
    public List<EmployeeSalaryHistoryResponseDTO> getSalaryHistory(
            @PathVariable Long id) {

        return employeeService.getSalaryHistory(id);
    }
}