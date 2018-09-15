package org.seckill.service;

import org.seckill.entity.CashFlow;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CashFlowService {
    public List<CashFlow> getCashFlowById(String id);
}
