package exceptionhandlerlibrary.exception.web;

import exceptionhandlerlibrary.exception.ApiError;
import exceptionhandlerlibrary.exception.ApiException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalApiException {

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<Object> handleApiException(ApiException ex) {
        ApiError apiError = new ApiError(ex.getErrorCode());
        apiError.setMessage(ex.getMessage());
        return buildResponseEntity(apiError);
    }

    @ExceptionHandler(IllegalAccessError.class)
    public ResponseEntity<Object> handleApiException(IllegalAccessError ex) {
        ApiError apiError = new ApiError(ex.getErrorCode());
        apiError.setMessage(ex.getMessage());
        return buildResponseEntity(apiError);
    }


    private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatusCode());
    }
}
