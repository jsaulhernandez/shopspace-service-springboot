package com.shopspace.shopspaceservice.service.impl;

import com.shopspace.shopspaceservice.model.UserCustomer;
import com.shopspace.shopspaceservice.repository.UserCustomerRepository;
import com.shopspace.shopspaceservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class CustomerImpl implements CustomerService {
    @Autowired
    UserCustomerRepository customerRepository;

    @Override
        public Page<UserCustomer> getAllPagedUsersCustomers(String search, Integer page, Integer size){
        return customerRepository.getAllUsersCustomers(search, PageRequest.of(page, size));
    }
}
