package com.auroracode.springboot.satelitesRestApi.rest;

import com.auroracode.springboot.satelitesRestApi.entity.Satelite;
import com.auroracode.springboot.satelitesRestApi.exception.SateliteErrorResponse;
import com.auroracode.springboot.satelitesRestApi.exception.SateliteNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class SateliteRestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<SateliteErrorResponse> handleException(SateliteNotFoundException sateliteException){
        SateliteErrorResponse sateliteErrorResponse = new SateliteErrorResponse();
        sateliteErrorResponse.setEstatus(HttpStatus.NOT_FOUND.value());
        sateliteErrorResponse.setMensaje(sateliteException.getMessage());
        return new ResponseEntity<>(sateliteErrorResponse,HttpStatus.NOT_FOUND);
    }
}
