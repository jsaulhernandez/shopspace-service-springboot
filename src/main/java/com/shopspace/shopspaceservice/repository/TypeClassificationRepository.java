package com.shopspace.shopspaceservice.repository;

import com.shopspace.shopspaceservice.model.TypeClassification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TypeClassificationRepository extends JpaRepository<TypeClassification, Long> {
    @Query("SELECT tc FROM TypeClassification tc WHERE (:search IS NULL or tc.name LIKE CONCAT('%', :search, '%')) ORDER BY tc.id DESC")
    Page<TypeClassification> getAllTypesClassifications(@Param("search") String Search, Pageable pageable);
}
