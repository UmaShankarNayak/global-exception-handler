package exceptionhandlerlibrary.exception;

import org.springframework.http.HttpStatus;

public class ApiException extends RuntimeException{

    private final HttpStatus errorCode;

    public ApiException(final HttpStatus errorCode, String message){
        super(message);
        this.errorCode = errorCode;

    }

    public ApiException(final HttpStatus errorCode, String message, Throwable ex){
        super(message, ex);
        this.errorCode = errorCode;

    }
    public HttpStatus getErrorCode() {
        return errorCode;
    }
}
