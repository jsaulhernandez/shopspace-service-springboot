package com.shopspace.shopspaceservice.repository;

import com.shopspace.shopspaceservice.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Long> {
}
