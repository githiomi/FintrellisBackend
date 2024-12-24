package com.githiomi.inkvibe.exceptions;

import com.githiomi.inkvibe.data.models.RestResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static com.githiomi.inkvibe.data.enums.ResponseType.EXCEPTION;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestController
@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(ApiException.class)
    @ResponseStatus(BAD_REQUEST)
    public ResponseEntity<RestResponse<String>> handleBlogNotFoundException(ApiException ex) {
        RestResponse<String> response = new RestResponse<>(ex.getMessage(), EXCEPTION);
        return new ResponseEntity<>(response, BAD_REQUEST);
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(BAD_REQUEST)
    public ResponseEntity<RestResponse<String>> handleRuntimeException(RuntimeException ex) {
        RestResponse<String> response = new RestResponse<>(ex.getMessage(), EXCEPTION);
        return ResponseEntity.status(BAD_REQUEST).body(response);
    }
}
