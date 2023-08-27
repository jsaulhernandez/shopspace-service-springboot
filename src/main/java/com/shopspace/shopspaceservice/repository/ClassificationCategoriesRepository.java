package com.shopspace.shopspaceservice.repository;

import com.shopspace.shopspaceservice.model.ClassificationCategories;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClassificationCategoriesRepository extends JpaRepository<ClassificationCategories, Long> {
    @Query("SELECT cc FROM ClassificationCategories cc WHERE (:search IS NULL or cc.name LIKE CONCAT('%', :search, '%')) ORDER BY cc.id DESC")
    Page<ClassificationCategories> getAllClassificationCategories(@Param("search") String Search, Pageable pageable);
    List<ClassificationCategories> findByStatus(Integer status);
}
