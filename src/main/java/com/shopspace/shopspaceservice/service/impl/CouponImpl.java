package com.shopspace.shopspaceservice.service.impl;

import com.shopspace.shopspaceservice.model.Coupon;
import com.shopspace.shopspaceservice.repository.CouponRepository;
import com.shopspace.shopspaceservice.service.CouponService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CouponImpl implements CouponService {
    Logger logger = LoggerFactory.getLogger(CouponImpl.class);
    @Autowired
    private CouponRepository couponRepository;

    @Override
    public Page<Coupon> getAllCoupons(String search, Integer page, Integer size){
        return couponRepository.getAllCoupons(search, PageRequest.of(page, size));
    }

    @Override
    public Optional<Coupon> getCouponById(Long id){
        return couponRepository.findById(id);
    }

    @Override
    public Optional<Coupon> getCouponByCode(String code){
        return couponRepository.findByCode(code);
    }

    @Override
    public Coupon create(Coupon coupon){
        return couponRepository.save(coupon);
    }

    @Override
    public Boolean delete(Long id){
        try {
            couponRepository.deleteById(id);
            return true;
        }catch (Exception e){
            logger.error("Exception delete coupon -> {0}", e);
            return false;
        }
    }
}
