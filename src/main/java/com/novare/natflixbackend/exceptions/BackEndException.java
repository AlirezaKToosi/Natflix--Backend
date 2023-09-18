package com.novare.natflixbackend.exceptions;

import org.springframework.http.HttpStatus;

public class BackEndException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private final HttpStatus status;
    private final String message;

    public BackEndException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public BackEndException(String message, HttpStatus status, String message1) {
        super(message);
        this.status = status;
        this.message = message1;
    }

    public HttpStatus getStatus() {
        return status;
    }

    @Override
    public String getMessage() {
        return message;
    }
}