package com.stackroute.muzix.exception;

public class TrackNotFoundException extends Exception {
//    to create our own exceptions which are basically derived classes of Exception Class.
    private String message;

    public TrackNotFoundException() {
    }

    public TrackNotFoundException(String message) {
        super(message);
        this.message = message;
    }
}
