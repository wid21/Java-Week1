package com.example.springbootday25.ApiException;

public class ApiException extends RuntimeException{
    public ApiException(String message){
        super(message);
    }
}
