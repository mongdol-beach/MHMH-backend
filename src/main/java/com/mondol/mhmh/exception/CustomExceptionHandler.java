package com.mondol.mhmh.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(CustomException.class)
    protected ResponseEntity<CustomException> handleCustomException(CustomException e){
        System.out.print("커스텀:" + e.getStatusCode());
        return ResponseEntity.status(e.getStatusCode()).body(e);
    }
}