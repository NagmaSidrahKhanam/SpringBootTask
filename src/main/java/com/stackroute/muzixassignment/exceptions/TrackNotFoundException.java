package com.stackroute.muzixassignment.exceptions;

public class TrackNotFoundException extends Exception {
    //USER DEFINED EXCEPTION

    private String message;
    public TrackNotFoundException()
    {

    }
    public TrackNotFoundException(String message)
    {
        super(message);
        this.message=message;
    }
}
