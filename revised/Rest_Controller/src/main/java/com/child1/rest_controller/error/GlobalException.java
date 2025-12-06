package com.child1.rest_controller.error;


import com.child1.rest_controller.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalException {


    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<ErrorResponse> studentNotFoundException(StudentNotFoundException e) {
        ErrorResponse response= new ErrorResponse(
                LocalDateTime.now(),
                e.getMessage(),
                HttpStatus.NOT_FOUND.value()
        );
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);

    }   

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleAllExceptions(Exception e) {
        ErrorResponse response = new ErrorResponse(
                LocalDateTime.now(),
                e.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR.value()
        );
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
