package com.example.mirrorbackend.Exception;

public class ApiException extends RuntimeException{

    public ApiException(String message) {
        super(message);
    }
}