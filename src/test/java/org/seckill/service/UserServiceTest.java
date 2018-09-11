package org.seckill.service;

import org.junit.Test;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.seckill.entity.ResultBean;
import org.seckill.entity.User;
import org.seckill.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

//junit在启动时加载springIOC容器
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件的位置
@ContextConfiguration({"classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"})
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void getUserByUserName() {

//        User user = this.userService.getUserByUserName("lll");
//        if(user!=null){
//            System.out.println("hhh");
//        }else{
//            System.out.println("xxxx");
//        }

        String x = StringUtils.MD5("xxxx");
        System.out.println(x);
    }

    @Test
    public void getUserById() {
    }

    @Test
    public void addUser() {

        User user = new User();
        user.setId("00005");
        user.setUserName("kkkz");
        user.setPassword("xxxx");
        user.setIsBank(new Byte("0"));
        ResultBean result = this.userService.addUser(user);
        System.out.println(result);
    }
}