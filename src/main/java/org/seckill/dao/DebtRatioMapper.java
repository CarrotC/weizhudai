package org.seckill.dao;

import org.seckill.entity.DebtRatio;

import java.util.List;

public interface DebtRatioMapper {
    public List<DebtRatio> selectDebtRatioById(String id);
}
