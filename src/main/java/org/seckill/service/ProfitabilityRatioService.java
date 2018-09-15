package org.seckill.service;

import org.seckill.entity.ProfitabilityRatio;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ProfitabilityRatioService {
    public List<ProfitabilityRatio> getProfitabilityRatioById(String id);
}
