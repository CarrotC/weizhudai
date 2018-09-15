package org.seckill.service;

import org.seckill.entity.ResultBean;
import org.seckill.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    User getUserByUserName(String userName);

    User getUserById(String userId);

    ResultBean addUser(User user);


}
