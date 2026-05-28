package com.example.MajorProject.exception;

public class CabNotAvailable extends RuntimeException {
    public CabNotAvailable(String message) {
        super(message);
    }
}
