package net.sunnary.sunnary.exceptions;

public class NoContentException extends Exception {
    public NoContentException() {}

    @Override
    public String getMessage() {
        return "No such content.";
    }
}
