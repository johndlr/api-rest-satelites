package com.auroracode.springboot.satelitesRestApi.exception;

public class SateliteNotFoundException extends RuntimeException{

    public SateliteNotFoundException(String message) {
        super(message);
    }
}
