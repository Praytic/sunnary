package net.sunnary.sunnary.controller;

import net.sunnary.sunnary.controller.exceptions.ControllerException;
import net.sunnary.sunnary.dto.ErrorMessageDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(ControllerException.class)
    @ResponseBody
    public ResponseEntity<ErrorMessageDto> handleControllerException(ControllerException exception) {
        return new ResponseEntity<>(
                new ErrorMessageDto(exception.getType(), exception.getMessage()), exception.getStatus());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ResponseEntity<ErrorMessageDto> handleValidationException(MethodArgumentNotValidException exception) {
        return new ResponseEntity<>(
                new ErrorMessageDto(ErrorMessageDto.Type.MALFORMED_REQUEST, exception.getMessage()),
                HttpStatus.BAD_REQUEST);
    }
}


