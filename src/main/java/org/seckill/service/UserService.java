package org.seckill.service;

import org.seckill.entity.ResultBean;
import org.seckill.entity.User;

public interface UserService {

    User getUserByUserName(String userName);

    User getUserById(String userId);

    ResultBean addUser(User user);


}
