package com.example.demo.exception;

import java.util.List;

public class RequestForbbidenException extends ApiRequestException{
    public RequestForbbidenException(String message) {
        super(message);
    }

    public RequestForbbidenException(String errorMessage, List<String> errors) {
        super(errorMessage, errors);
    }
}
