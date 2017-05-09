package net.sunnary.sunnary.controller.exceptions;

import net.sunnary.sunnary.dto.ErrorMessageDto;
import org.springframework.http.HttpStatus;

public class NoContentControllerException extends ControllerException {
    public NoContentControllerException() {
        super(ErrorMessageDto.Type.NO_SUCH_ARTICLE, HttpStatus.BAD_REQUEST, "No such article exists.");
    }
}
