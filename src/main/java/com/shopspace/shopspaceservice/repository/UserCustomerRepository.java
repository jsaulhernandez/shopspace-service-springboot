package com.shopspace.shopspaceservice.repository;

import com.shopspace.shopspaceservice.model.UserCustomer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCustomerRepository extends JpaRepository<UserCustomer, Long> {
    @Query("SELECT uc FROM UserCustomer uc JOIN uc.customer ct WHERE (:search IS NULL OR (CONCAT(ct.firstName, ' ', ct.lastName) LIKE CONCAT('%', :search, '%') OR ct.email LIKE CONCAT('%', :search, '%') OR ct.mobile LIKE CONCAT('%', :search, '%'))) ORDER BY uc.id DESC")
    Page<UserCustomer> getAllUsersCustomers(@Param("search") String Search, Pageable pageable);
}
