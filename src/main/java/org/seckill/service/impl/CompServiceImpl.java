package org.seckill.service.impl;

import org.seckill.dao.CompMapper;
import org.seckill.entity.Comp;
import org.seckill.entity.CompMembers;
import org.seckill.service.CompService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompServiceImpl implements CompService {
    @Autowired
    CompMapper compMapper;

    @Override
    public Comp getCompById(String id) {
        return compMapper.selectCompById(id);
    }
}
