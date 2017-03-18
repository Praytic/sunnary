package net.sunnary.sunnary.exceptions;

public class NoContentException extends Exception {
    public NoContentException() {
        super("No such content.");
    }
}
