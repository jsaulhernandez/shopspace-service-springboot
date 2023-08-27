package com.shopspace.shopspaceservice.controller;

import com.shopspace.shopspaceservice.model.PaymentMethod;
import com.shopspace.shopspaceservice.service.PaymentMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/payment-method")
public class PaymentMethodController {

    @Autowired
    PaymentMethodService paymentMethodService;

    @GetMapping(path = "/paged", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public Page<PaymentMethod> getPagedPaymentsMethods(@RequestParam(value = "search", defaultValue = "") String search, @RequestParam(value = "page", defaultValue = "0") Integer page, @RequestParam(value = "size", defaultValue = "10") Integer size){
        return paymentMethodService.getAllPaymentsMethods(search, page, size);
    }

    @GetMapping(path = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public Optional<PaymentMethod> getOnePaymentMethod(@PathVariable("id") Long id){
        return paymentMethodService.getPaymentMethodById(id);
    }

    @PostMapping(path = "/create", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public PaymentMethod create(@RequestBody PaymentMethod paymentMethod){
        return paymentMethodService.create(paymentMethod);
    }

    @DeleteMapping(path = "/delete/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public Boolean delete(@PathVariable("id") Long id){
        return paymentMethodService.delete(id);
    }

    //Methods for web
    @GetMapping(path = "/by-status", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public List<PaymentMethod> getPaymentMethodsByStatus(@RequestParam(value = "status", defaultValue = "1") Integer status){
        return paymentMethodService.getPaymentMethodsByStatus(status);
    }
}
