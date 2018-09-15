package org.seckill.util;

import org.seckill.entity.Flow;
import org.seckill.entity.Loan;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class ListSortByDate {
    public static void flowListSort(List<Flow> resultList) {
        Collections.sort(resultList, new Comparator<Flow>() {

            @Override
            public int compare(Flow o1, Flow o2) {
                int flag = o1.getOperateTime().compareTo(o2.getOperateTime());
                return flag;
            }
        });
    }

    public static void loanListSort(List<Loan> resultList) {
        Collections.sort(resultList, new Comparator<Loan>() {

            @Override
            public int compare(Loan o1, Loan o2) {
                int flag = o1.getOperateDate().compareTo(o2.getOperateDate());
                return flag;
            }
        });
    }

}
