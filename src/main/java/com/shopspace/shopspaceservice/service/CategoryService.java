package com.shopspace.shopspaceservice.service;

import com.shopspace.shopspaceservice.model.Category;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CategoryService {
    List<Category> getCategories();
    Page<Category> getPagedCategories(String search, Integer page, Integer size);
}
