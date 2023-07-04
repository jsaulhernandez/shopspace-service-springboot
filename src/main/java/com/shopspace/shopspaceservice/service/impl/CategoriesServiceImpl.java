package com.shopspace.shopspaceservice.service.impl;

import com.shopspace.shopspaceservice.model.Categories;
import com.shopspace.shopspaceservice.repository.CategoriesRepository;
import com.shopspace.shopspaceservice.service.CategoriesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriesServiceImpl implements CategoriesService {
    Logger logger = LoggerFactory.getLogger(CategoriesServiceImpl.class);
    @Autowired
    private CategoriesRepository categoriesRepository;

    @Override
    public Page<Categories> getPagedCategories(String search, Integer page, Integer size){
        return categoriesRepository.getAllCategories(search, PageRequest.of(page, size));
    }

    @Override
    public Optional<Categories> getCategoriesById(Long id){
        return categoriesRepository.findById(id);
    }

    @Override
    public Categories create(Categories categories){
        return categoriesRepository.save(categories);
    }

    @Override
    public Boolean delete(Long id){
        try {
            categoriesRepository.deleteById(id);
            return true;
        }catch (Exception e){
            logger.error("Exception delete categories -> {0}", e);
            return false;
        }
    }
}
