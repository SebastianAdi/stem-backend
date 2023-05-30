package com.stemMedics.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.stemMedics.entity.Doctor;
import com.stemMedics.exceptionHandling.ValidationException;
import com.stemMedics.pojo.DoctorLoginData;
import com.stemMedics.service.DoctorService;

import jakarta.validation.Valid;

@RestController
public class DoctorController {
	
	@Autowired
	private DoctorService doctorService;
	
	@GetMapping("/doctors")
	public List<Doctor> findAllDoctors(){
		return doctorService.getAllDoctors();
	}
	
	@GetMapping("/doctors/{id}")
	public Doctor findDoctorById(@PathVariable int id) {
		return doctorService.getDoctorById(id);
	}
	
	@PostMapping("/doctors/register")
	public Doctor registerDoctor(@Valid @RequestBody Doctor doctor, BindingResult result) {
		if(result.hasErrors())
			throw new ValidationException("validation failed");
		
		return doctorService.registerDoctor(doctor);
	}
	
	@GetMapping("/doctors/login")
	public Doctor loginDoctor(@Valid @RequestBody DoctorLoginData data, BindingResult result) {
		if(result.hasErrors())
			throw new ValidationException("validation failed");
		
		return doctorService.loginDoctor(data);
	}
	
	
	@PutMapping("/doctors")
	public Doctor updateDoctor(@Valid @RequestBody Doctor doctor, BindingResult result) {
		if(result.hasErrors())
			throw new ValidationException("validation failed");
		return doctorService.updateDoctor(doctor);
	}
	
}
