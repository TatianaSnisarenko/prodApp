package ua.goit.prodApp.exceptions;

public class LastAdminDeleteAttemptException extends RuntimeException {
    public LastAdminDeleteAttemptException(String message) {
        super(message);
    }
}
