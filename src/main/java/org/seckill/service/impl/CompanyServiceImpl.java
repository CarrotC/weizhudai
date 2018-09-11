package org.seckill.service.impl;

import org.seckill.entity.CompanyType;
import org.seckill.service.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

//    @Autowired
//    CompanyInfoMapper companyInfoMapper;
//
//    /**
//     * 添加企业注册信息
//     * @param company
//     * @return
//     */
//    @Override
//    public ResultBean addCompany(Company company) {
//        int i = this.companyInfoMapper.insertCompany(company);
//
//        if(i!=1) {
//            return new ResultBean(500,"添加企业信息失败");
//        } else {
//            return new ResultBean(200,"添加企业信息成功");
//        }
//    }
//
//    /**
//     * 获取所有企业
//     * @return
//     */
//    @Override
//    public List<Company> getAllCompany() {
//        return this.companyInfoMapper.selectAllCompany();
//    }
//
//    /**
//     * 根据企业类型获取企业
//     * @param type
//     * @return
//     */
//    @Override
//    public List<Company> getCompanyByType(String type) {
//        return this.companyInfoMapper.selectCompanyByType(type);
//    }
//
//    /**
//     * 根据用户输入的企业名称获取相关企业
//     * @param input
//     * @return
//     */
//    @Override
//    public List<Company> getCompanyBySearch(String input) {
//        return this.companyInfoMapper.selectCompanyBySearch(input);
//    }
}
