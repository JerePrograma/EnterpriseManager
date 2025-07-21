package com.enterprisemanager.repository;

import com.enterprisemanager.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
