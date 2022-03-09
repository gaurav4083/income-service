package com.nhs.springboot.incomeservice.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

/**
 * API Error
 */
@NoArgsConstructor
@Getter
public class Error {

    private HttpStatus code;
    private String message;

    public Error(HttpStatus status, String message) {
        this.code = status;
        this.message = null != message ? message : status.getReasonPhrase();
    }


}
