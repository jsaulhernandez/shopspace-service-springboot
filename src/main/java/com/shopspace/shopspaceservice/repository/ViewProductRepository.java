package com.shopspace.shopspaceservice.repository;

import com.shopspace.shopspaceservice.model.ViewProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViewProductRepository extends JpaRepository<ViewProduct, Long> {
}
