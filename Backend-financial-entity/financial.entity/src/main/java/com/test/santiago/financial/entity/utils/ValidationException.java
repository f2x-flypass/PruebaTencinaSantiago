package com.test.santiago.financial.entity.utils;

import lombok.Data;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Data
@RestControllerAdvice
public class ValidationException extends Exception {
    private static final Logger logger = LogManager.getLogger(ValidationException.class);

    private final String code;
    private String msg;

    @Autowired
    private MessageSource messageSource;

    public ValidationException() {
        this.code = "001";
    }

    public ValidationException(String code, String msg) {
        new ResponseEntity(HttpStatus.BAD_REQUEST);
        this.code = code;
        this.msg = msg;
    }
}
