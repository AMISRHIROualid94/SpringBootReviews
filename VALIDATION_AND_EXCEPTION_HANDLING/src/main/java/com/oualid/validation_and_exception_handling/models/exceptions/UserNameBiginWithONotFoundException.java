package com.oualid.validation_and_exception_handling.models.exceptions;

public class UserNameBiginWithONotFoundException extends RuntimeException{

    public UserNameBiginWithONotFoundException(String message){
        super(message);
    }
}
