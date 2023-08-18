package com.shopspace.shopspaceservice.repository;

import com.shopspace.shopspaceservice.model.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<Coupon, Long> {
}
