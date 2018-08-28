package com.hb.sb.framework.exception;

import com.hb.sb.framework.exception.AppException;

public class InvalidMessageException extends AppException {

    public InvalidMessageException(String transactionId, 
        String nodeId, 
        String message) {
        super(transactionId, nodeId, message);
    }
}