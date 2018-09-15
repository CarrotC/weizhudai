package org.seckill.service.impl;

import org.seckill.dao.CompFormerNameMapper;
import org.seckill.entity.CompFormerName;
import org.seckill.service.CompFormerNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompFormerNameServiceImpl implements CompFormerNameService {
    @Autowired
    CompFormerNameMapper compFormerNameMapper;

    @Override
    public CompFormerName getCompFormerNameById(String id) {
        return compFormerNameMapper.selectCompFormerNameById(id);
    }
}
