package com.shopspace.shopspaceservice.controller;

import com.shopspace.shopspaceservice.model.TypeClassification;
import com.shopspace.shopspaceservice.service.TypeClassificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/type-classification")
public class TypeClassificationController {
    @Autowired
    TypeClassificationService typeClassificationService;

    @GetMapping(path = "/paged", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public Page<TypeClassification> getPagedTypesClassifications(@RequestParam(value = "search", defaultValue = "") String search, @RequestParam(value = "page", defaultValue = "0") Integer page, @RequestParam(value = "size", defaultValue = "10") Integer size){
        return typeClassificationService.getPagedTypesClassifications(search, page, size);
    }

    @GetMapping(path = "/by-status", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public List<TypeClassification> getTypesClassificationsByStatus(@RequestParam(value = "status", defaultValue = "1") Integer status){
        return typeClassificationService.getTypesClassificationsByStatus(status);
    }

    @GetMapping(path = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public Optional<TypeClassification> getOneTypeClassification(@PathVariable("id") Long id) {
        return typeClassificationService.getTypeClassificationById(id);
    }

    @PostMapping(path = "/create", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public TypeClassification create(@RequestBody TypeClassification typeClassification){
        return typeClassificationService.create(typeClassification);
    }

    @DeleteMapping(path = "/delete/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public Boolean delete(@PathVariable("id") Long id){
        return typeClassificationService.delete(id);
    }
}
