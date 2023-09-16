package com.shopspace.shopspaceservice.service;

import com.shopspace.shopspaceservice.model.UserCustomer;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface CustomerService {
    Page<UserCustomer> getAllPagedUsersCustomers(String search, Integer page, Integer size);

    Optional<UserCustomer> getUserCustomerById(Long id);

    UserCustomer create(UserCustomer userCustomer);
}
