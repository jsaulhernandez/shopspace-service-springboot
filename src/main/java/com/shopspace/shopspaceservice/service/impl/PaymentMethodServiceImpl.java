package com.shopspace.shopspaceservice.service.impl;

import com.shopspace.shopspaceservice.model.PaymentMethod;
import com.shopspace.shopspaceservice.repository.PaymentMethodRepository;
import com.shopspace.shopspaceservice.service.PaymentMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class PaymentMethodServiceImpl implements PaymentMethodService {
    @Autowired
    PaymentMethodRepository paymentMethodRepository;

    @Override
    public Page<PaymentMethod> getAllPaymentsMethods(String search, Integer page, Integer size){
        return paymentMethodRepository.getAllPaymentsMethods(search, PageRequest.of(page, size));
    }
}
