package com.enterprisemanager.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "inventory_records")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InventoryRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long productId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MovementType type; // IN o OUT

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false)
    private String warehouse;

    @Column(nullable = false)
    private LocalDateTime timestamp;
}
