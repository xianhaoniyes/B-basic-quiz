package com.thoughtworks.gtb.myquiz.exceptionHandler;


import com.thoughtworks.gtb.myquiz.exception.EducationNotFoundException;
import com.thoughtworks.gtb.myquiz.exception.NoSuchUserException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(EducationNotFoundException.class)
    public ResponseEntity<ErrorResult> handleEducationNotFoundException(EducationNotFoundException ex){
        ErrorResult errorResult= new ErrorResult(LocalDateTime.now(),HttpStatus.NOT_FOUND,404,ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResult);
    }

    @ExceptionHandler(NoSuchUserException.class)
    public ResponseEntity<ErrorResult> handleNoSuchUserException(NoSuchUserException ex){
        ErrorResult errorResult= new ErrorResult(LocalDateTime.now(),HttpStatus.NOT_FOUND,404,ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResult);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResult> MethodArgumentNotValidException(MethodArgumentNotValidException ex){

        FieldError error = ex.getBindingResult().getFieldError();

        String errorMessage = error!=null? error.getDefaultMessage():"Something went wrong";
        ErrorResult errorResult= new ErrorResult(LocalDateTime.now(),
                                                HttpStatus.BAD_REQUEST,400,
                                                errorMessage);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResult);
    }



}
