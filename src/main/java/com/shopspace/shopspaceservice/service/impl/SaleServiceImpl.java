package com.shopspace.shopspaceservice.service.impl;

import com.shopspace.shopspaceservice.model.SaleBody;
import com.shopspace.shopspaceservice.model.SaleHeader;
import com.shopspace.shopspaceservice.repository.SaleBodyRepository;
import com.shopspace.shopspaceservice.repository.SaleHeaderRepository;
import com.shopspace.shopspaceservice.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SaleServiceImpl implements SaleService {
    @Autowired
    SaleHeaderRepository saleHeaderRepository;
    @Autowired
    SaleBodyRepository saleBodyRepository;

    @Override
    public SaleHeader create(SaleHeader saleHeader){
        List<SaleBody> detail = saleHeader.getDetail();

        // saving sale header
        saleHeader.setDetail(new ArrayList<>());
        SaleHeader sale = saleHeaderRepository.save(saleHeader);

        // setting header id and saving details
        detail = detail.stream().peek(saleBody -> saleBody.setSaleHeaderId(sale.getId())).collect(Collectors.toList());
        detail = saleBodyRepository.saveAll(detail);

        // setting list again
        sale.setDetail(detail);

        return sale;
    }
}
