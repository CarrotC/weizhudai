package org.seckill.service;

import org.seckill.entity.CompMembers;
import org.springframework.stereotype.Service;

@Service
public interface CompMembersService {
    public CompMembers getCompMembersById(String id);
}
