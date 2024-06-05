package com.devsuperior.integrations.service.exceptions;

public class SendEmailException extends RuntimeException{

    public SendEmailException(String msg){
        super(msg);
    }
}
