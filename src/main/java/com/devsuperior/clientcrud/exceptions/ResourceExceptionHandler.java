package com.devsuperior.clientcrud.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {
    private static final HttpStatus NOT_FOUND = HttpStatus.NOT_FOUND;

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> entityNotFound(ResourceNotFoundException e, HttpServletRequest request) {
        StandardError err = new StandardError.StandardErrorBuilder()
                .timestamp(Instant.now())
                .status(NOT_FOUND.value())
                .error("Entity Not Found")
                .message(e.getMessage())
                .path(request.getRequestURI())
                .build();
        return ResponseEntity.status(NOT_FOUND.value()).body(err);
    }
}
