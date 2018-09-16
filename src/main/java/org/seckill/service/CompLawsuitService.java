package org.seckill.service;

import org.seckill.entity.CompLawsuit;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CompLawsuitService {
    public List<CompLawsuit> getCompLawsuitById(String id);
}
