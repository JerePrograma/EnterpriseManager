package com.enterprisemanager.service;

import com.enterprisemanager.dto.InventoryRequest;
import com.enterprisemanager.dto.InventoryResponse;

import java.util.List;

public interface InventoryService {

    InventoryResponse registerMovement(InventoryRequest request);

    List<InventoryResponse> getAllMovements();

    int getCurrentStock(Long productId);
}
