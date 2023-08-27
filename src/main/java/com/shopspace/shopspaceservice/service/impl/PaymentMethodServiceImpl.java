package com.shopspace.shopspaceservice.service.impl;

import com.shopspace.shopspaceservice.model.PaymentMethod;
import com.shopspace.shopspaceservice.repository.PaymentMethodRepository;
import com.shopspace.shopspaceservice.service.PaymentMethodService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentMethodServiceImpl implements PaymentMethodService {
    Logger logger = LoggerFactory.getLogger(PaymentMethodServiceImpl.class);
    @Autowired
    PaymentMethodRepository paymentMethodRepository;

    @Override
    public Page<PaymentMethod> getAllPaymentsMethods(String search, Integer page, Integer size){
        return paymentMethodRepository.getAllPaymentsMethods(search, PageRequest.of(page, size));
    }

    @Override
    public Optional<PaymentMethod> getPaymentMethodById(Long id){
        return paymentMethodRepository.findById(id);
    }

    @Override
    public PaymentMethod create(PaymentMethod paymentMethod){
        return paymentMethodRepository.save(paymentMethod);
    }

    @Override
    public Boolean delete(Long id){
        try {
            paymentMethodRepository.deleteById(id);
            return true;
        }catch (Exception e){
            logger.error("Exception delete payment method -> {0}", e);
            return false;
        }
    }

    //Methods for web
    @Override
    public List<PaymentMethod> getPaymentMethodsByStatus(Integer status){
        return paymentMethodRepository.findByStatus(status);
    }
}
