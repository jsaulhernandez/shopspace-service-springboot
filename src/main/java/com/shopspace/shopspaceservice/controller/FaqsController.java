package com.shopspace.shopspaceservice.controller;

import com.shopspace.shopspaceservice.model.Faq;
import com.shopspace.shopspaceservice.service.FaqsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/faq")
public class FaqsController {
    @Autowired
    FaqsService faqsService;

    @GetMapping(path = "/paged", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public Page<Faq> getPagedFaqs(@RequestParam(value = "search", defaultValue = "") String search, @RequestParam(value = "page", defaultValue = "0") Integer page, @RequestParam(value = "size", defaultValue = "10") Integer size){
        return faqsService.getPagedFaqs(search, page, size);
    }

    @GetMapping(path = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public Optional<Faq> getOneFaq(@PathVariable("id") Long id){
        return faqsService.getFaqById(id);
    }

    @PostMapping(path = "/create", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public Faq create(@RequestBody Faq faq){
        return faqsService.create(faq);
    }

    @DeleteMapping(path = "/delete/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public Boolean delete(@PathVariable("id") Long id){
        return faqsService.delete(id);
    }

    @GetMapping(path = "/by-status", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public List<Faq> getFaqsByStatus(@RequestParam(value = "status", defaultValue = "1") Integer status) {
        return faqsService.getFaqsByStatus(status);
    }
}
