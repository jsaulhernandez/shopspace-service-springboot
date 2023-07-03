package com.shopspace.shopspaceservice.repository;

import com.shopspace.shopspaceservice.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findByStatus(Integer status);
    @Query("SELECT c FROM Category c WHERE (:search IS NULL or c.name LIKE CONCAT('%', :search, '%')) ORDER BY c.id " +
            "ASC")
    Page<Category> getAllCategories(@Param("search") String Search, Pageable pageable);
}
