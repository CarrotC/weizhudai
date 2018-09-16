package org.seckill.service;

import org.seckill.entity.CompTax;

import java.util.List;

public interface CompTaxService {
    public List<CompTax> getCompTaxById(String id);
}
