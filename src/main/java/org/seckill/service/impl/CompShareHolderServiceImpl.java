package org.seckill.service.impl;

import org.seckill.dao.CompShareHolderMapper;
import org.seckill.entity.CompShareholder;
import org.seckill.service.CompShareHolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompShareHolderServiceImpl implements CompShareHolderService {
    @Autowired
    CompShareHolderMapper compShareHolderMapper;

    @Override
    public CompShareholder getCompShareholderById(String id) {
        return compShareHolderMapper.selectCompShareHolderById(id);
    }
}
