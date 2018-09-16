package org.seckill.service;

import org.seckill.entity.CompMembers;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CompMembersService {
    public List<CompMembers> getCompMembersById(String id);
}
