package org.seckill.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"})
public class SeckillServiceTest {

//    private final Logger logger = LoggerFactory.getLogger(this.getClass());
//
//    @Autowired
//    private SeckillService seckillService;
//
//    @Test
//    public void getSeckillList() {
//        List<Seckill> list = seckillService.getSeckillList();
//        logger.info("list={}", list);
//    }
//
//    @Test
//    public void getSeckillById() {
//        long id = 1000L;
//        Seckill seckill = seckillService.getSeckillById(id);
//        logger.info("seckill={}", seckill);
//    }
//
//    @Test
//    public void exportSeckillUrl() {
//        long id = 1000L;
//        Exposer exposer = seckillService.exportSeckillUrl(id);
//
//        logger.info("exposer={}", exposer.toString());
//    }
//
//    //5184968e82da4d748c81d9efc852ce96
//    @Test
//    public void executeSeckill() {
//        long id = 1003L;
//        long phone = 15320404789L;
//        Exposer exposer = seckillService.exportSeckillUrl(id);
//        if(exposer.isExposed()){
//            logger.info("exposer={}",exposer);
//            String md5 = exposer.getMd5();
//            try {
//                SeckillExecution seckillExecution = seckillService.executeSeckill(id, phone, md5);
//                logger.info("result={}", seckillExecution.toString());
//            } catch (RepeatkillException re) {
//                logger.error(re.getMessage());
//            } catch (SeckillCloseException se) {
//                logger.error(se.getMessage());
//            }
//        }else{
//            //秒杀未开启
//            logger.warn("exposer={}",exposer);
//        }
//
//    }
}