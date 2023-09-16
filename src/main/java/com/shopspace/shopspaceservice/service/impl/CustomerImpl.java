package com.shopspace.shopspaceservice.service.impl;

import com.shopspace.shopspaceservice.model.UserCustomer;
import com.shopspace.shopspaceservice.repository.UserCustomerRepository;
import com.shopspace.shopspaceservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerImpl implements CustomerService {
    @Autowired
    UserCustomerRepository userCustomerRepository;

    @Override
        public Page<UserCustomer> getAllPagedUsersCustomers(String search, Integer page, Integer size){
        return userCustomerRepository.getAllUsersCustomers(search, PageRequest.of(page, size));
    }

    @Override
    public Optional<UserCustomer> getUserCustomerById(Long id){
        return userCustomerRepository.findById(id);
    }

    @Override
    public UserCustomer create(UserCustomer userCustomer){
        return userCustomerRepository.save(userCustomer);
    }
}
