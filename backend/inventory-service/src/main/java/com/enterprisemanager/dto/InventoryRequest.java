package com.enterprisemanager.dto;

import com.enterprisemanager.entity.MovementType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InventoryRequest {

    @NotNull(message = "El ID del producto es obligatorio")
    private Long productId;

    @NotNull(message = "El tipo de movimiento es obligatorio")
    private MovementType type; // IN o OUT

    @NotNull(message = "La cantidad es obligatoria")
    @Positive(message = "La cantidad debe ser mayor a 0")
    private Integer quantity;

    @NotBlank(message = "El nombre del depósito es obligatorio")
    private String warehouse;
}
