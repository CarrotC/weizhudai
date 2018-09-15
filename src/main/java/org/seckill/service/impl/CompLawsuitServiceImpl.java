package org.seckill.service.impl;

import org.seckill.dao.CompLawsuitMapper;
import org.seckill.entity.CompLawsuit;
import org.seckill.service.CompLawsuitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompLawsuitServiceImpl implements CompLawsuitService {
    @Autowired
    CompLawsuitMapper compLawsuitMapper;

    @Override
    public List<CompLawsuit> getCompLawsuitById(String id) {
        return compLawsuitMapper.selectCompLawsuitById(id);
    }
}
