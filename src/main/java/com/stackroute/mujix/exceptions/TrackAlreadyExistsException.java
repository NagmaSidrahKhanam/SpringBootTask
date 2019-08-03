package com.stackroute.mujix.exceptions;

public class TrackAlreadyExistsException extends Exception {
    //user defined exceptions
    private String message;
    public TrackAlreadyExistsException()
    {
    }
    public TrackAlreadyExistsException(String message)
    {
        super(message);
        this.message=message;
    }


}