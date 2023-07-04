package com.shopspace.shopspaceservice.repository;

import com.shopspace.shopspaceservice.model.Color;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ColorRepository extends JpaRepository<Color, Long> {
    @Query("SELECT c FROM Color c WHERE (:search IS NULL or c.value LIKE CONCAT('%', :search, '%')) ORDER BY c.id DESC")
    Page<Color> getAllColors(@Param("search") String Search, Pageable pageable);
}
