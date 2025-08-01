package com.enterprisemanager.service;

import com.enterprisemanager.dto.ProductRequest;
import com.enterprisemanager.dto.ProductResponse;

import java.util.List;

public interface ProductService {

    List<ProductResponse> getAll();

    ProductResponse getById(Long id);

    ProductResponse create(ProductRequest request);

    ProductResponse update(Long id, ProductRequest request);

    void delete(Long id);
}
