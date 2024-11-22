package com.ING_Exercize.INGExercise.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BasicExceptionHandler {

    @ExceptionHandler(CustomExceptionProduct.class)
    public ResponseEntity<String> handleProductNotFoundException(CustomExceptionProduct exception){

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }
}
