package com.shopspace.shopspaceservice.service;

import com.shopspace.shopspaceservice.model.TypeClassification;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface TypeClassificationService {
    Page<TypeClassification> getPagedTypesClassifications(String search, Integer page, Integer size);

    List<TypeClassification> getTypesClassificationsByStatus(Integer status);

    Optional<TypeClassification> getTypeClassificationById(Long id);

    TypeClassification create(TypeClassification typeClassification);

    Boolean delete(Long id);

    // Todo: methods for web site
    List<TypeClassification> getMostSellingTypeClassificationWithLimit(Integer totalSales, Integer page, Integer size);

    Integer getTypeClassificationAvailableByProduct(Long idTypeClassification);
}
