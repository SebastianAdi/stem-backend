package com.stemMedics.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data 
@NoArgsConstructor 
@AllArgsConstructor
public class Doctor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "doctor_id")
	private int id;

	@NotBlank
	@Column(name = "name")
	private String name;
	
	@NotBlank
	@Column(name = "phone_no")
	private String phone;
	
	@Email
	@Column(name="email")
	private String email;
	
	@NotBlank
	@Column(name = "hospital")
	private String hospital;
	
	@NotBlank
	@Column(name = "department")
	private String speciality;
	
	@NotBlank
	@Column(name = "city")
	private String city;
	
	@Column(name = "experience")
	private int experience;
	
	@NotBlank
	@Column(name = "password")
	private String password;
}
