package com.miniprj.controller;

import com.miniprj.dto.request.EmployeeCreateRequest;
import com.miniprj.dto.response.EmployeeResponse;
import com.miniprj.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	private final EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping("/employees")
	public List<EmployeeResponse> getAllEmployees() {
		return employeeService.getAllEmployees();
	}

	@PostMapping("/employee")
	public void createEmployee(@RequestBody EmployeeCreateRequest request) {
		employeeService.createEmployee(request);
	}
}
