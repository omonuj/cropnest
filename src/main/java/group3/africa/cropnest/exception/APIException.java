package group3.africa.cropnest.exception;

public class APIException extends RuntimeException {
    public static final Long serialVersionUID = 1L;

    public APIException(String message){
        super(message);
    }
}
