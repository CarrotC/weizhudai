package org.seckill.dao;

import org.seckill.entity.ProfitabilityRatio;

import java.util.List;

public interface ProfitabilityRatioMapper {
    public List<ProfitabilityRatio> selectProfitabilityRatioById(String id);
}
