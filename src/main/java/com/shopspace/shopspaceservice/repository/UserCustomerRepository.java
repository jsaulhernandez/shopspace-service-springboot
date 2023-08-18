package com.shopspace.shopspaceservice.repository;

import com.shopspace.shopspaceservice.model.UserCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCustomerRepository extends JpaRepository<UserCustomer, Long> {
}
