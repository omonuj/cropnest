package group3.africa.cropnest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidPaginationOrSortException extends RuntimeException {
    public InvalidPaginationOrSortException(String message, Throwable cause) {
        super(message, cause);
    }
}
