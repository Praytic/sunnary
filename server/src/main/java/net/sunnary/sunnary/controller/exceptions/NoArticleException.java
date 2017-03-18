package net.sunnary.sunnary.controller.exceptions;

import net.sunnary.sunnary.dto.ErrorMessage;
import org.springframework.http.HttpStatus;

public class NoArticleException extends ControllerException {
    public NoArticleException() {
        super(ErrorMessage.Type.NO_SUCH_ARTICLE, HttpStatus.BAD_REQUEST, "No such article exists.");
    }
}
