package com.web.edu.internetshop.service.exceptions;

public class SystemVariableNotFoundException extends RuntimeException {
    public SystemVariableNotFoundException() {
        super();
    }

    public SystemVariableNotFoundException(String message) {
        super("System variable:["+message+"] not found. Please add it");
    }

    public SystemVariableNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public SystemVariableNotFoundException(Throwable cause) {
        super(cause);
    }

    protected SystemVariableNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
