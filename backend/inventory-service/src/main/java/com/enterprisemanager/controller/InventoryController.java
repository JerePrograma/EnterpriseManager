package com.enterprisemanager.controller;


import com.enterprisemanager.dto.InventoryRequest;
import com.enterprisemanager.dto.InventoryResponse;
import com.enterprisemanager.service.InventoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public InventoryResponse register(@Valid @RequestBody InventoryRequest request) {
        return inventoryService.registerMovement(request);
    }

    @GetMapping
    public List<InventoryResponse> getAll() {
        return inventoryService.getAllMovements();
    }

    /**
     * GET /api/inventory/stock?productId=101
     * Calcula y devuelve el stock actual del producto
     */
    @GetMapping("/stock")
    public int getStock(@RequestParam Long productId) {
        return inventoryService.getCurrentStock(productId);
    }
}
