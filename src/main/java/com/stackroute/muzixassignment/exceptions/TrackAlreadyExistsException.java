package com.stackroute.muzixassignment.exceptions;

public class TrackAlreadyExistsException extends Exception{
    //USER DEFINED EXCEPTION

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
