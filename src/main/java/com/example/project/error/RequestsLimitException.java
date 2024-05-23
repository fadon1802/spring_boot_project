package com.example.project.error;

public class RequestsLimitException extends RuntimeException {
    public RequestsLimitException(String message) {
        super(message);
    }
}
