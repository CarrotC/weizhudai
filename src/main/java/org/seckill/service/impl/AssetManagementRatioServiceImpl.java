package org.seckill.service.impl;

import org.seckill.dao.AssetManagementRatioMapper;
import org.seckill.entity.AssetManagementRatio;
import org.seckill.service.AssetManagementRatioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssetManagementRatioServiceImpl implements AssetManagementRatioService {
    @Autowired
    AssetManagementRatioMapper assetManagementRatioMapper;

    @Override
    public List<AssetManagementRatio> getAssetManagementRatioById(String id) {
        return assetManagementRatioMapper.selectAssetManagementRatioById(id);
    }
}
