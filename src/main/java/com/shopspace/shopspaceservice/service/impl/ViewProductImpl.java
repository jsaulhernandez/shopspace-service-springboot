package com.shopspace.shopspaceservice.service.impl;

import com.shopspace.shopspaceservice.model.ViewProduct;
import com.shopspace.shopspaceservice.repository.ViewProductRepository;
import com.shopspace.shopspaceservice.service.ViewProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ViewProductImpl implements ViewProductService {
    @Autowired
    private ViewProductRepository viewProductRepository;

    @Override
    public ViewProduct create(ViewProduct brand){
        return viewProductRepository.save(brand);
    }
}
