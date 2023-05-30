package com.stemMedics.exceptionHandling;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;


@ControllerAdvice
public class ExceptionHandling {

	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleDoctorNotFoundException (DoctorNotFoundException ex, WebRequest request){
		ErrorResponse response = new ErrorResponse(LocalDate.now(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<ErrorResponse>(response,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleAllException (Exception ex, WebRequest request){
		ErrorResponse response = new ErrorResponse(LocalDate.now(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<ErrorResponse>(response,HttpStatus.BAD_REQUEST);
	}
	
}
