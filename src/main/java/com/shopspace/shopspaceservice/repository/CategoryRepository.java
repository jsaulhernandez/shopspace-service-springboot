package com.shopspace.shopspaceservice.repository;

import com.shopspace.shopspaceservice.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query("SELECT c FROM Category c WHERE (:search IS NULL or c.name LIKE CONCAT('%', :search, '%')) ORDER BY c.id DESC")
    Page<Category> getAllCategories(@Param("search") String Search, Pageable pageable);

    //Methods for web
    List<Category> findByStatus(Integer status);
    @Query(value = "SELECT * FROM ss_category sc WHERE (SELECT count(sc2.id) FROM ss_category sc2 INNER JOIN ss_categories scs ON scs.category_id = sc2.id INNER JOIN ss_classification_categories scc ON scc.categories_id = scs.id INNER JOIN ss_type_classification stc ON stc.classification_categories_id = scc.id INNER JOIN ss_product sp ON sp.type_classification_id = stc.id INNER JOIN ss_sale_body ssb ON ssb.product_id = sp.id WHERE sc2.id = sc.id) >= :totalSales", nativeQuery = true)
    List<Category> getTopCategories(@Param("totalSales") Integer totalSales);
}
