package com.shopspace.shopspaceservice.repository;

import com.shopspace.shopspaceservice.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
