package com.stemMedics.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.stemMedics.entity.Department;
import com.stemMedics.service.DepartmentService;

@RestController
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	
	@GetMapping("/departments")
	public List<Department> getAllDepartment(){
		return departmentService.getAllDepartment();
	}
	
	@GetMapping("/departments/{id}")
	public Department getDepartmentById(@PathVariable int id) {
		return departmentService.getDepartmentById(id);
	}
	
}
