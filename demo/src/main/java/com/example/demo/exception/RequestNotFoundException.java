package com.example.demo.exception;

import java.util.List;

public class RequestNotFoundException extends ApiRequestException{
    public RequestNotFoundException(String message) {
        super(message);
    }

    public RequestNotFoundException(String msg, List<String> errors) {
        super(msg, errors);
    }
}
