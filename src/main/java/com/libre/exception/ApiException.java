package com.libre.exception;

import org.springframework.http.HttpStatus;

/**
 * @author Hamza Amentag
 * @since 3/26/2022
 */
public class ApiException {

    private final String message;
    private final HttpStatus httpStatus;

    public ApiException(String message,
                        HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
