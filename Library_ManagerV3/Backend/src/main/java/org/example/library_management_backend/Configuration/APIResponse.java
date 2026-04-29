package org.example.library_management_backend.Configuration;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@JsonPropertyOrder({ "code", "message", "localDateTime", "data" })
public class APIResponse<T> {
    private int code;
    private String message;
    private T data;
    private LocalDateTime localDateTime;

    public APIResponse(ResponseCode responseCode, T data) {
        this.code = responseCode.getCode();
        this.message = responseCode.getMessage();
        this.data = data;
        this.localDateTime = LocalDateTime.now();
    }

}
