package com.shopspace.shopspaceservice.repository;

import com.shopspace.shopspaceservice.model.Brand;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BrandRepository extends JpaRepository<Brand, Long> {
    @Query("SELECT b FROM Brand b WHERE (:search IS NULL or b.name LIKE CONCAT('%', :search, '%')) ORDER BY b.id DESC")
    Page<Brand> getAllBrands(@Param("search") String Search, Pageable pageable);
}
