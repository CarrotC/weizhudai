package org.seckill.service.impl;

import org.seckill.dao.CashFlowMapper;
import org.seckill.entity.CashFlow;
import org.seckill.service.CashFlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CashFlowServiceImpl implements CashFlowService {
    @Autowired
    CashFlowMapper cashFlowMapper;

    @Override
    public List<CashFlow> getCashFlowById(String id) {
        return cashFlowMapper.selectCashFlowById(id);
    }
}
