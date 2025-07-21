package com.enterprisemanager.error;

public class UserAlreadyExistsException extends RuntimeException {
    public UserAlreadyExistsException(String username) {
        super("El nombre de usuario '" + username + "' ya existe");
    }
}