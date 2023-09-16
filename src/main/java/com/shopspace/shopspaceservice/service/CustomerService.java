package com.shopspace.shopspaceservice.service;

import com.shopspace.shopspaceservice.model.Customer;
import org.springframework.data.domain.Page;

public interface CustomerService {
    Page<Customer> getAllPagedCustomers(String search, Integer page, Integer size);
}
