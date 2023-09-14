package com.shopspace.shopspaceservice.repository;

import com.shopspace.shopspaceservice.model.Faq;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FaqsRepository extends JpaRepository<Faq, Long> {
    @Query("SELECT fq FROM Faq fq WHERE (:search IS NULL or fq.question LIKE CONCAT('%', :search, '%')) ORDER BY fq.id DESC")
    Page<Faq> getAllFaqs(@Param("search") String Search, Pageable pageable);
    List<Faq> findByStatus(Integer status);
}
