package cinema.exception;

public class DataBaseException extends RuntimeException {
    public DataBaseException(String message, Exception e) {
        super(message, e);
    }
}
