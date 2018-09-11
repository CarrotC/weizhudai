package org.seckill.util.impl;

import org.seckill.entity.Company;
import org.seckill.util.CompanyListSorter;

import java.text.Collator;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CompanyListSorterImpl implements CompanyListSorter {
    /**
     * 根据企业名称排序
     * @param companyList
     * @return
     */
    @Override
    public List<Company> sortByName(List<Company> companyList) {
        Collections.sort(companyList, new Comparator<Company>(){
            /*
             *  int compare(Company c1, Company c2)返回一个基本类型的整型，
             * 返回负数表示：c1 小于c2，
             * 返回0 表示：c1和c2相等，
             * 返回正数表示：c1大于c2
             */
            public int compare(Company c1, Company c2) {
                Comparator<Object> com = Collator.getInstance(java.util.Locale.CHINA);
                return com.compare(c1.getCompanyName(), c2.getCompanyName());
            }
        });
        return companyList;
    }

    /**
     * 根据企业上市时间排序
     * @param companyList
     * @return
     */
    @Override
    public List<Company> sortByDate(List<Company> companyList) {
        Collections.sort(companyList, new Comparator<Company>(){
            /*
             *  int compare(Company c1, Company c2)返回一个基本类型的整型，
             * 返回负数表示：c1 小于c2，
             * 返回0 表示：c1和c2相等，
             * 返回正数表示：c1大于c2
             */
            public int compare(Company c1, Company c2) {
                return 0;

            }
        });
        return companyList;
    }

    /**
     * 根据企业信用分数排序
     * @param companyList
     * @return
     */
    @Override
    public List<Company> sortByCredit(List<Company> companyList) {
//        Collections.sort(companyList, new Comparator<Company>(){
//            /*
//             * int compare(Person p1, Person p2) 返回一个基本类型的整型，
//             * 返回负数表示：p1 小于p2，
//             * 返回0 表示：p1和p2相等，
//             * 返回正数表示：p1大于p2
//             */
//            public int compare(Company c1, Company c2) {
//                //按照Person的年龄进行升序排列
//                if(c1.getSocialCredit() > c2.getAge()){
//                    return 1;
//                }
//                if(c1.getAge() == c2.getAge()){
//                    return 0;
//                }
//                return -1;
//            }
//        });
        return null;
    }
}
