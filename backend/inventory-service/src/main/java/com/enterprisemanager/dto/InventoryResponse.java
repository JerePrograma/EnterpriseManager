package com.enterprisemanager.dto;

import com.enterprisemanager.entity.MovementType;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InventoryResponse {

    private Long id;
    private Long productId;
    private MovementType type;
    private Integer quantity;
    private String warehouse;
    private LocalDateTime timestamp;

}
