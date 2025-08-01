package com.enterprisemanager.service.impl;

import com.enterprisemanager.client.ProductClient;
import com.enterprisemanager.dto.InventoryRequest;
import com.enterprisemanager.dto.InventoryResponse;
import com.enterprisemanager.entity.InventoryRecord;
import com.enterprisemanager.entity.MovementType;
import com.enterprisemanager.exception.InsufficientStockException;
import com.enterprisemanager.mapper.InventoryMapper;
import com.enterprisemanager.repository.InventoryRepository;
import com.enterprisemanager.service.InventoryService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {


    private final InventoryRepository inventoryRepository;
    private final InventoryMapper inventoryMapper;
    private final ProductClient productClient;

    @Override
    public InventoryResponse registerMovement(InventoryRequest request) {
        // Validar si el producto existe
        productClient.validateProductExists(request.getProductId());

        // Validar stock si es salida (OUT)
        if (request.getType() == MovementType.OUT) {
            int stock = getCurrentStock(request.getProductId());
            if (stock < request.getQuantity()) {
                throw new InsufficientStockException(request.getProductId(), stock, request.getQuantity());
            }
        }

        // Registrar movimiento
        InventoryRecord record = inventoryMapper.toEntity(request);
        InventoryRecord saved = inventoryRepository.save(record);
        return inventoryMapper.toResponse(saved);
    }

    @Override
    public List<InventoryResponse> getAllMovements() {
        return inventoryRepository.findAll()
                .stream()
                .map(inventoryMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public int getCurrentStock(Long productId) {
        List<InventoryRecord> records = inventoryRepository.findByProductId(productId);
        int in = records.stream()
                .filter(r -> r.getType() == MovementType.IN)
                .mapToInt(InventoryRecord::getQuantity)
                .sum();
        int out = records.stream()
                .filter(r -> r.getType() == MovementType.OUT)
                .mapToInt(InventoryRecord::getQuantity)
                .sum();
        return in - out;
    }

}
