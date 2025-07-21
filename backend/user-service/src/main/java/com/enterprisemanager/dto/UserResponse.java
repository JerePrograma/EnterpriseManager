package com.enterprisemanager.dto;

import java.time.LocalDateTime;

public record UserResponse(Long id,
                           String username,
                           String role,
                           LocalDateTime createdAt,
                           LocalDateTime updatedAt) {
}
