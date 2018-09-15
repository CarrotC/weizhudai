package org.seckill.service.impl;

import org.seckill.dao.CompanyTypeMapper;
import org.seckill.entity.CompanyType;
import org.seckill.service.CompanyTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyTypeServiceImpl implements CompanyTypeService {

    @Autowired
    private CompanyTypeMapper companyTypeMapper;

    /**
     *
     * @return
     */
    @Override
    public List<CompanyType> getAllCompany(){
        return this.companyTypeMapper.getAllCompany();
    }

    /**
     *
     * @return
     */
    @Override
    public List<String> getAllCompanyType(){
        return this.companyTypeMapper.getAllCompanyType();
    }

    /**
     *
     * @param companyType
     * @return
     */
    @Override
    public List<CompanyType> getAllCompanyByType(String companyType){
        return this.companyTypeMapper.getAllCompanyByType(companyType);
    }

    /**
     *
     * @param companyId
     * @return
     */
    @Override
    public CompanyType getCompanyById(String companyId){
        return this.companyTypeMapper.getCompanyById(companyId);
    }

    @Override
    public List<CompanyType> getCompanyByFuzzyName(String name){
        return this.companyTypeMapper.getCompanyByFuzzyName(name);
    }
}
