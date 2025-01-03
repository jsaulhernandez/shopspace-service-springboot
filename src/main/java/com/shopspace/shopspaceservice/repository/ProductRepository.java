package com.shopspace.shopspaceservice.repository;

import com.shopspace.shopspaceservice.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT p FROM Product p WHERE (:search IS NULL or (p.title LIKE CONCAT('%', :search, '%') OR p.name LIKE CONCAT('%', :search, '%') OR p.model LIKE CONCAT('%', :search, '%') OR p.modelNumber LIKE CONCAT('%', :search, '%'))) ORDER BY p.id DESC")
    Page<Product> getAllProducts(@Param("search") String Search, Pageable pageable);

    // web
    @Query("SELECT DISTINCT p FROM Product p JOIN p.viewProducts vp WHERE p.status = 1 AND vp.stock > 0 ORDER BY p.id DESC")
    List<Product> getLastProductsWithLimit(Pageable pageable);

    @Query("SELECT DISTINCT p FROM Product p JOIN p.viewProducts vp JOIN p.typeClassification tc join tc.classificationCategories cc join cc.categories ct join ct.category c WHERE p.status = 1 AND vp.stock > 0 AND (:idCategory IS NULL OR c.id = :idCategory) ORDER BY p.id DESC")
    List<Product> getProductsByCategoryWithLimit(@Param("idCategory") Long idCategory, Pageable pageable);

    @Query("SELECT DISTINCT p FROM Product p JOIN p.viewProducts vp JOIN p.typeClassification tc WHERE p.status = 1 AND p.id != :idProduct AND vp.stock > 0 AND tc.id = :idTypeClassification ORDER BY p.id DESC")
    List<Product> getProductsByTypeClassificationWithLimit(@Param("idProduct") Long idProduct, @Param("idTypeClassification") Long idTypeClassification, Pageable pageable);

    @Query(value = "SELECT DISTINCT sp.* FROM ss_product sp INNER JOIN ss_view_product svp ON svp.product_id = sp.id WHERE sp.status = 1 AND svp.stock > 0 AND YEARWEEK(sp.release_date) = YEARWEEK(NOW()) AND( SELECT COUNT(svp2.id) AS total FROM ss_view_product svp2 INNER JOIN ss_sale_body ssb ON ssb.product_id = svp2.id AND svp2.product_id = sp.id) >= :totalSales ORDER BY sp.id DESC", nativeQuery = true)
    List<Product> getProductsByWeekWithLimit(@Param("totalSales") Integer totalSales, Pageable pageable);

    @Query("SELECT DISTINCT p FROM Product p JOIN p.viewProducts vp JOIN p.typeClassification tc WHERE p.status = 1 AND vp.stock > 0 AND (SELECT COUNT(vp.id) FROM ViewProduct vp INNER JOIN SaleBody sb ON sb.product.id = vp.id AND vp.productId = p.id) >= :totalSales ORDER BY p.id DESC")
    List<Product> getMostSellingProducts(@Param("totalSales") Integer totalSales, Pageable pageable);
}
