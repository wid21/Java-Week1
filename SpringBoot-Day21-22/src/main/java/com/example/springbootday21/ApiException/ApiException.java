package com.example.springbootday21.ApiException;

public class ApiException extends RuntimeException{
    public ApiException(String message){
        super(message);
    }
}
