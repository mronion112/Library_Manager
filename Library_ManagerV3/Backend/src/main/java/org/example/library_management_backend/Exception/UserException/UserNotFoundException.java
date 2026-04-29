package org.example.library_management_backend.Exception.UserException;

import org.springframework.web.bind.annotation.RestControllerAdvice;

//@RestControllerAdvice
public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String message){
        super(message);
    }
}
