package com.enterprisemanager.dto;

public record UpdateCustomerRequest(
        String name,
        @Email String email,
        String phone,
        String address
) {
}
