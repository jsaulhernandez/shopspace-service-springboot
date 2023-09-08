package com.shopspace.shopspaceservice.repository;

import com.shopspace.shopspaceservice.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT p FROM Product p WHERE (:search IS NULL or (p.title LIKE CONCAT('%', :search, '%') OR p.name LIKE CONCAT('%', :search, '%') OR p.model LIKE CONCAT('%', :search, '%') OR p.modelNumber LIKE CONCAT('%', :search, '%'))) ORDER BY p.id DESC")
    Page<Product> getAllProducts(@Param("search") String Search, Pageable pageable);
}
