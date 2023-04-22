package com.oualid.validation_and_exception_handling.models.exceptions;

public class UsersFoundedNumberLessThanFiveException extends RuntimeException{
    public UsersFoundedNumberLessThanFiveException(String message){
        super(message);
    }
}
