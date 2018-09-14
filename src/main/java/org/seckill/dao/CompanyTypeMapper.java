package org.seckill.dao;

import org.seckill.entity.CompanyType;

import java.util.List;

public interface CompanyTypeMapper {

    List<CompanyType> getAllCompany();

    List<String> getAllCompanyType();

    List<CompanyType> getAllCompanyByType(String companyType);

    List<CompanyType> getCompanyByFuzzyName(String name);
}
