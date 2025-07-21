package com.enterprisemanager.exception;

public class InsufficientStockException extends RuntimeException{

    public InsufficientStockException(Long productId, int currentStock, int requested) {
        super("Stock insuficiente para producto ID: " + productId +
                ". Disponible: " + currentStock + ", solicitado: " + requested);
    }
}
