package com.shopspace.shopspaceservice.service;

import com.shopspace.shopspaceservice.model.PaymentMethod;
import org.springframework.data.domain.Page;

public interface PaymentMethodService {
    Page<PaymentMethod> getAllPaymentsMethods(String search, Integer page, Integer size);
}
