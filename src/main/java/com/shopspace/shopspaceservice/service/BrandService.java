package com.shopspace.shopspaceservice.service;

import com.shopspace.shopspaceservice.model.Brand;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface BrandService {
    Page<Brand> getPagedBrands(String search, Integer page, Integer size);

    Optional<Brand> getBrandById(Long id);

    Brand create(Brand brand);

    Boolean delete(Long id);
}
