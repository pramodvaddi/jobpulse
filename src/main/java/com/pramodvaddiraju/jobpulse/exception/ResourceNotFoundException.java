package com.pramodvaddiraju.jobpulse.exception;

// This class represents a custom exception that you will throw
public class ResourceNotFoundException extends RuntimeException {
    // When someone tries to GET, UPDATE, or DELETE a job that doesn’t exist — instead of returning null, we’ll throw this exception.


    // Constructor for this class that takes a custom message
    public ResourceNotFoundException(String message){
        // Pass message to parent RuntimeException
        super(message);
    }

}
