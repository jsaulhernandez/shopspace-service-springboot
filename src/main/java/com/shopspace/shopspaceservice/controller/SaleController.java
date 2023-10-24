package com.shopspace.shopspaceservice.controller;

import com.shopspace.shopspaceservice.model.SaleHeader;
import com.shopspace.shopspaceservice.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sale")
public class SaleController {
    @Autowired
    SaleService saleService;

    @PostMapping(path = "/create", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public SaleHeader create(@RequestBody SaleHeader saleHeader){
    return saleService.create(saleHeader);
}
}
