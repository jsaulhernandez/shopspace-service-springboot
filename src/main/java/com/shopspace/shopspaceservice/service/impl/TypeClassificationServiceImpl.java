package com.shopspace.shopspaceservice.service.impl;

import com.shopspace.shopspaceservice.model.TypeClassification;
import com.shopspace.shopspaceservice.repository.TypeClassificationRepository;
import com.shopspace.shopspaceservice.service.TypeClassificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypeClassificationServiceImpl implements TypeClassificationService {
    Logger logger = LoggerFactory.getLogger(TypeClassificationServiceImpl.class);
    @Autowired
    private TypeClassificationRepository typeClassificationRepository;

    @Override
    public Page<TypeClassification> getPagedTypesClassifications(String search, Integer page, Integer size){
        return typeClassificationRepository.getAllTypesClassifications(search, PageRequest.of(page, size));
    }

    @Override
    public List<TypeClassification> getTypesClassificationsByStatus(Integer status){
        return typeClassificationRepository.findByStatus(status);
    }

    @Override
    public Optional<TypeClassification> getTypeClassificationById(Long id){
        return typeClassificationRepository.findById(id);
    }

    @Override
    public TypeClassification create(TypeClassification typeClassification){
        return typeClassificationRepository.save(typeClassification);
    }

    @Override
    public Boolean delete(Long id){
        try {
            typeClassificationRepository.deleteById(id);
            return true;
        }catch (Exception e){
            logger.error("Exception delete type classification -> {0}", e);
            return false;
        }
    }

    // Todo: methods for web site
    @Override
    public List<TypeClassification> getMostSellingTypeClassificationWithLimit(Integer totalSales, Integer page, Integer size) {
        return typeClassificationRepository.getMostSellingTypeClassification(totalSales, PageRequest.of(page, size));
    }

    @Override
    public Integer getTypeClassificationAvailableByProduct(Long idTypeClassification){
        return typeClassificationRepository.getTypeClassificationAvailableByProduct(idTypeClassification);
    }
}
