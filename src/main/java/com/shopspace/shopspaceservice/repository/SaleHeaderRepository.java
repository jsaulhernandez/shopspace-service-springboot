package com.shopspace.shopspaceservice.repository;

import com.shopspace.shopspaceservice.model.SaleHeader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleHeaderRepository extends JpaRepository<SaleHeader, Long> {
}
