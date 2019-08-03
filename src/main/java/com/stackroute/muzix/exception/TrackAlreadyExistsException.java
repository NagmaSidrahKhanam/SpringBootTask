package com.stackroute.muzix.exception;

public class TrackAlreadyExistsException extends Exception {
//    to create our own exceptions which are basically derived classes of Exception Class.
private String message;

    public TrackAlreadyExistsException() {
    }

    public TrackAlreadyExistsException(String message) {
        super(message);
        this.message = message;
    }
}
