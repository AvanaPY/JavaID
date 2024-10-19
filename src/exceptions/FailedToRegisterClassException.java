package exceptions;

public class FailedToRegisterClassException extends RuntimeException {
    public FailedToRegisterClassException(String message) {
        super(message);
    }
}
