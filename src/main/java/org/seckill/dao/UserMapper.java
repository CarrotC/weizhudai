package org.seckill.dao;

import org.seckill.entity.User;

public interface UserMapper {

    int insertUser(User user);

    int updateUser(User user);

    User selectUserByUserName(String userName);

    User selectUserById(String id);
}