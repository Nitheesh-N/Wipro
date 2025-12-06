package com.playstore.user.exception;

@SuppressWarnings("serial")
public class AppNotFoundException extends RuntimeException {
    public AppNotFoundException(String msg) {
        super(msg);
    }
}