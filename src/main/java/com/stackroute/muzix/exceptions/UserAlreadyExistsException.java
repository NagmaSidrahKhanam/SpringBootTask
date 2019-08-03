package com.stackroute.muzix.exceptions;

public class UserAlreadyExistsException extends Exception {
    //user defined exceptions
    private String message;
    public UserAlreadyExistsException()
    {
    }
    public UserAlreadyExistsException(String message)
    {
        super(message);
        this.message=message;
    }
}