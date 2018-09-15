package org.seckill.dao;

import org.seckill.entity.CompFormerName;

import java.util.List;

public interface CompFormerNameMapper {
    public List<CompFormerName> selectCompFormerNameById(String id);
}
