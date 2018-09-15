package org.seckill.service;

import org.seckill.entity.DebtRatio;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface DebtRatioService {
    public List<DebtRatio> getDebtRatioById(String id);
}
