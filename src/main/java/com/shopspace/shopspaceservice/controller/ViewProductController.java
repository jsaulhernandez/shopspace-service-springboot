package com.shopspace.shopspaceservice.controller;

import com.shopspace.shopspaceservice.model.ViewProduct;
import com.shopspace.shopspaceservice.service.ViewProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/view-product")
public class ViewProductController {
    @Autowired
    ViewProductService viewProductService;

    @PostMapping(path = "/create", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ViewProduct create(@RequestBody ViewProduct viewProduct){
        return viewProductService.create(viewProduct);
    }
}
