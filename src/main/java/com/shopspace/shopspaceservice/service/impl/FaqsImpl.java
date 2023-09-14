package com.shopspace.shopspaceservice.service.impl;

import com.shopspace.shopspaceservice.model.Faq;
import com.shopspace.shopspaceservice.repository.FaqsRepository;
import com.shopspace.shopspaceservice.service.FaqsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FaqsImpl implements FaqsService {
    Logger logger = LoggerFactory.getLogger(FaqsImpl.class);
    @Autowired
    private FaqsRepository faqsRepository;

    @Override
    public Page<Faq> getPagedFaqs(String search, Integer page, Integer size){
        return faqsRepository.getAllFaqs(search, PageRequest.of(page, size));
    }

    @Override
    public Optional<Faq> getFaqById(Long id){
        return faqsRepository.findById(id);
    }

    @Override
    public Faq create(Faq faq){
        return faqsRepository.save(faq);
    }

    @Override
    public Boolean delete(Long id){
        try {
            faqsRepository.deleteById(id);
            return true;
        }catch (Exception e){
            logger.error("Exception delete faq -> {0}", e);
            return false;
        }
    }

    @Override
    public List<Faq> getFaqsByStatus(Integer status){
        return faqsRepository.findByStatus(status);
    }
}
