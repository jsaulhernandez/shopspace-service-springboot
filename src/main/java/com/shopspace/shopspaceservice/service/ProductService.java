package com.shopspace.shopspaceservice.service;

import com.shopspace.shopspaceservice.model.Product;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface ProductService {
    Page<Product> getPagedProducts(String search, Integer page, Integer size);

    Optional<Product> getProductById(Long id);

    Product create(Product product);

    Boolean delete(Long id);
}
