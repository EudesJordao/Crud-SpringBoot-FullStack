package net.javaguides.springboot.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.http.HttpStatus;

public class HandlerExceptionResolver {
    

    @ExceptionHandler(DataException.class)
    public ResponseEntity<StandardError> objectNotFoundException(DataException e){
        StandardError error = new StandardError(System.currentTimeMillis(),
            HttpStatus.BAD_REQUEST.value(), e.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);    
    }
}
