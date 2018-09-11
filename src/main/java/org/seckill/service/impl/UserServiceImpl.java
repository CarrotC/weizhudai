package org.seckill.service.impl;

import org.seckill.dao.UserMapper;
import org.seckill.entity.ResultBean;
import org.seckill.entity.User;
import org.seckill.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    /**
     * 根据用户名获取用户
     * @param userName
     * @return
     */
    public User getUserByUserName(String userName) {
        return this.userMapper.selectUserByUserName(userName);
    }

    /**
     * 根据用户id获取用户
     * @param userId
     * @return
     */
    public User getUserById(String userId) {
        return this.userMapper.selectUserByUserName(userId);
    }

    /**
     * 添加用户
     * @param user
     * @return
     */
    public ResultBean addUser(User user){
        int i = this.userMapper.insertUser(user);

        if(i!=1) {
            return new ResultBean(500,"添加用户信息失败");
        } else {
            return new ResultBean(200,"添加用户信息成功");
        }
    }
}
