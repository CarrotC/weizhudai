package org.seckill.service;

import org.seckill.entity.CompShareholder;
import org.springframework.stereotype.Service;

@Service
public interface CompShareHolderService {
    public CompShareholder getCompShareholderById(String id);
}
