package com.springboilerplate.springboilerplate.exceptions;

public class UserNotInDBException extends Exception {
    public UserNotInDBException(String message) {
        super(message);
    }
}
