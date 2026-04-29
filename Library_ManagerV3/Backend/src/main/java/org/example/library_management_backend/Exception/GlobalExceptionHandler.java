package org.example.library_management_backend.Exception;

import jakarta.servlet.http.HttpServletRequest;
import org.example.library_management_backend.Exception.BookException.BookNotFoundException;
import org.example.library_management_backend.Exception.UserException.UserNotFoundException;
import org.example.library_management_backend.Configuration.ErrorResponse;
import org.example.library_management_backend.Configuration.ResponseCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRunTimeException(RuntimeException ex){
        return ResponseEntity.status(ResponseCode.ERROR.getCode()).body(ex.getMessage());
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleUserNotFound(
            UserNotFoundException ex, HttpServletRequest request
    ){
        ErrorResponse error = new ErrorResponse(
                LocalDateTime.now(),
                ResponseCode.NOT_FOUND.getCode(),
                "Not Found",
                ex.getMessage(),
                request.getRequestURI()
        );
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleBookNotFound(
            BookNotFoundException ex, HttpServletRequest request
    ){
        ErrorResponse error = new ErrorResponse(
            LocalDateTime.now(),
                ResponseCode.NOT_FOUND.getCode(),
                "Not Found",
                ex.getMessage(),
                request.getRequestURI()
        );
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }



}
