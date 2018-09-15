package org.seckill.service.impl;

import org.seckill.dao.CompTaxMapper;
import org.seckill.entity.CompTax;
import org.seckill.service.CompTaxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompTaxServiceImpl implements CompTaxService {
    @Autowired
    CompTaxMapper compTaxMapper;

    @Override
    public CompTax getCompTaxById(String id) {
        return compTaxMapper.selectCompTaxById(id);
    }
}
