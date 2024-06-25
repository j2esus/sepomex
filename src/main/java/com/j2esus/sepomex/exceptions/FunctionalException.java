package com.j2esus.sepomex.exceptions;

public class FunctionalException extends RuntimeException{

  public FunctionalException(String message, Exception exception){
    super(message, exception);
  }
}
