package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = RequestValidationException.class)
    public ResponseEntity<Object> handleValidationException(RequestValidationException e, WebRequest request){
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        ApiException apiException = new ApiException(
                badRequest,
                badRequest.value(),
                e.getMessage(),
                e.getErrors(),
                request.getDescription(false)
        );
        return new ResponseEntity<>(apiException, badRequest);
    }

    @ExceptionHandler(value = RequestNotFoundException.class)
    public ResponseEntity<Object> handleNotFoundException(RequestNotFoundException e, WebRequest request){
        HttpStatus notFound = HttpStatus.NOT_FOUND;
        ApiException apiException = new ApiException(
                notFound,
                notFound.value(),
                e.getMessage(),
                e.getErrors(),
                request.getDescription(false)
        );
        return new ResponseEntity<>(apiException, notFound);
    }

    @ExceptionHandler(value = RequestSystemException.class)
    public ResponseEntity<Object> handleSystemException(RequestSystemException e, WebRequest request){
        HttpStatus serviceUnavailable = HttpStatus.SERVICE_UNAVAILABLE;
        ApiException apiException = new ApiException(
                serviceUnavailable,
                serviceUnavailable.value(),
                e.getMessage(),
                e.getErrors(),
                request.getDescription(false)
        );
        return new ResponseEntity<>(apiException, serviceUnavailable);
    }

    @ExceptionHandler(value = RequestSessionExpiredException.class)
    public ResponseEntity<Object> handleSessionExpiredException(RequestSessionExpiredException e, WebRequest request){
        HttpStatus sessionExpired = HttpStatus.valueOf(401);
        ApiException apiException = new ApiException(
                sessionExpired,
                sessionExpired.value(),
                e.getMessage(),
                e.getErrors(),
                request.getDescription(false)
        );
        return new ResponseEntity<>(apiException, sessionExpired);
    }

    @ExceptionHandler(value = RequestForbbidenException.class)
    public ResponseEntity<Object> handleForbbidenException(RequestForbbidenException e, WebRequest request){
        HttpStatus forbidden = HttpStatus.FORBIDDEN;
        ApiException apiException = new ApiException(
                forbidden,
                forbidden.value(),
                e.getMessage(),
                e.getErrors(),
                request.getDescription(false)
        );
        return new ResponseEntity<>(apiException, forbidden);
    }
}
