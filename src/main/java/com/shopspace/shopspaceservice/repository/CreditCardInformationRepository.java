package com.shopspace.shopspaceservice.repository;

import com.shopspace.shopspaceservice.model.CreditCardInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardInformationRepository extends JpaRepository<CreditCardInformation, Long> {
}
