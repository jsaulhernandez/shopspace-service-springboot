package com.shopspace.shopspaceservice.controller;

import com.shopspace.shopspaceservice.model.Product;
import com.shopspace.shopspaceservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping(path = "/paged", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public Page<Product> getPagedProducts(@RequestParam(value = "search", defaultValue = "") String search, @RequestParam(value = "page", defaultValue = "0") Integer page, @RequestParam(value = "size", defaultValue = "10") Integer size) {
        return productService.getPagedProducts(search, page, size);
    }

    @GetMapping(path = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public Optional<Product> getOneProduct(@PathVariable("id") Long id){
        return productService.getProductById(id);
    }

    @PostMapping(path = "/create", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public Product create(@RequestBody Product product){
        return productService.create(product);
    }

    @DeleteMapping(path = "/delete/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public Boolean delete(@PathVariable("id") Long id){
        return productService.delete(id);
    }

    @GetMapping(path = "/limit-data", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public List<Product> getLastProductsWithLimit(@RequestParam(value = "page", defaultValue = "0") Integer page, @RequestParam(value = "size", defaultValue = "10") Integer size) {
        return productService.getLastProductsWithLimit(page, size);
    }

    @GetMapping(path = "/by-category", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public List<Product> getProductsByCategoryWithLimit(@RequestParam(value = "idCategory", required = false) Long idCategory, @RequestParam(value = "page", defaultValue = "0") Integer page, @RequestParam(value = "size", defaultValue = "10") Integer size) {
        return productService.getProductsByCategoryWithLimit(idCategory, page, size);
    }

    @GetMapping(path = "/by-type-classification", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public List<Product> getProductsByTypeClassificationWithLimit(@RequestParam(value = "idProduct") Long idProduct, @RequestParam(value = "idTypeClassification") Long idTypeClassification, @RequestParam(value = "page", defaultValue = "0") Integer page, @RequestParam(value = "size", defaultValue = "10") Integer size) {
        return productService.getProductsByTypeClassificationWithLimit(idProduct, idTypeClassification, page, size);
    }

    @GetMapping(path = "/by-week", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public List<Product> getProductsByWeekWithLimit(@RequestParam(value = "totalSales") Integer totalSales, @RequestParam(value = "page", defaultValue = "0") Integer page, @RequestParam(value = "size", defaultValue = "10") Integer size) {
        return productService.getProductsByWeekWithLimit(totalSales, page, size);
    }

    @GetMapping(path = "/most-selling", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public List<Product> getMostSellingProducts(@RequestParam(value = "totalSales") Integer totalSales, @RequestParam(value = "page", defaultValue = "0") Integer page, @RequestParam(value = "size", defaultValue = "10") Integer size) {
        return productService.getMostSellingProducts(totalSales, page, size);
    }
}
