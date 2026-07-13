package com.example.AIRBNBCLONE.exception;

public class UnAuthorisedException extends RuntimeException{
    public UnAuthorisedException(String message){
        super(message);
    }
}
