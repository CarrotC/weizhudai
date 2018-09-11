package org.seckill.util;

import org.seckill.entity.Company;

import java.util.List;

public interface CompanyListSorter {

    public List<Company> sortByName(List<Company> companyList);

    public List<Company> sortByDate(List<Company> companyList);

    public List<Company> sortByCredit(List<Company> companyList);
}
