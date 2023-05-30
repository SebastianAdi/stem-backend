package com.stemMedics.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stemMedics.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
