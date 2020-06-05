package com.challenge.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerExceptionHandler extends SimpleMappingExceptionResolver {

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<StandardError> wrongRequestParam(MethodArgumentTypeMismatchException e, HttpServletRequest request) {

        String msg = "Valores inválidos na requisição";

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(StandardError
                        .of(HttpStatus.BAD_REQUEST.value(), System.currentTimeMillis(), msg));
    }


    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(StandardError
                        .of(HttpStatus.NOT_FOUND.value(), System.currentTimeMillis(), e.getMessage()));
    }
}
