package net.sunnary.sunnary.dto;

public class ErrorMessage {
    private Type type;
    private String message;

    public ErrorMessage(Type type) {
        if (type == Type.INTERNAL_ERROR) {
            this.message = "An internal error has occured.";
        }

        this.type = type;
    }

    public ErrorMessage(Type type, String message) {
        this.type = type;
        this.message = message;
    }


    public enum Type {
        MALFORMED_REQUEST,
        INTERNAL_ERROR
    }

}
