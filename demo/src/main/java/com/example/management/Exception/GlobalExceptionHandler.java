package com.example.management.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	ResponseEntity<String> globalexception(ResourceNotFoundException ex){
		return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
		
	}
	@ExceptionHandler(MissingInputException.class)
	ResponseEntity<String> globalexception(MissingInputException ex){
		return ResponseEntity.badRequest().body("Missing Input: "+ex.getMessage());

	}

}
