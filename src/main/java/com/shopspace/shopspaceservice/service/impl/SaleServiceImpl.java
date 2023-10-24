package com.shopspace.shopspaceservice.service.impl;

import com.shopspace.shopspaceservice.model.SaleHeader;
import com.shopspace.shopspaceservice.repository.SaleHeaderRepository;
import com.shopspace.shopspaceservice.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleServiceImpl implements SaleService {
    @Autowired
    SaleHeaderRepository saleHeaderRepository;

    @Override
    public SaleHeader create(SaleHeader saleHeader){
        return saleHeaderRepository.save(saleHeader);
    }
}
