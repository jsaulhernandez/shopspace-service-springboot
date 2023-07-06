package com.shopspace.shopspaceservice.controller;

import com.shopspace.shopspaceservice.model.PaymentMethod;
import com.shopspace.shopspaceservice.model.Product;
import com.shopspace.shopspaceservice.service.PaymentMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment-method")
public class PaymentMethodController {

    @Autowired
    PaymentMethodService paymentMethodService;

    @GetMapping(path = "/paged", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public Page<PaymentMethod> getPagedPaymentsMethods(@RequestParam(value = "search", defaultValue = "") String search, @RequestParam(value = "page", defaultValue = "0") Integer page, @RequestParam(value = "size", defaultValue = "10") Integer size){
        return paymentMethodService.getAllPaymentsMethods(search, page, size);
    }
}
