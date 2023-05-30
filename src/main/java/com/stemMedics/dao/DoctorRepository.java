package com.stemMedics.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stemMedics.entity.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer>{

	public Doctor findByEmail(String email);
	
	public Doctor findByPhone(String phone);
	
	public Doctor findByEmailAndPassword(String email, String password);
	
}
