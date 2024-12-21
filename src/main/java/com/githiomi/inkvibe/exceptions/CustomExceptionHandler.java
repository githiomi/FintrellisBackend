package com.githiomi.inkvibe.exceptions;

import com.githiomi.inkvibe.data.models.ApiResponse;
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
    public ResponseEntity<ApiResponse<String>> handleBlogNotFoundException(ApiException ex) {
        ApiResponse<String> response = new ApiResponse<>(ex.getMessage(), EXCEPTION);
        return new ResponseEntity<>(response, BAD_REQUEST);
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(BAD_REQUEST)
    public ResponseEntity<ApiResponse<String>> handleRuntimeException(RuntimeException ex) {
        ApiResponse<String> response = new ApiResponse<>(ex.getMessage(), EXCEPTION);
        return ResponseEntity.status(BAD_REQUEST).body(response);
    }
}
