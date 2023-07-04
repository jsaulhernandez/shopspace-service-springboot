package com.shopspace.shopspaceservice.controller;

import com.shopspace.shopspaceservice.model.Product;
import com.shopspace.shopspaceservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping(path = "/paged", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public Page<Product> getPagedProducts(@RequestParam(value = "search", defaultValue = "") String search, @RequestParam(value = "page", defaultValue = "0") Integer page, @RequestParam(value = "size", defaultValue = "10") Integer size){
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
}
