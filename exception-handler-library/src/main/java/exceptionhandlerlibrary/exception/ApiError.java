package exceptionhandlerlibrary.exception;

import lombok.Data;
import lombok.ToString;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

@Data
@ToString
public class ApiError {

    private HttpStatus statusCode;
    private ZonedDateTime zonedDateTime;
    private String message;
    private String debugMessage;

    private ApiError(){
        this.zonedDateTime = ZonedDateTime.now();
    }

    public ApiError(HttpStatus status){
        this();
        this.statusCode = status;
    }

    public ApiError(HttpStatus status, Throwable ex){
        this();
        this.statusCode = status;
        this.statusCode = status;
        this.message=ex.getMessage();
    }

    public ApiError(HttpStatus status, String message, Throwable ex){
        this();
        this.statusCode = status;
        this.statusCode = status;
        this.message=message;
        this.debugMessage = ex.getLocalizedMessage();
    }


}
