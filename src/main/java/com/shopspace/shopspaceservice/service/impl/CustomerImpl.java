package com.shopspace.shopspaceservice.service.impl;

import com.shopspace.shopspaceservice.model.Customer;
import com.shopspace.shopspaceservice.repository.CustomerRepository;
import com.shopspace.shopspaceservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class CustomerImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Page<Customer> getAllPagedCustomers(String search, Integer page, Integer size){
        return customerRepository.getAllCustomers(search, PageRequest.of(page, size));
    }
}
