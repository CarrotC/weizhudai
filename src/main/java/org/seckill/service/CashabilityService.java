package org.seckill.service;

import org.seckill.entity.Cashability;

import java.util.List;

public interface CashabilityService {
    public List<Cashability> getCashabilityById(String id);

}
