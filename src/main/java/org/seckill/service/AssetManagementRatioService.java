package org.seckill.service;

import org.seckill.entity.AssetManagementRatio;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface AssetManagementRatioService {
    public List<AssetManagementRatio> getAssetManagementRatioById(String id);
}
