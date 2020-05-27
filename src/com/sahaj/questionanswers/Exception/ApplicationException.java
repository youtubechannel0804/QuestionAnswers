package com.sahaj.questionanswers.Exception;

/**
 * Handles exception in Application
 */
public class ApplicationException extends Exception {

    String message;

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ApplicationException(String message) {
        super(message);
        this.message = message;
    }

    public ApplicationException(String message, Exception e) {
        super(e);
        this.message = message;
    }
}
