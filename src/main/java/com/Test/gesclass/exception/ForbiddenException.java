package com.Test.gesclass.exception;

public class ForbiddenException extends ApiException {
    public ForbiddenException(String message) {
        super(message, 403);
    }
} 