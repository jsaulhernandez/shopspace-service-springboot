package com.shopspace.shopspaceservice.repository;

import com.shopspace.shopspaceservice.model.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDetailRepository extends JpaRepository<ProductDetail, Long> {
}
