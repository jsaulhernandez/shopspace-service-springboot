package com.shopspace.shopspaceservice.service.impl;

import com.shopspace.shopspaceservice.repository.FaqsRepository;
import com.shopspace.shopspaceservice.service.FaqsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FaqsImpl implements FaqsService {
    @Autowired
    private FaqsRepository faqsRepository;
}
