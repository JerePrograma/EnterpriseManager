package com.enterprisemanager.error;

import org.springframework.http.converter.HttpMessageNotReadableException;

public class BadRequestBodyException extends HttpMessageNotReadableException {
    public BadRequestBodyException(String msg) {
        super(msg);
    }
}