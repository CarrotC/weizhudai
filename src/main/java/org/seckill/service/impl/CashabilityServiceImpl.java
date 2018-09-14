package org.seckill.service.impl;

import org.seckill.dao.CashabilityMapper;
import org.seckill.entity.Cashability;
import org.seckill.service.CashabilityService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CashabilityServiceImpl implements CashabilityService {
    @Autowired
    CashabilityMapper cashabilityMapper;

    @Override
    public List<Cashability> getCashabilityById(String id) {
        return cashabilityMapper.selectCashabilityById(id);
    }
}
