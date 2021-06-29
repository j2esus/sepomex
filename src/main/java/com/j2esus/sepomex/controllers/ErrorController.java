package com.j2esus.sepomex.controllers;

import com.j2esus.sepomex.exceptions.FunctionalException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorController {

  @ExceptionHandler(value = FunctionalException.class)
  public ResponseEntity<String> functionalException(FunctionalException functionalException){
    return new ResponseEntity<String>(functionalException.getMessage(), 
      HttpStatus.SERVICE_UNAVAILABLE);
  }
}
