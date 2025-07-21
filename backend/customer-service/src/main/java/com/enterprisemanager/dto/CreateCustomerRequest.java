package com.enterprisemanager.dto;

public record CreateCustomerRequest(
        @NotBlank String name,
        @Email @NotBlank String email,
        String phone,
        String address
) {}
