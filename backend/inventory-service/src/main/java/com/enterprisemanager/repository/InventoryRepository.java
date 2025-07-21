package com.enterprisemanager.repository;

import com.enterprisemanager.entity.InventoryRecord;
import com.enterprisemanager.entity.MovementType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InventoryRepository extends JpaRepository<InventoryRecord,Long> {

    List<InventoryRecord> findByProductId(Long productId);

    List<InventoryRecord> findByProductIdAndType(Long productId, MovementType type);
}
