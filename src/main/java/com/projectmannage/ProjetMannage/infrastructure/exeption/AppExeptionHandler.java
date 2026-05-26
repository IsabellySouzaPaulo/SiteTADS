package com.projectmannage.ProjetMannage.infrastructure.exeption;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice

public class AppExeptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = ResquestExeption.class)
    public ResponseEntity<Object> handleRequestException(ResquestExeption ex, WebRequest request) {
        return handleException(ex, ex.getErrorCode(), ex.getMessage(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Object> handleGenericException(Exception ex, WebRequest request) {
        return handleException(ex, null, ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }
    private ResponseEntity<Object> handleException(
            Exception ex,
            String errorCode,
            String message,
            HttpStatus status,
            WebRequest request
    ){
        ServletWebRequest servletWebRequest = (ServletWebRequest) request;
        return handleExceptionInternal(
                ex,
                new RestError(
                        "XYZ",
                        ex.getMessage(),
                        HttpStatus.INTERNAL_SERVER_ERROR.value(),
                        servletWebRequest.getRequest().getRequestURI()
                ),
                new HttpHeaders(),
                HttpStatus.INTERNAL_SERVER_ERROR,
                request
        );
    }
}