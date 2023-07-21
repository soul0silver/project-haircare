package com.project.exception;

public class BusinessException extends RuntimeException{
    private int status;


    public BusinessException(int status, String message){
        super(message);
        this.status = status;
    }

}
