package com.enterprisemanager.dto;

import java.time.LocalDateTime;

public record CustomerResponse(
        Long id,
        String name,
        String email,
        String phone,
        String address,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {}
