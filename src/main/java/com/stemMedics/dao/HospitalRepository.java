package com.stemMedics.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stemMedics.entity.Hospital;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Integer>{

}
