package org.seckill.service;

import org.seckill.entity.CompShareholder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CompShareHolderService {
    public List<CompShareholder> getCompShareholderById(String id);
}
