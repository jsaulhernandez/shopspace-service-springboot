package com.shopspace.shopspaceservice.repository;

import com.shopspace.shopspaceservice.model.Coupon;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CouponRepository extends JpaRepository<Coupon, Long> {
    @Query("SELECT c FROM Coupon c WHERE (:search IS NULL OR (c.code LIKE CONCAT('%', :search, '%') OR c.off LIKE CONCAT('%', :search, '%'))) ORDER BY c.id DESC")
    Page<Coupon> getAllCoupons(@Param("search") String Search, Pageable pageable);
}
