package net.sunnary.sunnary.exceptions;

public class NoTagException extends Exception {
    public NoTagException(String tagName) {
        super("No such tag with name: " + tagName);
    }
}
