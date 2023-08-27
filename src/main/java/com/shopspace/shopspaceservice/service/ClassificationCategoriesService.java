package com.shopspace.shopspaceservice.service;

import com.shopspace.shopspaceservice.model.ClassificationCategories;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface ClassificationCategoriesService {
    Page<ClassificationCategories> getPagedClassificationCategories(String search, Integer page, Integer size);

    Optional<ClassificationCategories> getClassificationCategoriesById(Long id);

    ClassificationCategories create(ClassificationCategories classificationCategories);

    Boolean delete(Long id);

    List<ClassificationCategories> getClassificationCategoriesByStatus(Integer status);
}
