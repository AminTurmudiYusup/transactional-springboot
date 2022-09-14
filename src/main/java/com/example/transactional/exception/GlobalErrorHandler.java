package com.example.transactional.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@RestControllerAdvice
public class GlobalErrorHandler {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<ErrorMessage> handlerEmptyException(ResourceEmptyException resourceEmptyException){
        ErrorMessage errorMessage=new ErrorMessage();
        errorMessage.setStatusCode(String.valueOf(HttpStatus.CONFLICT));
        errorMessage.setMessage(resourceEmptyException.getMessage());
        errorMessage.setDate(new Date());
        return new ResponseEntity<>(errorMessage, HttpStatus.CONFLICT);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ResponseEntity<ErrorMessage> handlerAlreadyExistException(ResourceAlreadyExistException resourceAlreadyExistException){
        ErrorMessage errorMessage=new ErrorMessage();
        errorMessage.setStatusCode(String.valueOf(HttpStatus.UNPROCESSABLE_ENTITY));
        errorMessage.setMessage(resourceAlreadyExistException.getMessage());
        errorMessage.setDate(new Date());
        return new ResponseEntity<>(errorMessage, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE)
    public ResponseEntity<ErrorMessage> handlerRequestRangeNotSatisfy(ResourceNotSatisfiable resourceNotSatisfiable){
        ErrorMessage errorMessage=new ErrorMessage();
        errorMessage.setStatusCode(String.valueOf(HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE));
        errorMessage.setMessage(resourceNotSatisfiable.getMessage());
        errorMessage.setDate(new Date());
        return new ResponseEntity<>(errorMessage, HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE);
    }
}
