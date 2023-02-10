package com.project.springboot.personalrest.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;



@ControllerAdvice
public class PersonalRestExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<PersonalErrorResponse> handleException(PersonalNotFoundException exc) {
		
		
		PersonalErrorResponse error = new PersonalErrorResponse(
											HttpStatus.NOT_FOUND.value(),
											exc.getMessage(),
											System.currentTimeMillis());
		
		// return ResponseEntity
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	

	@ExceptionHandler
	public ResponseEntity<PersonalErrorResponse> handleException(Exception exc) {
		
		// create CustomerErrorResponse
		
		PersonalErrorResponse error = new PersonalErrorResponse(
											HttpStatus.BAD_REQUEST.value(),
											exc.getMessage(),
											System.currentTimeMillis());
		
		// return ResponseEntity
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
}
