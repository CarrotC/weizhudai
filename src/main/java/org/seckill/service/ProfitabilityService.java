package org.seckill.service;

import org.seckill.entity.Profitability;

import java.util.List;

public interface ProfitabilityService {
    public List<Profitability> getProfitabilityById(String id);
}
