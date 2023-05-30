package com.stemMedics.pojo;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class DoctorLoginData {

	@Email
	private String email;
	
	@NotBlank
	private String password;
	
}
