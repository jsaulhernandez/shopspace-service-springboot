package com.shopspace.shopspaceservice.service.impl;

import com.shopspace.shopspaceservice.model.ClassificationCategories;
import com.shopspace.shopspaceservice.repository.ClassificationCategoriesRepository;
import com.shopspace.shopspaceservice.service.ClassificationCategoriesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassificationCategoriesImpl implements ClassificationCategoriesService {
    Logger logger = LoggerFactory.getLogger(ClassificationCategoriesImpl.class);
    @Autowired
    private ClassificationCategoriesRepository classificationCategoriesRepository;

    @Override
    public Page<ClassificationCategories> getPagedClassificationCategories(String search, Integer page, Integer size){
        return classificationCategoriesRepository.getAllClassificationCategories(search, PageRequest.of(page, size));
    }

    @Override
    public Optional<ClassificationCategories> getClassificationCategoriesById(Long id){
        return classificationCategoriesRepository.findById(id);
    }

    @Override
    public ClassificationCategories create(ClassificationCategories classificationCategories){
        return classificationCategoriesRepository.save(classificationCategories);
    }

    @Override
    public Boolean delete(Long id){
        try {
            classificationCategoriesRepository.deleteById(id);
            return true;
        }catch (Exception e){
            logger.error("Exception delete classification categories -> {0}", e);
            return false;
        }
    }

    @Override
    public List<ClassificationCategories> getClassificationCategoriesByStatus(Integer status){
        return classificationCategoriesRepository.findByStatus(status);
    }
}
