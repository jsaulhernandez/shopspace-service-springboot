package com.shopspace.shopspaceservice.service;

import com.shopspace.shopspaceservice.model.Color;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface ColorService {
    Page<Color> getPagedColors(String search, Integer page, Integer size);

    Optional<Color> getColorById(Long id);

    Color create(Color color);

    Boolean delete(Long id);
}
