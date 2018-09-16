package org.seckill.dao;

import org.seckill.entity.CompLawsuit;

import java.util.List;

public interface CompLawsuitMapper {
    public List<CompLawsuit> selectCompLawsuitById(String id);
}
