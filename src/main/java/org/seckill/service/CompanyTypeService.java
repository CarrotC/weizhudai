package org.seckill.service;

import org.seckill.entity.CompanyType;

import java.util.List;

public interface CompanyTypeService {

    public List<CompanyType> getAllCompany();

    public List<String> getAllCompanyType();

    public List<CompanyType> getAllCompanyByType(String companyType);
}
