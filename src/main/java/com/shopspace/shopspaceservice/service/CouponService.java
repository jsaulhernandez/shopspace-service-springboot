package com.shopspace.shopspaceservice.service;

import com.shopspace.shopspaceservice.model.Coupon;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface CouponService {
    Page<Coupon> getAllCoupons(String search, Integer page, Integer size);

    Optional<Coupon> getCouponById(Long id);

    Coupon create(Coupon coupon);

    Boolean delete(Long id);
}
