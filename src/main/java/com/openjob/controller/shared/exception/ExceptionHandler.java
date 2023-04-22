package com.openjob.controller.shared.exception;

import com.openjob.controller.shared.response.ResponseDTO;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return new ResponseEntity<>(
                new ResponseDTO(Boolean.FALSE, HttpStatus.BAD_REQUEST.getReasonPhrase(), collectError(ex)),
                HttpStatus.BAD_REQUEST);
    }


    private Map<String, String> collectError(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            errors.put(((FieldError) error).getField(), error.getDefaultMessage());
        });
        if (errors.isEmpty())
            errors.put("errorMessage", ex.getMessage());
        return errors;
    }



    @org.springframework.web.bind.annotation.ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ResponseDTO> handleIllegalArgumentException(IllegalArgumentException ex) {
        return new ResponseEntity<>(
                new ResponseDTO(Boolean.FALSE, ex.getMessage(), null),
                HttpStatus.BAD_REQUEST);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<ResponseDTO> handleResponseStatusException(ResponseStatusException ex) {
        return new ResponseEntity<>(
                new ResponseDTO(Boolean.FALSE, ex.getReason(), null),
                HttpStatus.BAD_REQUEST);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(DuplicateKeyException.class)
    public ResponseEntity<ResponseDTO> handleDuplicateKeyException(DuplicateKeyException ex) {
        String message = ex.getMostSpecificCause().getMessage();
        message = message.substring(message.indexOf("index"));
        message = message.substring(0, message.indexOf("}") + 1);
        return new ResponseEntity<>(
                new ResponseDTO(Boolean.FALSE, message, null),
                HttpStatus.BAD_REQUEST);
    }


    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseDTO> handleException(RuntimeException ex) {
        return new ResponseEntity<>(
                new ResponseDTO(Boolean.FALSE, ex.getCause().getMessage(), null),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
