package com.enterprisemanager.controller;

import com.enterprisemanager.dto.CreateCustomerRequest;
import com.enterprisemanager.dto.CustomerResponse;
import com.enterprisemanager.dto.UpdateCustomerRequest;
import com.enterprisemanager.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService svc;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<CustomerResponse> create(@Valid @RequestBody CreateCustomerRequest req) {
        return ResponseEntity.status(CREATED).body(svc.create(req));
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public List<CustomerResponse> list() { return svc.getAll(); }

    @GetMapping("/{id}")
    public CustomerResponse get(@PathVariable Long id) { return svc.getById(id); }

    @PutMapping("/{id}")
    public CustomerResponse update(@PathVariable Long id,
                                   @Valid @RequestBody UpdateCustomerRequest req) {
        return svc.update(id, req);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable Long id) { svc.delete(id); }
}
