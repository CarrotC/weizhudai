package org.seckill.dao;

import org.seckill.entity.Profitability;

import java.util.List;

public interface ProfitabilityMapper {
    public List<Profitability> selectProfitabilityById(String id);
}
