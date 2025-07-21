package com.enterprisemanager.exception;

public class ProductNotFoundException extends RuntimeException{

    public ProductNotFoundException(Long id) {
        super("Producto no encontrado con ID: " + id);
    }
}
