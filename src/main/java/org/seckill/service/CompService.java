package org.seckill.service;

import org.seckill.entity.Comp;
import org.springframework.stereotype.Service;

@Service
public interface CompService {
    public Comp getCompById(String id);
}
