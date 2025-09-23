package com.example.management.Exception;

import org.springframework.web.bind.annotation.ResponseStatus;


public class MissingInputException extends CustomException{
    private static final long serialversionUID =1L;

    public MissingInputException(String message) {
        super(message);
    }
}
