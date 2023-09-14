package com.shopspace.shopspaceservice.service;

import com.shopspace.shopspaceservice.model.Faq;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface FaqsService {
    Page<Faq> getPagedFaqs(String search, Integer page, Integer size);

    Optional<Faq> getFaqById(Long id);

    Faq create(Faq faq);

    Boolean delete(Long id);

    List<Faq> getFaqsByStatus(Integer status);
}
