package com.shopspace.shopspaceservice.service.impl;

import com.shopspace.shopspaceservice.model.Category;
import com.shopspace.shopspaceservice.repository.CategoryRepository;
import com.shopspace.shopspaceservice.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getCategories(){
        return categoryRepository.findByStatus(1);
    }

    @Override
    public Page<Category> getPagedCategories(String search, Integer page, Integer size){
            return categoryRepository.getAllCategories(search, PageRequest.of(page, size));
    }
}
