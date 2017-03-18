package net.sunnary.sunnary.exceptions;

public class NoTagException extends Exception {
    public NoTagException() {
        super("No such tag.");
    }
}
