package com.shopspace.shopspaceservice.repository;

import com.shopspace.shopspaceservice.model.Faq;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FaqsRepository extends JpaRepository<Faq, Long> {
}
