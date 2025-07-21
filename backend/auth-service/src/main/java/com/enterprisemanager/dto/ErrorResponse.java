package com.enterprisemanager.dto;

import java.time.LocalDateTime;

public record ErrorResponse(
        String code,
        String message,
        String detail,
        LocalDateTime timestamp
) {
}
