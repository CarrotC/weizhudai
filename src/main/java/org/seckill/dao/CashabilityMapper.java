package org.seckill.dao;

import org.seckill.entity.Cashability;

import java.util.List;

public interface CashabilityMapper {
    public List<Cashability> selectCashabilityById(String id);
}
