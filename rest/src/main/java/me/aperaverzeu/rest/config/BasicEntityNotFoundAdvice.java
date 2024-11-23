package me.aperaverzeu.rest.config;

import me.aperaverzeu.rest.model.BasicEntityNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
public class BasicEntityNotFoundAdvice {
    @ExceptionHandler(BasicEntityNotFoundException.class)
    @ResponseStatus(NOT_FOUND)
    String basicEntityNotFoundHandler(BasicEntityNotFoundException ex) {
        return ex.getMessage();
    }
}
