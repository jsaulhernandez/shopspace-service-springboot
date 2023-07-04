package com.shopspace.shopspaceservice.service;

import com.shopspace.shopspaceservice.model.Category;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    Page<Category> getPagedCategories(String search, Integer page, Integer size);
    Optional<Category> getCategoryById(Long id);
    Category create(Category category);
    Boolean delete(Long id);
    List<Category> getCategories();
}
