package com.shopspace.shopspaceservice.repository;

import com.shopspace.shopspaceservice.model.Categories;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoriesRepository extends JpaRepository<Categories, Long> {
    @Query("SELECT c FROM Categories c WHERE (:search IS NULL or c.name LIKE CONCAT('%', :search, '%')) ORDER BY c.id DESC")
    Page<Categories> getAllCategories(@Param("search") String Search, Pageable pageable);

    // Methods for web
    List<Categories> findByStatus(Integer status);
}
