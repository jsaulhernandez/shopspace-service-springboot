package com.shopspace.shopspaceservice.service.impl;

import com.shopspace.shopspaceservice.model.Product;
import com.shopspace.shopspaceservice.repository.ProductRepository;
import com.shopspace.shopspaceservice.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Page<Product> getPagedProducts(String search, Integer page, Integer size){
        return productRepository.getAllProducts(search, PageRequest.of(page, size));
    }

    @Override
    public Optional<Product> getProductById(Long id){
        return productRepository.findById(id);
    }

    @Override
    public Product create(Product product){
        return productRepository.save(product);
    }

    @Override
    public Boolean delete(Long id){
        try {
            productRepository.deleteById(id);
            return true;
        }catch (Exception e){
            logger.error("Exception delete product -> {0}", e);
            return false;
        }
    }
}
