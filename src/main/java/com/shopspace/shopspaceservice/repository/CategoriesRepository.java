package com.shopspace.shopspaceservice.repository;

import com.shopspace.shopspaceservice.model.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriesRepository extends JpaRepository<Categories, Long> {
}
