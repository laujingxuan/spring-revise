package com.example.restcontroller.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {

    //Will catch studentNotFoundException
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){
        StudentErrorResponse err = new StudentErrorResponse();
        err.setStatus(HttpStatus.NOT_FOUND.value());
        err.setMessage((exc.getMessage()));
        err.setTimeStamp((System.currentTimeMillis()));

        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
    }

    // To catch any other exception
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exc){
        StudentErrorResponse err = new StudentErrorResponse();
        err.setStatus(HttpStatus.BAD_REQUEST.value());
        err.setMessage((exc.getMessage()));
        err.setTimeStamp((System.currentTimeMillis()));

        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }

}
