package com.example.management.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class CustomException extends RuntimeException {
	
	//private static final long serialversionUID =1L;
	
	public CustomException(String message) {
		super(message);
	}

}
