package net.sunnary.sunnary.controller.exceptions;

import net.sunnary.sunnary.dto.ErrorMessageDto;
import org.springframework.http.HttpStatus;

public abstract class ControllerException extends Exception {
    private ErrorMessageDto.Type type;
    private HttpStatus status;

    public ControllerException(ErrorMessageDto.Type type, HttpStatus status, String message) {
        super(message);
        this.type = type;
        this.status = status;
    }

    public final ErrorMessageDto.Type getType() {
        return type;
    }

    public final HttpStatus getStatus() {
        return status;
    }
}
