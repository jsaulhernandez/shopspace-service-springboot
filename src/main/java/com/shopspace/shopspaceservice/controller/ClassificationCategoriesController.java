package com.shopspace.shopspaceservice.controller;

import com.shopspace.shopspaceservice.model.ClassificationCategories;
import com.shopspace.shopspaceservice.service.ClassificationCategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/classification-categories")
public class ClassificationCategoriesController {
    @Autowired
    ClassificationCategoriesService classificationCategoriesService;

    @GetMapping(path = "/paged", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public Page<ClassificationCategories> getPagedClassificationCategories(@RequestParam(value = "search", defaultValue = "") String search, @RequestParam(value = "page", defaultValue = "0") Integer page, @RequestParam(value = "size", defaultValue = "10") Integer size){
        return classificationCategoriesService.getPagedClassificationCategories(search, page, size);
    }

    @GetMapping(path = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public Optional<ClassificationCategories> getOneClassificationCategories(@PathVariable("id") Long id){
        return classificationCategoriesService.getClassificationCategoriesById(id);
    }

    @PostMapping(path = "/create", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ClassificationCategories create(@RequestBody ClassificationCategories classificationCategories){
        return classificationCategoriesService.create(classificationCategories);
    }

    @DeleteMapping(path = "/delete/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public Boolean delete(@PathVariable("id") Long id){
        return classificationCategoriesService.delete(id);
    }
}
