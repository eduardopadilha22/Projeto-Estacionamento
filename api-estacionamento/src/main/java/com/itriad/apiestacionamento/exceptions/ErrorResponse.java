package com.itriad.apiestacionamento.exceptions;

public class ErrorResponse {

    private int errorCode;
    private String message;

    public ErrorResponse() {
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
