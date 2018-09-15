package org.seckill.dao;

import org.seckill.entity.CompMembers;

import java.util.List;

public interface CompMembersMapper {
    public List<CompMembers> selectCompMembersById(String id);
}
