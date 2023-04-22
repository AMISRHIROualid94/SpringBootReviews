package com.oualid.validation_and_exception_handling.advice;

import com.oualid.validation_and_exception_handling.models.exceptions.UserNameBiginWithONotFoundException;
import com.oualid.validation_and_exception_handling.models.exceptions.UserNotFoundException;
import com.oualid.validation_and_exception_handling.models.exceptions.UsersFoundedNumberLessThanFiveException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApplicationExceptionsHandler {


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String> handleInvalidArgument(MethodArgumentNotValidException exception){
        Map<String,String> errorMap = new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach(error ->{
            errorMap.put(error.getField(),error.getDefaultMessage());
        });
        return errorMap;
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(UserNotFoundException.class)
    public Map<String,String> handleBusinessException(UserNotFoundException exception){
        Map<String,String> errorMap = new HashMap<>();
        errorMap.put("Error message",exception.getMessage());
        return errorMap;
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(UsersFoundedNumberLessThanFiveException.class)
    public Map<String,String> handleAllUsersException(UsersFoundedNumberLessThanFiveException exception){
        Map<String,String> errorMap = new HashMap<>();
        errorMap.put("Error message",exception.getMessage());
        return errorMap;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(UserNameBiginWithONotFoundException.class)
    public Map<String,String> handleUserNameUpperCaseException(UserNameBiginWithONotFoundException exception){
        Map<String,String> errorMap = new HashMap<>();
        errorMap.put("Error message",exception.getMessage());
        return errorMap;
    }
}
