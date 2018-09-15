package org.seckill.entity;


import java.math.BigDecimal;
import java.util.Date;

public class Loan {
    private String Lenders;  //借贷企业id
    private String bank;    //贷款银行
    private Date operateDate;   //操作时间
    private String operateType;   //操作类型，LOAN(0)-借款，REPAYMENT(1)-还款
    private BigDecimal amount;  //贷款金额
    private BigDecimal interestRate;   //贷款利率
    private Date repaymentPeriod;   //还款期限
    private String creditRating;    //信用评级
    private BigDecimal creditLine;  //授信额度
    private String guarantorCreditRating;   //担保人信用评级
    private BigDecimal hostagePrice;       //担保品价格
    private String status;//还款状态

    public Date getRepaymentPeriod() {
        return repaymentPeriod;
    }

    public void setRepaymentPeriod(Date repaymentPeriod) {
        this.repaymentPeriod = repaymentPeriod;
    }

    public String getCreditRating() {
        return creditRating;
    }

    public void setCreditRating(String creditRating) {
        this.creditRating = creditRating;
    }

    public BigDecimal getCreditLine() {
        return creditLine;
    }

    public void setCreditLine(BigDecimal creditLine) {
        this.creditLine = creditLine;
    }

    public String getGuarantorCreditRating() {
        return guarantorCreditRating;
    }

    public void setGuarantorCreditRating(String guarantorCreditRating) {
        this.guarantorCreditRating = guarantorCreditRating;
    }

    public BigDecimal getHostagePrice() {
        return hostagePrice;
    }

    public void setHostagePrice(BigDecimal hostagePrice) {
        this.hostagePrice = hostagePrice;
    }

    public Date getOperateDate() {
        return operateDate;
    }

    public void setOperateDate(Date operateDate) {
        this.operateDate = operateDate;
    }

    public String getOperateType() {
        return operateType;
    }

    public void setOperateType(String operateType) {
        this.operateType = operateType;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    public String getLenders() {
        return Lenders;
    }

    public void setLenders(String lenders) {
        Lenders = lenders;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "Lenders='" + Lenders + '\'' +
                ", bank='" + bank + '\'' +
                ", operateDate=" + operateDate +
                ", operateType=" + operateType +
                ", amount=" + amount +
                ", interestRate=" + interestRate +
                ", repaymentPeriod=" + repaymentPeriod +
                ", creditRating='" + creditRating + '\'' +
                ", creditLine=" + creditLine +
                ", guarantorCreditRating='" + guarantorCreditRating + '\'' +
                ", hostagePrice=" + hostagePrice +
                '}';
    }
}

