package org.seckill.service;

import org.seckill.entity.CompFormerName;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CompFormerNameService {
    public List<CompFormerName> getCompFormerNameById(String id);
}
