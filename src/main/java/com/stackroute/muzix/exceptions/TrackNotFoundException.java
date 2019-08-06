package com.stackroute.muzix.exceptions;

public class TrackNotFoundException extends Exception {
    //USER DEFINED EXCEPTION

    private String message;
    public TrackNotFoundException(String message)
    {
        super(message);
        this.message=message;
    }
}