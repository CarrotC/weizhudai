package org.seckill.service;

import org.seckill.entity.DebtRatio;

import java.util.List;

public interface DebtRatioService {
    public List<DebtRatio> getDebtRatioById(String id);
}
