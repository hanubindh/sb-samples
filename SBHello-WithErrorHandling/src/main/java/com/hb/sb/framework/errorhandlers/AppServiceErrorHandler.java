package com.hb.sb.errorhandlers;

import com.hb.sb.framework.exception.InvalidMessageException;
import com.hb.sb.framework.exception.ErrorMessage;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class AppServiceErrorHandler {

    private static final Logger logger 
        = LoggerFactory.getLogger(AppServiceErrorHandler.class);
        
    @ExceptionHandler(value = {InvalidMessageException.class}) 
    public ResponseEntity<ErrorMessage> handleInvalidMessageException(InvalidMessageException e, 
        WebRequest request) {
        logger.error("{}:{}: Invalid message - {}", 
            e.getTransactionId(), 
            e.getErrorId(), 
            e.getMessage());
        ErrorMessage errorMessage = new ErrorMessage(e.getErrorId(), 
            e.getTimestamp().toString(), 
            e.getMessage());
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("txId", e.getTransactionId());
        ResponseEntity<ErrorMessage> response = new ResponseEntity<ErrorMessage>(errorMessage, 
            responseHeaders, 
            HttpStatus.NOT_ACCEPTABLE);
        return response;
    }

}

