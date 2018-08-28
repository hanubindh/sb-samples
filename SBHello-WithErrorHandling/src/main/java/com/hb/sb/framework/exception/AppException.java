package com.hb.sb.framework.exception;

import java.util.Random;
import java.time.Instant;
import org.apache.commons.codec.digest.DigestUtils;

public class AppException extends RuntimeException {

    private String errorId;
    private String transactionId;
    private Instant timestamp;
    private String nodeId;

    private static Random randomGenerator = new Random();

    public AppException(String transactionId, String nodeId) {
        super("Application Error");
        this.transactionId = transactionId;
        this.nodeId = nodeId;
        this.timestamp = Instant.now();
        long random = randomGenerator.nextLong();
        this.errorId = nodeId + transactionId + timestamp;
        // Create a hash so that we need not expose the internal
        // information like nodeId to end consumer.
        this.errorId = DigestUtils.sha256Hex(errorId);
    }

    public AppException(String transactionId, String nodeId, String message) {
        super(message);
        this.transactionId = transactionId;
        this.nodeId = nodeId;
        this.timestamp = Instant.now();
        long random = randomGenerator.nextLong();
        this.errorId = nodeId + transactionId + timestamp;
        // Create a hash so that we need not expose the internal
        // information like nodeId to end consumer.
        this.errorId = DigestUtils.sha256Hex(errorId);
    }

    public String getErrorId() {
        return this.errorId;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

}