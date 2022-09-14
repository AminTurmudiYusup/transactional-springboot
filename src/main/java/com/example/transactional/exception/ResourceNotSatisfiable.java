package com.example.transactional.exception;

public class ResourceNotSatisfiable extends RuntimeException{

    public ResourceNotSatisfiable(String message){
        super(message);
    }
}
