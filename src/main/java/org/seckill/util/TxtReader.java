package org.seckill.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.seckill.entity.Flow;
import org.seckill.entity.Loan;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class TxtReader {

    public static List txtReader(String name) {

        List<String> arrayList = new ArrayList<>();
        int lineIndex = 0;
        try {

            FileReader fr = new FileReader(name);
            BufferedReader bf = new BufferedReader(fr);
            String str;
            while ((str = bf.readLine()) != null) {
                lineIndex++;
                if(lineIndex>1){
                    arrayList.add(str);
                }
            }
            bf.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return arrayList;
    }


//    public static void main(String argv[]){
//        getAllLoanRecord("aa3bced053a54231b03509622a36feaf");
//    }

    public static Map getAllLoanRecord(String companyId){
        String fileName = "src/main/resources/loan.txt";
        List<String> resultList = TxtReader.txtReader(fileName);

        Map map = new HashMap();
        List<Loan> loanList = new ArrayList<>();
        List<Loan> payList = new ArrayList<>();

        map.put("loanList",loanList);
        map.put("payList", payList);

        return map;
    }





}
