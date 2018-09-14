package org.seckill.dao;

import org.seckill.entity.AssetManagementRatio;

import java.util.List;

public interface AssetManagementRatioMapper {
    public List<AssetManagementRatio> selectAssetManagementRatioById(String id);
}
