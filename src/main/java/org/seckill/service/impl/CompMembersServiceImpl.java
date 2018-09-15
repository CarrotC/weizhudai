package org.seckill.service.impl;

import org.seckill.dao.CompMembersMapper;
import org.seckill.entity.CompMembers;
import org.seckill.service.CompMembersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompMembersServiceImpl implements CompMembersService {
    @Autowired
    CompMembersMapper compMembersMapper;
    @Override
    public CompMembers getCompMembersById(String id) {
        return compMembersMapper.selectCompMembersById(id);
    }
}
