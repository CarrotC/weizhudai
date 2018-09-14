package org.seckill.service.impl;

import org.seckill.dao.ProfitabilityMapper;
import org.seckill.entity.Profitability;
import org.seckill.service.ProfitabilityService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProfitabilityServiceImpl implements ProfitabilityService {
    @Autowired
    ProfitabilityMapper profitabilityMapper;

    @Override
    public List<Profitability> getProfitabilityById(String id) {
        return profitabilityMapper.selectProfitabilityById(id);
    }
}
