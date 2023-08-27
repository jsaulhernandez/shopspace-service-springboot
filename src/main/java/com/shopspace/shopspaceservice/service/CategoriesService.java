package com.shopspace.shopspaceservice.service;

import com.shopspace.shopspaceservice.model.Categories;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface CategoriesService {
    Page<Categories> getPagedCategories(String search, Integer page, Integer size);

    Optional<Categories> getCategoriesById(Long id);

    Categories create(Categories categories);

    Boolean delete(Long id);

    List<Categories> getCategoriesByStatus(Integer status);
}
