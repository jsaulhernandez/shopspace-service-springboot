package com.shopspace.shopspaceservice.repository;

import com.shopspace.shopspaceservice.model.TypeClassification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TypeClassificationRepository extends JpaRepository<TypeClassification, Long> {
    @Query("SELECT tc FROM TypeClassification tc WHERE (:search IS NULL or tc.name LIKE CONCAT('%', :search, '%')) ORDER BY tc.id DESC")
    Page<TypeClassification> getAllTypesClassifications(@Param("search") String Search, Pageable pageable);
    List<TypeClassification> findByStatus(Integer status);
    @Query(value = "SELECT DISTINCT stc.* FROM ss_type_classification stc INNER JOIN ss_product sp ON sp.type_classification_id = stc.id WHERE stc.status = 1 AND( SELECT COUNT(svp.id) AS total FROM ss_view_product svp INNER JOIN ss_sale_body ssb ON ssb.product_id = svp.id WHERE svp.product_id = sp.id) >= :totalSales ORDER BY stc.name ASC", nativeQuery = true)
    List<TypeClassification> getMostSellingTypeClassification(@Param("totalSales") Integer totalSales, Pageable pageable);
    @Query(value = "SELECT COALESCE(COUNT(stc.id), 0) AS total FROM ss_type_classification stc INNER JOIN ss_product sp ON sp.type_classification_id = stc.id INNER JOIN ss_view_product svp ON svp.product_id = sp.id WHERE stc.id = :id", nativeQuery = true)
    Integer getTypeClassificationAvailableByProduct(@Param("id") Long idTypeClassification);
}
