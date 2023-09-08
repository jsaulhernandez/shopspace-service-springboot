package com.shopspace.shopspaceservice.repository;

import com.shopspace.shopspaceservice.model.SaleBody;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleBodyRepository extends JpaRepository<SaleBody, Long> {
}
