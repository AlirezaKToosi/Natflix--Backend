package com.novare.natflixbackend.exceptions;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
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

}