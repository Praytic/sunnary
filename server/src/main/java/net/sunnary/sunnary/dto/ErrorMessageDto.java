package net.sunnary.sunnary.dto;

public class ErrorMessageDto {
    private Type type;
    private String message;

    public ErrorMessageDto(Type type) {
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

    public ErrorMessageDto(Type type, String message) {
        this.type = type;
        this.message = message;
    }


    public enum Type {
        MALFORMED_REQUEST,
        NO_SUCH_ARTICLE,
        INTERNAL_ERROR
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
