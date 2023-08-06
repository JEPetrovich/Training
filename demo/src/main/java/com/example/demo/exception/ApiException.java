package com.example.demo.exception;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

public class ApiException {
    private LocalDateTime timeStamp;
    private HttpStatus status;
    private int code;
    private String message;
    private List<String> errors;
    private String path;

    public ApiException() {
    }

    public ApiException(HttpStatus status, int code, String message, List<String> errors, String path) {
        this.timeStamp = LocalDateTime.now();
        this.status = status;
        this.code = code;
        this.message = message;
        this.errors = errors;
        this.path = path;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
