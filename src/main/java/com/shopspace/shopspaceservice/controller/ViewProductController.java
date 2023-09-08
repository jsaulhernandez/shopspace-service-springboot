package com.shopspace.shopspaceservice.controller;

import com.shopspace.shopspaceservice.model.ViewProduct;
import com.shopspace.shopspaceservice.service.ViewProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/view-product")
public class ViewProductController {
    @Autowired
    ViewProductService viewProductService;

    @GetMapping(path = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public Optional<ViewProduct> getViewProduct(@PathVariable("id") Long id){
        return viewProductService.getViewProductById(id);
    }
    @PostMapping(path = "/create", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ViewProduct create(@RequestBody ViewProduct viewProduct){
        return viewProductService.create(viewProduct);
    }
}
