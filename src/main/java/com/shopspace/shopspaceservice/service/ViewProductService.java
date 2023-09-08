package com.shopspace.shopspaceservice.service;

import com.shopspace.shopspaceservice.model.ViewProduct;

import java.util.Optional;

public interface ViewProductService {
    Optional<ViewProduct> getViewProductById(Long id);

    ViewProduct create(ViewProduct brand);
}
