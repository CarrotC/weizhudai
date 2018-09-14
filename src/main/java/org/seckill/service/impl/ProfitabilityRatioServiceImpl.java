package org.seckill.service.impl;

import org.seckill.dao.ProfitabilityRatioMapper;
import org.seckill.entity.ProfitabilityRatio;
import org.seckill.service.ProfitabilityRatioService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProfitabilityRatioServiceImpl implements ProfitabilityRatioService {
    @Autowired
    ProfitabilityRatioMapper profitabilityRatioMapper;

    @Override
    public List<ProfitabilityRatio> getProfitabilityRatioById(String id) {
        return profitabilityRatioMapper.selectProfitabilityRatioById(id);
    }
}
