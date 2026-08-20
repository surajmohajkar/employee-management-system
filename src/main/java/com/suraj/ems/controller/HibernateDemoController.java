package com.suraj.ems.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suraj.ems.service.HibernateDemoService;

@RestController
@RequestMapping("/api/hibernate-demo")
public class HibernateDemoController {
	private final HibernateDemoService hibernateDemoService;
	 public HibernateDemoController(HibernateDemoService hibernateDemoService) {
	        this.hibernateDemoService = hibernateDemoService;
	    }
	 @GetMapping("/cache/{id}")
	 public ResponseEntity<String>testFirstLevelCache(@PathVariable Long id){
		 hibernateDemoService.testFirstLevelCache(id);
		 return ResponseEntity.ok("First-level cache test completed. Check console.");
	 }
	 
	 @GetMapping("/dirty-checking/{id}")
	 public ResponseEntity<String>testDirtyChecking(@PathVariable Long id){
		 hibernateDemoService.testDirtyChecking(id);
		 return ResponseEntity.ok("Dirty checking test completed check console.");
	 }
}
