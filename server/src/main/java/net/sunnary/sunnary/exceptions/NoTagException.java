package net.sunnary.sunnary.exceptions;

public class NoTagException extends RuntimeException {
    public NoTagException(String tagName) {
        super("No such tag with name: " + tagName);
    }
}
