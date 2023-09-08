package com.shopspace.shopspaceservice.repository;

import com.shopspace.shopspaceservice.model.UserCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCustomerRepository extends JpaRepository<UserCustomer, Long> {
}
