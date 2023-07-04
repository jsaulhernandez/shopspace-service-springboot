package com.shopspace.shopspaceservice.service.impl;

import com.shopspace.shopspaceservice.model.Color;
import com.shopspace.shopspaceservice.repository.ColorRepository;
import com.shopspace.shopspaceservice.service.ColorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ColorServiceImpl implements ColorService {
    Logger logger = LoggerFactory.getLogger(ColorServiceImpl.class);
    @Autowired
    private ColorRepository colorRepository;

    @Override
    public Page<Color> getPagedColors(String search, Integer page, Integer size){
        return colorRepository.getAllColors(search, PageRequest.of(page, size));
    }

    @Override
    public Optional<Color> getColorById(Long id){
        return colorRepository.findById(id);
    }

    @Override
    public Color create(Color color){
        return colorRepository.save(color);
    }

    @Override
    public Boolean delete(Long id){
        try {
            colorRepository.deleteById(id);
            return true;
        }catch (Exception e){
            logger.error("Exception delete color -> {0}", e);
            return false;
        }
    }
}
