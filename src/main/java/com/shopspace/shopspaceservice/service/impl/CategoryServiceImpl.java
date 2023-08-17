package com.shopspace.shopspaceservice.service.impl;

import com.shopspace.shopspaceservice.model.Category;
import com.shopspace.shopspaceservice.repository.CategoryRepository;
import com.shopspace.shopspaceservice.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    Logger logger = LoggerFactory.getLogger(CategoryServiceImpl.class);

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Page<Category> getPagedCategories(String search, Integer page, Integer size){
            return categoryRepository.getAllCategories(search, PageRequest.of(page, size));
    }

    @Override
    public Optional<Category> getCategoryById(Long id){
        return categoryRepository.findById(id);
    }

    @Override
    public Category create(Category category){
        return categoryRepository.save(category);
    }

    @Override
    public Boolean delete(Long id){
        try {
            categoryRepository.deleteById(id);
            return true;
        }catch (Exception e){
            logger.error("Exception {0}", e);
            return false;
        }
    }

    @Override
    public List<Category> getCategoriesByStatus(Integer status){
        return categoryRepository.findByStatus(status);
    }
}
