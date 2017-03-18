package net.sunnary.sunnary.controller.exceptions;

import net.sunnary.sunnary.dto.ErrorMessage;
import org.springframework.http.HttpStatus;

public abstract class ControllerException extends Exception {
    private ErrorMessage.Type type;
    private HttpStatus status;

    public ControllerException(ErrorMessage.Type type, HttpStatus status, String message) {
        super(message);
        this.type = type;
        this.status = status;
    }

    public final ErrorMessage.Type getType() {
        return type;
    }

    public final HttpStatus getStatus() {
        return status;
    }
}
