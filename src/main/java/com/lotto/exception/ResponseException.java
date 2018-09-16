package com.lotto.exception;

import java.util.Date;

public class ResponseException {
    private String message;
    private Date timestamp;

    public ResponseException() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
