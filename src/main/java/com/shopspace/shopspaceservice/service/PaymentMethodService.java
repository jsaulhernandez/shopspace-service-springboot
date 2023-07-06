package com.shopspace.shopspaceservice.service;

import com.shopspace.shopspaceservice.model.PaymentMethod;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface PaymentMethodService {
    Page<PaymentMethod> getAllPaymentsMethods(String search, Integer page, Integer size);

    Optional<PaymentMethod> getPaymentMethodById(Long id);

    PaymentMethod create(PaymentMethod paymentMethod);

    Boolean delete(Long id);
}
