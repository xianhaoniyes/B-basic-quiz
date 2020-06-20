package com.thoughtworks.gtb.myquiz.ExceptionHandler;


import com.thoughtworks.gtb.myquiz.Exception.EducationNotFoundException;
import com.thoughtworks.gtb.myquiz.Exception.NoSuchUserException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(EducationNotFoundException.class)
    public ResponseEntity<ErrorResult> handleEducationNotFoundException(EducationNotFoundException ex){
        ErrorResult errorResult= new ErrorResult(LocalDateTime.now(),HttpStatus.NOT_FOUND,"Education record not found",ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResult);
    }

    @ExceptionHandler(NoSuchUserException.class)
    public ResponseEntity<ErrorResult> handleNoSuchUserException(NoSuchUserException ex){
        ErrorResult errorResult= new ErrorResult(LocalDateTime.now(),HttpStatus.NOT_FOUND,"User not found",ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResult);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResult> MethodArgumentNotValidException(MethodArgumentNotValidException ex){
        ErrorResult errorResult= new ErrorResult(LocalDateTime.now(),
                                                HttpStatus.BAD_REQUEST,"the data you send does not match our constraints",
                                                ex.getLocalizedMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResult);
    }



}
