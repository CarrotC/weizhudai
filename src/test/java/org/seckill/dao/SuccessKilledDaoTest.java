package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

//junit在启动时加载springIOC容器
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件的位置
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SuccessKilledDaoTest {

    //注入Dao实现类依赖
//    @Resource
//    private SuccessKilledDao successKilledDao;
//
//    @Test
//    public void insertSuccessKilled() {
//        long id = 1001L;
//        long userPhone = 13502187724L;
//        int insertContent = successKilledDao.insertSuccessKilled(id,userPhone);
//        System.out.println(insertContent);
//    }
//
//    @Test
//    public void queryByIdWithSeckill() {
//        long id = 1001L;
//        long userPhone = 13502187724L;
//        SuccessKilled successKilled = successKilledDao.queryByIdWithSeckill(id,userPhone);
//        System.out.println(successKilled);
//        System.out.println(successKilled.getSeckill());
//    }
}