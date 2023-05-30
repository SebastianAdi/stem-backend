package com.stemMedics.service;

import java.util.List;

import com.stemMedics.entity.Doctor;
import com.stemMedics.pojo.DoctorLoginData;

public interface DoctorService {
	
	public Doctor registerDoctor(Doctor doctor);
	
	public Doctor loginDoctor(DoctorLoginData data);
	
	public List<Doctor> getAllDoctors();
	
	public Doctor getDoctorById(int id);
	
	public Doctor updateDoctor(Doctor doctor);
}
