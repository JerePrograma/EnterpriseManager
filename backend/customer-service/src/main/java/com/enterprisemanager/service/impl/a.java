package com.enterprisemanager.service.impl;

import com.enterprisemanager.dto.CreateCustomerRequest;
import com.enterprisemanager.dto.CustomerResponse;
import com.enterprisemanager.dto.UpdateCustomerRequest;
import com.enterprisemanager.model.Customer;
import com.enterprisemanager.repository.CustomerRepository;
import com.enterprisemanager.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository repo;
    private final ModelMapper mapper; // o MapStruct

    @Override
    public CustomerResponse create(CreateCustomerRequest req) {
        if (repo.existsByEmail(req.email()))
            throw new BusinessException("Email ya registrado");
        Customer c = mapper.map(req, Customer.class);
        return mapper.map(repo.save(c), CustomerResponse.class);
    }

    @Override
    public CustomerResponse update(Long id, UpdateCustomerRequest req) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public CustomerResponse getById(Long id) {
        return null;
    }

    @Override
    public List<CustomerResponse> getAll() {
        return List.of();
    }
    // implementa resto de métodos con validaciones análogas…
}
