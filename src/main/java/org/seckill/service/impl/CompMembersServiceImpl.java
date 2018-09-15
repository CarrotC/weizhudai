package org.seckill.service.impl;

import org.seckill.dao.CompMembersMapper;
import org.seckill.entity.CompMembers;
import org.seckill.service.CompMembersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompMembersServiceImpl implements CompMembersService {
    @Autowired
    CompMembersMapper compMembersMapper;
    @Override
    public List<CompMembers> getCompMembersById(String id) {
        return compMembersMapper.selectCompMembersById(id);
    }
}
