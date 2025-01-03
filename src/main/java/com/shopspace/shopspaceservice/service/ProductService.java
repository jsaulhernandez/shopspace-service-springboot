package com.shopspace.shopspaceservice.service;

import com.shopspace.shopspaceservice.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Page<Product> getPagedProducts(String search, Integer page, Integer size);

    Optional<Product> getProductById(Long id);

    Product create(Product product);

    Boolean delete(Long id);

    // Todo: methods for web site
    List<Product> getLastProductsWithLimit(Integer page, Integer size);

    List<Product> getProductsByCategoryWithLimit(Long category, Integer page, Integer size);

    List<Product> getProductsByTypeClassificationWithLimit(Long idProduct, Long typeClassification, Integer page, Integer size);

    List<Product> getProductsByWeekWithLimit(Integer totalSales, Integer page, Integer size);

    List<Product> getMostSellingProducts(Integer totalSales, Integer page, Integer size);
}
