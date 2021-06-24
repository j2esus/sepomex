package com.j2esus.sepomex.exceptions;

public class FunctionalException extends RuntimeException{
  
  public FunctionalException(){
    super();
  }

  public FunctionalException(String message){
    super(message);
  }

  public FunctionalException(String message, Exception exception){
    super(message, exception);
  }
}
