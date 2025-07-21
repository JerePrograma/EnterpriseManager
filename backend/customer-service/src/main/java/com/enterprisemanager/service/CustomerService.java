package com.enterprisemanager.service;

import com.enterprisemanager.dto.CreateCustomerRequest;
import com.enterprisemanager.dto.CustomerResponse;
import com.enterprisemanager.dto.UpdateCustomerRequest;

import java.util.List;

public interface CustomerService {
    CustomerResponse create(CreateCustomerRequest req);

    CustomerResponse update(Long id, UpdateCustomerRequest req);

    void delete(Long id);

    CustomerResponse getById(Long id);

    List<CustomerResponse> getAll();
}
