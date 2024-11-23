package me.aperaverzeu.rest.model;

import static java.text.MessageFormat.format;

public class BasicEntityNotFoundException extends RuntimeException {
    public BasicEntityNotFoundException(Long id) {
        super(format("Entity with id={0} is not found", id));
    }
}
