package com.enterprisemanager.service.impl;

import com.enterprisemanager.dto.ProductRequest;
import com.enterprisemanager.dto.ProductResponse;
import com.enterprisemanager.entity.Product;
import com.enterprisemanager.exception.ProductNotFoundException;
import com.enterprisemanager.mapper.ProductMapper;
import com.enterprisemanager.repository.ProductRepository;
import com.enterprisemanager.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public List<ProductResponse> getAll() {
        return productRepository.findAll().stream()
                .map(productMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ProductResponse getById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
        return productMapper.toResponse(product);
    }

    @Override
    public ProductResponse create(ProductRequest request) {
        Product product = productMapper.toEntity(request);
        return productMapper.toResponse(productRepository.save(product));
    }

    @Override
    public ProductResponse update(Long id, ProductRequest request) {
        Product existing = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));

        existing.setName(request.getName());
        existing.setDescription(request.getDescription());
        existing.setPrice(request.getPrice());
        existing.setCategoryId(request.getCategoryId());

        return productMapper.toResponse(productRepository.save(existing));
    }

    @Override
    public void delete(Long id) {
        if (!productRepository.existsById(id)) {
            throw new ProductNotFoundException(id);
        }
        productRepository.deleteById(id);
    }
}
