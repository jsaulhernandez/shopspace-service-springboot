package com.shopspace.shopspaceservice.service.impl;

import com.shopspace.shopspaceservice.model.Product;
import com.shopspace.shopspaceservice.repository.ProductRepository;
import com.shopspace.shopspaceservice.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Page<Product> getPagedProducts(String search, Integer page, Integer size){
        return productRepository.getAllProducts(search, PageRequest.of(page, size));
    }

    @Override
    public Optional<Product> getProductById(Long id){
        return productRepository.findById(id);
    }

    @Override
    public Product create(Product product){
        return productRepository.save(product);
    }

    @Override
    public Boolean delete(Long id){
        try {
            productRepository.deleteById(id);
            return true;
        }catch (Exception e){
            logger.error("Exception delete product -> {0}", e);
            return false;
        }
    }

    // Todo: methods for web site
    /**
     *
     * @param page contains the initial page
     * @param size limit of records to return
     * @return list with the limit of requested records
     */
    @Override
    public List<Product> getLastProductsWithLimit(Integer page, Integer size) {
        return productRepository.getLastProductsWithLimit(PageRequest.of(page, size));
    }

    /**
     * @param category id category to filter
     * @param page contains the initial page
     * @param size limit of records to return
     * @return product list by category
     */
    @Override
    public List<Product> getProductsByCategoryWithLimit(Long category, Integer page, Integer size) {
        return productRepository.getProductsByCategoryWithLimit(category, PageRequest.of(page, size));
    }

    /**
     *
     * @param idProduct idProduct that will not include in the list
     * @param typeClassification filter type to products, contains id of type classification
     * @param page contains the initial page
     * @param size limit of records to return
     * @return product list by typeClassification
     */
    @Override
    public List<Product> getProductsByTypeClassificationWithLimit(Long idProduct, Long typeClassification, Integer page, Integer size) {
        return productRepository.getProductsByTypeClassificationWithLimit(idProduct, typeClassification, PageRequest.of(page, size));
    }
}
