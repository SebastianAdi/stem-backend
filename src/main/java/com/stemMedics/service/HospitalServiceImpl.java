package com.stemMedics.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stemMedics.dao.HospitalRepository;
import com.stemMedics.entity.Hospital;

@Service
public class HospitalServiceImpl implements HospitalService {
	
	@Autowired
	private HospitalRepository hospitalRepository;

	@Override
	public List<Hospital> getAllHospitals() {
		return hospitalRepository.findAll();
	}

}
