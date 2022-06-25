package com.libre.exception;

/**
 * @author Hamza Amentag
 * @since 3/26/2022
 */
public class ApiRequestException extends RuntimeException {

    public ApiRequestException(String message) {
        super(message);
    }

    public ApiRequestException() {
    }

    public ApiRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public ApiRequestException(Throwable cause) {
        super(cause);
    }
}
