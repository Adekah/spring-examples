package com.adekah.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler({EntityNotFoundException.class})
    public String entityNotFound() {
        return "Record Not Found";
    }

    @ExceptionHandler({IllegalArgumentException.class})
    public String illegalArgumentException() {
        return "Wrong Parameter";
    }

}
