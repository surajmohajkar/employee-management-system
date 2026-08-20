package com.suraj.ems.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suraj.ems.dto.EmployeeSalaryHistoryResponseDTO;
import com.suraj.ems.service.LazyLoadingDemoService;

@RestController
@RequestMapping("/api/lazy-demo")
public class LazyLoadingDemoController {

    private final LazyLoadingDemoService lazyLoadingDemoService;

    public LazyLoadingDemoController(LazyLoadingDemoService lazyLoadingDemoService) {

        this.lazyLoadingDemoService = lazyLoadingDemoService;
    }

    @GetMapping("/{id}")
    public EmployeeSalaryHistoryResponseDTO testLazyLoading(@PathVariable Long id) {

        return lazyLoadingDemoService.getHistory(id);
    }
}