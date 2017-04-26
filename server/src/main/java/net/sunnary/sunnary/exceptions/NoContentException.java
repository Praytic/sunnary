package net.sunnary.sunnary.exceptions;

public class NoContentException extends Exception {
    public NoContentException(long id) {
        super("No such content with id: " + id);
    }
}
