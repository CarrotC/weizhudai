package org.seckill.service;

import org.seckill.entity.Cashability;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CashabilityService {
    public List<Cashability> getCashabilityById(String id);

}
