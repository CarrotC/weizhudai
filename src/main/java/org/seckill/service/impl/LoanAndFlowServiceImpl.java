package org.seckill.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.seckill.dao.CompanyTypeMapper;
import org.seckill.entity.Flow;
import org.seckill.entity.Loan;
import org.seckill.service.LoanAndFlowService;
import org.seckill.util.TxtReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class LoanAndFlowServiceImpl implements LoanAndFlowService {

    @Autowired
    private CompanyTypeMapper companyTypeMapper;

    /**
     * 获取某公司所有交易记录
     * @return
     */
    @Override
    public List<Flow> getAllTransactionRecord(String realPath, String companyId) {
        String fileName = realPath + "statics/txt/flow.txt";
        List<String> resultList = TxtReader.txtReader(fileName);

        List<Flow> transactionList = new ArrayList<>();

        try{
            for(int i = 0; i < resultList.size(); i++) {
                JSONObject result = JSON.parseObject(resultList.get(i));
                JSONObject flowSingleRecord = result.getJSONObject("data");
                String id = flowSingleRecord.getString("firmId");
                if (companyId.equals(id)) {
                    Flow flow = new Flow();
                    flow.setFlowNo(flowSingleRecord.getString("flowNo"));
                    //****flow.setFirmId(flowSingleRecord.getString("firmId"));
                    String companyName = this.companyTypeMapper.getCompanyById(flowSingleRecord.getString("firmId")).getCompanyName();
                    flow.setFirmId(companyName);

                    //flow.setOperateTime(flowSingleRecord.getDate("operateTime"));
                    //****flow.setTransactionPart(flowSingleRecord.getString("TransactionPart"));
                    String transactionPartName = this.companyTypeMapper.getCompanyById(flowSingleRecord.getString("TransactionPart")).getCompanyName();
                    flow.setTransactionPart(transactionPartName);

                    if(flowSingleRecord.getString("operateType").equals("LOAN")){
                        flow.setOperateType("转出");
                    } else {
                        flow.setOperateType("转入");
                    }
                    flow.setAmount(flowSingleRecord.getBigDecimal("amount"));
                    flow.setAmountCapital(flowSingleRecord.getString("amountCapital"));
                    //****flow.setBank(flowSingleRecord.getString("bank"));
                    String bankName = this.companyTypeMapper.getCompanyById(flowSingleRecord.getString("bank")).getCompanyName();
                    flow.setBank(bankName);

                    flow.setUse(flowSingleRecord.getString("use"));
                    flow.setRemarks(flowSingleRecord.getString("remarks"));

                    transactionList.add(flow);

                }
            }
        } catch (Exception e){
            System.out.println("读取企业流水信息失败");
        }


        return transactionList;
    }

    /**
     * 获取某公司所有的借贷记录
     * @return
     */
    @Override
    public Map getAllLoanRecord(String realPath, String companyId){
        String fileName = realPath + "statics/txt/loan.txt";
        List<String> resultList = TxtReader.txtReader(fileName);

        Map map = new HashMap();
        List<Loan> loanList = new ArrayList<>();
        List<Loan> payList = new ArrayList<>();

        try{
            for(int i = 0; i < resultList.size(); i++){
                JSONObject result = JSON.parseObject(resultList.get(i));
                JSONObject loanSingleRecord = result.getJSONObject("data");
                String id = loanSingleRecord.getString("Lenders");
                String operateType = loanSingleRecord.getString("operateType");

                if(companyId.equals(id)){
                    Loan loan = new Loan();
                    //公司名
                    String companyName = this.companyTypeMapper.getCompanyById(id).getCompanyName();
                    loan.setLenders(companyName);
                    //银行名
                    String bankName = this.companyTypeMapper.getCompanyById(loanSingleRecord.getString("bank")).getCompanyName();
                    loan.setBank(bankName);
                    //贷款/还款日期
                    String dateString = loanSingleRecord.getString("operateDate");
                    DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                    Date date = format.parse(dateString);
                    loan.setOperateDate(date);

                    loan.setOperateType(operateType);
                    loan.setAmount(loanSingleRecord.getBigDecimal("amount"));
                    loan.setInterestRate(loanSingleRecord.getBigDecimal("interestRate"));

                    loan.setCreditRating(loanSingleRecord.getString("creditRating"));
                    loan.setCreditLine(loanSingleRecord.getBigDecimal("creditLine"));
                    loan.setGuarantorCreditRating(loanSingleRecord.getString("guarantorCreditRating"));
                    loan.setHostagePrice(loanSingleRecord.getBigDecimal("hostagePrice"));

                    if(operateType.equals("LOAN")){
                        //还款期限
                        loan.setRepaymentPeriod(loanSingleRecord.getDate("repaymentPeriod"));
                        loanList.add(loan);
                    } else if(companyId.equals(id)&&operateType.equals("REPAYMENT")){
                        payList.add(loan);
                    }
                }
            }
        }catch(Exception e){
            System.out.println("读取企业流水信息失败");
        }

        map.put("loanList",loanList);
        map.put("payList", payList);

        return map;
    }
}

