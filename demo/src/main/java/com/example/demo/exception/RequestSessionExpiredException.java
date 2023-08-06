package com.example.demo.exception;

import java.util.List;

public class RequestSessionExpiredException extends ApiRequestException{
    public RequestSessionExpiredException(String message) {
        super(message);
    }

    public RequestSessionExpiredException(String errorMessage, List<String> errors) {
        super(errorMessage, errors);
    }
}
