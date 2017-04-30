package net.sunnary.sunnary.exceptions;

public class NoContentException extends RuntimeException {
    public NoContentException(Long id) {
        super("No such content with ID: " + id);
    }
}
