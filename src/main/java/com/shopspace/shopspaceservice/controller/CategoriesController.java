package com.shopspace.shopspaceservice.controller;

import com.shopspace.shopspaceservice.model.Categories;
import com.shopspace.shopspaceservice.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categories")
public class CategoriesController {
    @Autowired
    CategoriesService categoriesService;

    @GetMapping(path = "/paged", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public Page<Categories> getPagedCategories(@RequestParam(value = "search", defaultValue = "") String search, @RequestParam(value = "page", defaultValue = "0") Integer page, @RequestParam(value = "size", defaultValue = "10") Integer size) {
        return categoriesService.getPagedCategories(search, page, size);
    }

    @GetMapping(path = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public Optional<Categories> getOneCategories(@PathVariable("id") Long id) {
        return categoriesService.getCategoriesById(id);
    }

    @PostMapping(path = "/create", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public Categories create(@RequestBody Categories categories){
        return categoriesService.create(categories);
    }

    @DeleteMapping(path = "/delete/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public Boolean delete(@PathVariable("id") Long id){
        return categoriesService.delete(id);
    }

    @GetMapping(path = "/by-status", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public List<Categories> getCategoriesByStatus(@RequestParam(value = "status", defaultValue = "1") Integer status) {
        return categoriesService.getCategoriesByStatus(status);
    }
}
