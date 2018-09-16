package org.seckill.dao;

import org.seckill.entity.CompTax;

import java.util.List;

public interface CompTaxMapper {
    public List<CompTax> selectCompTaxById(String id);
}
