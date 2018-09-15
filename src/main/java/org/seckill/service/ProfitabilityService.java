package org.seckill.service;

import org.seckill.entity.Profitability;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ProfitabilityService {
    public List<Profitability> getProfitabilityById(String id);
}
