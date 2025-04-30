package com._Perals.fullstack_backend.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(long id) {
        super("could not found id" + id);
    }
}
