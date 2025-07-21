package com.enterprisemanager.dto;

public record UpdateUserRequest(
        String username,
        String role) {
}
