package exceptions;

public class FailedToResolveClassException extends RuntimeException {
    public FailedToResolveClassException(String message) {
        super(message);
    }
}
