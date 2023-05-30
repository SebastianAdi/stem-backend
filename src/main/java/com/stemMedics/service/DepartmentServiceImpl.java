package com.stemMedics.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stemMedics.dao.DepartmentRepository;
import com.stemMedics.entity.Department;
import com.stemMedics.exceptionHandling.DepartmentNotFoundException;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public List<Department> getAllDepartment() {
		return departmentRepository.findAll();
	}

	@Override
	public Department getDepartmentById(int id) {
		Optional<Department> department = departmentRepository.findById(id);
		if(department.isEmpty())
			throw new DepartmentNotFoundException("department not found with id : "+id);
		
		return department.get();
	}

}
