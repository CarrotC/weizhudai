package org.seckill.service;

import org.seckill.entity.CashFlow;

import java.util.List;

public interface CashFlowService {
    public List<CashFlow> getCashFlowById(String id);
}
