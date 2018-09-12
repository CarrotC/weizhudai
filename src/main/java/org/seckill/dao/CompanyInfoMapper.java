package org.seckill.dao;

import org.seckill.entity.Company;

import java.util.List;

public interface CompanyInfoMapper {
    public int insertCompany(Company company);

    public List<Company> selectAllCompany();

    public List<Company> selectCompanyByType(String Type);

    public Company selectCompanyByName(String name);

    //public List<Company> selectCompanyByFuzzyName(String input);
}
