package org.seckill.service;

import org.seckill.entity.Company;
import org.seckill.entity.CompanyType;
import org.seckill.entity.ResultBean;

import java.util.List;

public interface CompanyService {
    public ResultBean addCompany(Company company);

    public List<Company> getAllCompany();

    public List<Company> getCompanyByType(String type);

    public Company getCompanyByName(String name);

//    public List<Company> getCompanyBySearch(String input);


}
