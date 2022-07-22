package com.stage.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.stage.demo.model.EmployeEntity;

import com.stage.demo.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	// get all employees

	@GetMapping
	ResponseEntity<List<EmployeEntity>> getALLEmployees() {

		List<EmployeEntity> employees = employeeService.getAllEmpl();
		return ResponseEntity.ok(employees);
	}

	@PostMapping
	ResponseEntity<String> AddEmployee(@RequestBody EmployeEntity c) {
		employeeService.save(c);
		return ResponseEntity.ok("Employee Added Successfully ");
	}

	@DeleteMapping("{id}")
	ResponseEntity<String> delete(EmployeEntity c) {

		employeeService.delete(c);
		return ResponseEntity.ok("EmployeeDeleted");
	}

}
