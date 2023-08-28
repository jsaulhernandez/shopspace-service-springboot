package com.shopspace.shopspaceservice.service.impl;

import com.shopspace.shopspaceservice.model.Brand;
import com.shopspace.shopspaceservice.repository.BrandRepository;
import com.shopspace.shopspaceservice.service.BrandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BrandServiceImpl implements BrandService {
    Logger logger = LoggerFactory.getLogger(BrandServiceImpl.class);
    @Autowired
    private BrandRepository brandRepository;

    @Override
    public Page<Brand> getPagedBrands(String search, Integer page, Integer size){
        return brandRepository.getAllBrands(search, PageRequest.of(page, size));
    }

    @Override
    public Optional<Brand> getBrandById(Long id){
        return brandRepository.findById(id);
    }

    @Override
    public Brand create(Brand brand){
        return brandRepository.save(brand);
    }

    @Override
    public Boolean delete(Long id){
        try {
            brandRepository.deleteById(id);
            return true;
        }catch (Exception e){
            logger.error("Exception delete brand -> {0}", e);
            return false;
        }
    }

    @Override
    public List<Brand> getBrandsByStatus(Integer status){
        return brandRepository.findByStatus(status);
    }
}
