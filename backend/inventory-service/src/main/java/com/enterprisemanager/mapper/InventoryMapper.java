package com.enterprisemanager.mapper;

import com.enterprisemanager.dto.InventoryRequest;
import com.enterprisemanager.dto.InventoryResponse;
import com.enterprisemanager.entity.InventoryRecord;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class InventoryMapper {
    public InventoryRecord toEntity(InventoryRequest request) {
        return InventoryRecord.builder()
                .productId(request.getProductId())
                .type(request.getType())
                .quantity(request.getQuantity())
                .warehouse(request.getWarehouse())
                .timestamp(LocalDateTime.now())
                .build();
    }

    public InventoryResponse toResponse(InventoryRecord record) {
        return InventoryResponse.builder()
                .id(record.getId())
                .productId(record.getProductId())
                .type(record.getType())
                .quantity(record.getQuantity())
                .warehouse(record.getWarehouse())
                .timestamp(record.getTimestamp())
                .build();
    }
}
