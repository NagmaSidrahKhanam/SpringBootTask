package com.stackroute.muzixassignment.exceptions;

public class TrackAlreadyExistsException extends Exception{
    //user defined exception
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
