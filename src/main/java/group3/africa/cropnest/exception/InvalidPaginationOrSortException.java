package group3.africa.cropnest.exception;

public class InvalidPaginationOrSortException extends RuntimeException {
    public InvalidPaginationOrSortException(String message) {
        super(message);
    }
    public InvalidPaginationOrSortException(String message, Throwable cause) {
        super(message, cause);
    }
}