package com.enterprisemanager.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "product-client",
        url = "${product-service.url}"
)
public interface ProductClient {

    @GetMapping("/api/products/{id}")
    void validateProductExists(@PathVariable("id") Long id);
}
