package com.example.demo.exception;

import java.util.List;

public class RequestSystemException extends ApiRequestException{
    public RequestSystemException(String message) {
        super(message);
    }

    public RequestSystemException(String msg, List<String> errors) {
        super(msg, errors);
    }

}
