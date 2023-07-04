package com.shopspace.shopspaceservice.service;

import com.shopspace.shopspaceservice.model.TypeClassification;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface TypeClassificationService {
    Page<TypeClassification> getPagedTypesClassifications(String search, Integer page, Integer size);

    Optional<TypeClassification> getTypeClassificationById(Long id);

    TypeClassification create(TypeClassification typeClassification);

    Boolean delete(Long id);
}
