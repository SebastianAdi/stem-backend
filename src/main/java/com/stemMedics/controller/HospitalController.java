package com.stemMedics.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stemMedics.entity.Hospital;
import com.stemMedics.service.HospitalService;

@RestController
public class HospitalController {

	@Autowired
	private HospitalService hospitalService;
	
	@GetMapping("/hospitals")
	public List<Hospital> getAllHospitals(){
		return hospitalService.getAllHospitals();
	}
	
}
