package com.stemMedics.service;

import java.util.List;

import com.stemMedics.entity.Department;

public interface DepartmentService {

	public List<Department> getAllDepartment();
	
	public Department getDepartmentById(int id);
	
}
