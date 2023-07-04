package com.shopspace.shopspaceservice.repository;

import com.shopspace.shopspaceservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
