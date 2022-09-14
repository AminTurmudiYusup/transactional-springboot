package com.example.transactional.exception;

public class ResourceEmptyException extends RuntimeException{
    public ResourceEmptyException(String message){
        super(message);
    }
}
