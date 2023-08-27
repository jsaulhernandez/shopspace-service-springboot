package com.shopspace.shopspaceservice.repository;

import com.shopspace.shopspaceservice.model.PaymentMethod;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Long> {
    @Query("SELECT pm FROM PaymentMethod pm WHERE (:search IS NULL or pm.name LIKE CONCAT('%', :search, '%')) ORDER BY pm.id DESC")
    Page<PaymentMethod> getAllPaymentsMethods(@Param("search") String search, Pageable pageable);

    //Methods for web
    List<PaymentMethod> findByStatus(Integer status);
}
