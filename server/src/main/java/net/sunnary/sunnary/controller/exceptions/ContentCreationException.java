package net.sunnary.sunnary.controller.exceptions;

import net.sunnary.sunnary.dto.ErrorMessage;
import org.springframework.http.HttpStatus;

public class ContentCreationException extends ControllerException {

    public ContentCreationException() {
        super(ErrorMessage.Type.NO_SUCH_ARTICLE, HttpStatus.BAD_REQUEST, "Content was not created due to an exception.");
    }
}
