package org.seckill.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.CompanyType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;


//junit在启动时加载springIOC容器
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件的位置
@ContextConfiguration({"classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"})
public class CompanyTypeServiceTest {

    @Autowired
    private CompanyTypeService companyTypeService;

    @Test
    public void getAllCompany() {
        List<CompanyType> result = this.companyTypeService.getAllCompany();
        System.out.println(result.size());
    }

    @Test
    public void getAllCompanyType() {
        List<String> result = this.companyTypeService.getAllCompanyType();
        System.out.println(result.size());
    }

    @Test
    public void getAllCompanyByType() {
        String companyType = "房地产业(K)";
        List<CompanyType> result = this.companyTypeService.getAllCompanyByType(companyType);
        System.out.println(result.size());
    }
}