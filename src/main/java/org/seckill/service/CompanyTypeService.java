package org.seckill.service;

import org.seckill.entity.CompanyType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CompanyTypeService {

    public List<CompanyType> getAllCompany();

    public List<String> getAllCompanyType();

    public List<CompanyType> getAllCompanyByType(String companyType);

    public CompanyType getCompanyById(String companyId);

    public List<CompanyType> getCompanyByFuzzyName(String name);
}
