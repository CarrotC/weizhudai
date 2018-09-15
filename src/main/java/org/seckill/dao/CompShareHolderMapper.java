package org.seckill.dao;

import org.seckill.entity.CompShareholder;

import java.util.List;

public interface CompShareHolderMapper {
    public List<CompShareholder> selectCompShareHolderById(String id);
}
