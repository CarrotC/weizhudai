package org.seckill.service.impl;

import org.seckill.dao.DebtRatioMapper;
import org.seckill.entity.DebtRatio;
import org.seckill.service.DebtRatioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DebtRatioServiceImpl implements DebtRatioService {
    @Autowired
    DebtRatioMapper debtRatioMapper;

    @Override
    public List<DebtRatio> getDebtRatioById(String id) {
        return debtRatioMapper.selectDebtRatioById(id);
    }
}
