package org.example.library_management_backend.Configuration;

import org.springframework.http.HttpStatus;


public enum ResponseCode {
    SUCCESS(200, "Success"),
    NOT_FOUND(404, "Not Found"),
    UNAUTHORIZED(405, "Unauthorized"),
    ERROR(500, "Error");


    private final int code;
    private final String message;

    ResponseCode(int code, String message){
        this.code = code;
        this.message = message;
    }

    public int getCode(){
        return this.code;
    }

    public String getMessage(){ 
        return this.message;
    }




}
