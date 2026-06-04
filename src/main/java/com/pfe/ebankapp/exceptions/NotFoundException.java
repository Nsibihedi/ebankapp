package com.pfe.ebankapp.exceptions;
public class NotFoundException  extends RuntimeException{
    public NotFoundException(String error){
        super(error);
    }
}
