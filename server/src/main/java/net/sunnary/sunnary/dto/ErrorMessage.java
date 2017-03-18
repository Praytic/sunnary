package net.sunnary.sunnary.dto;

public class ErrorMessage {
    private Type type;
    private String message;

    public ErrorMessage(Type type) {
        switch (type) {
            case INTERNAL_ERROR:
                this.message = "An internal error has occured.";
                break;
            case NO_SUCH_ARTICLE:
                this.message = "No such article exists.";
                break;
            case MALFORMED_REQUEST:
                this.message = "Request malformed.";
                break;
        }

        this.type = type;
    }

    public ErrorMessage(Type type, String message) {
        this.type = type;
        this.message = message;
    }


    public enum Type {
        MALFORMED_REQUEST,
        NO_SUCH_ARTICLE,
        INTERNAL_ERROR
    }

}
