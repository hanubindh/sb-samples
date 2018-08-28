package com.hb.sb.framework.exception;

public class ErrorMessage {

    private String errId;
    private String timestamp;
    private String message;

    public ErrorMessage(String errId, String timestamp, String message) {
        this.errId = errId;
        this.timestamp = timestamp;
        this.message = message;
    }

    public String getErrId() {
        return this.errId;
    }

    public String getTimestamp() {
        return this.timestamp;
    }

    public String getMessage() {
        return this.message;
    }
} 