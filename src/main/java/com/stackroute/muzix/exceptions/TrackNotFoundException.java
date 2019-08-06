package com.stackroute.muzix.exceptions;

public class TrackNotFoundException extends Exception {
    //user defined exceptions
    private String message;
    public TrackNotFoundException(String message)
    {
        super(message);
        this.message=message;
    }
}