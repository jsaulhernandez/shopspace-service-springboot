package com.shopspace.shopspaceservice.service;

import com.shopspace.shopspaceservice.model.UserCustomer;
import org.springframework.data.domain.Page;

public interface CustomerService {
    Page<UserCustomer> getAllPagedCustomers(String search, Integer page, Integer size);
}
