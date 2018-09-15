package org.seckill.service;

import org.seckill.entity.CompFormerName;
import org.springframework.stereotype.Service;

@Service
public interface CompFormerNameService {
    public CompFormerName getCompFormerNameById(String id);
}
