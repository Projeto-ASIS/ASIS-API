package com.Asis.api.configurations.exceptions;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(exception = Exception.class)
    public ResponseEntity<ErrorMesage> globalErrorMesage(Exception ex){
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorMesage(ex.getMessage()));
    }

    @ExceptionHandler(exception = EntityNotFoundException.class)
    public ResponseEntity<ErrorMesage> entityNotFound(EntityNotFoundException ex){
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorMesage(ex.getMessage()));
    }

    @ExceptionHandler(exception = DuplicateKeyException.class)
    public ResponseEntity<ErrorMesage> duplicateKey(DuplicateKeyException ex){
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(new ErrorMesage(ex.getMessage()));
    }

}
