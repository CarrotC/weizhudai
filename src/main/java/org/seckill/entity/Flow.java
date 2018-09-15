package org.seckill.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Flow {
    private String flowNo;              //交易编码
    private String firmId;              //企业id
    private Date operateTime;           //操作时间
    private String TransactionPart;     //交易方
    private String operateType;    //交易类型,LOAN-取钱，REPAYMENT-存钱
    private BigDecimal amount;         //交易金额
    private String AmountCapital;       //金额大写
    private String bank;                //受理银行
    private String use;                 //用途
    private String remarks;             //备注

    public String getFirmId() {
        return firmId;
    }

    public void setFirmId(String firmId) {
        this.firmId = firmId;
    }

    public Date getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    public String getTransactionPart() {
        return TransactionPart;
    }

    public void setTransactionPart(String transactionPart) {
        TransactionPart = transactionPart;
    }

    public String getOperateType() {
        return operateType;
    }

    public void setOperateType(String operateType) {
        this.operateType = operateType;
    }

    public String getAmountCapital() {
        return AmountCapital;
    }

    public void setAmountCapital(String amountCapital) {
        AmountCapital = amountCapital;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getUse() {
        return use;
    }

    public void setUse(String use) {
        this.use = use;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getFlowNo() {
        return flowNo;
    }

    public void setFlowNo(String flowNo) {
        this.flowNo = flowNo;
    }

    @Override
    public String toString() {
        return "Flow{" +
                "flowNo='" + flowNo + '\'' +
                ", firmId='" + firmId + '\'' +
                ", operateTime=" + operateTime +
                ", TransactionPart='" + TransactionPart + '\'' +
                ", operateType=" + operateType +
                ", amount=" + amount +
                ", AmountCapital='" + AmountCapital + '\'' +
                ", bank='" + bank + '\'' +
                ", use='" + use + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}

