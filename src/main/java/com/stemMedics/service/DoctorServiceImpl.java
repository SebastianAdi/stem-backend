package com.stemMedics.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stemMedics.dao.DoctorRepository;
import com.stemMedics.entity.Doctor;
import com.stemMedics.exceptionHandling.DoctorNotFoundException;
import com.stemMedics.exceptionHandling.ValidationException;
import com.stemMedics.pojo.DoctorLoginData;

@Service
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	private DoctorRepository doctorRepository;
	
	@Override
	public Doctor registerDoctor(Doctor doctor) {
		Doctor findByEmail = doctorRepository.findByEmail(doctor.getEmail());
		if(findByEmail != null)
			throw new ValidationException("email already exists");
		
		Doctor findByPhone = doctorRepository.findByPhone(doctor.getPhone());
		if(findByPhone != null)
			throw new ValidationException("phone already exists");
		
		return doctorRepository.save(doctor);
	}
	
	@Override
	public Doctor loginDoctor(DoctorLoginData data) {
		Doctor doctor = doctorRepository.findByEmailAndPassword(data.getEmail(), data.getPassword());
		if(doctor==null)
			throw new DoctorNotFoundException("doctor not found with given credentials");
		
		return doctor;
	}
	
	@Override
	public List<Doctor> getAllDoctors(){
		return doctorRepository.findAll();
	}
	
	@Override
	public Doctor getDoctorById(int id) {
		Optional<Doctor> doctor = doctorRepository.findById(id);
		if(doctor.isEmpty())
			throw new DoctorNotFoundException("Doctor not found with id : "+id);
		else
			return doctor.get();
	}

	@Override
	public Doctor updateDoctor(Doctor doctor) {
		return doctorRepository.save(doctor);
	}

}
