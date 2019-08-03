package com.stackroute.muzix.exceptions;

public class UserNotFoundException extends Exception {
    //USER DEFINED EXCEPTION

    private String message;
    public UserNotFoundException(String message)
    {
        super(message);
        this.message=message;
    }
}