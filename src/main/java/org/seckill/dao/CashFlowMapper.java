package org.seckill.dao;

import org.seckill.entity.CashFlow;

import java.util.List;

public interface CashFlowMapper {
    public List<CashFlow> selectCashFlowById(String id);
}
