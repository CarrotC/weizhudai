package org.seckill.entity;

public class DebtRatio {
    private String id;
    private Integer year;
    private Integer quarter;
    private Double totalLiabilities;
    private Double totalAssets;
    private Double shareholdersEquity;
    private Double netIntangibleAssets;
    private Double totalProfits;
    private Double financialExpenses;
    private Double interests;
    private Double capitalizedInterest;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Double getTotalLiabilities() {
        return totalLiabilities;
    }

    public void setTotalLiabilities(Double totalLiabilities) {
        this.totalLiabilities = totalLiabilities;
    }

    public Double getTotalAssets() {
        return totalAssets;
    }

    public void setTotalAssets(Double totalAssets) {
        this.totalAssets = totalAssets;
    }

    public Double getShareholdersEquity() {
        return shareholdersEquity;
    }

    public void setShareholdersEquity(Double shareholdersEquity) {
        this.shareholdersEquity = shareholdersEquity;
    }

    public Double getNetIntangibleAssets() {
        return netIntangibleAssets;
    }

    public void setNetIntangibleAssets(Double netIntangibleAssets) {
        this.netIntangibleAssets = netIntangibleAssets;
    }

    public Double getTotalProfits() {
        return totalProfits;
    }

    public void setTotalProfits(Double totalProfits) {
        this.totalProfits = totalProfits;
    }

    public Double getFinancialExpenses() {
        return financialExpenses;
    }

    public void setFinancialExpenses(Double financialExpenses) {
        this.financialExpenses = financialExpenses;
    }

    public Double getInterests() {
        return interests;
    }

    public void setInterests(Double interests) {
        this.interests = interests;
    }

    public Double getCapitalizedInterest() {
        return capitalizedInterest;
    }

    public void setCapitalizedInterest(Double capitalizedInterest) {
        this.capitalizedInterest = capitalizedInterest;
    }

    public Double getAssetLiabilityRatio() {
        double assetLiabilityRatio = totalLiabilities / totalAssets;
        //四舍五入保留两位小数
        assetLiabilityRatio = (double)Math.round(assetLiabilityRatio * 10000) / 10000;
        return assetLiabilityRatio;
    }

    public Double getEquityRatio() {
        double equityRatio = totalLiabilities / shareholdersEquity;
        equityRatio =(double)Math.round(equityRatio * 10000) / 10000;
        return equityRatio;
    }

    public Double getTangibleDebtRatio() {
        Double tangibleDebtRatio = totalLiabilities / (shareholdersEquity - netIntangibleAssets);
        tangibleDebtRatio =(double)Math.round(tangibleDebtRatio * 10000) / 10000;
        return tangibleDebtRatio;
    }

    public Double getInterestEarnedRatio() {
        double interestEarnedRatio = (totalProfits + financialExpenses) / (interests + capitalizedInterest);
        interestEarnedRatio = (double)Math.round(interestEarnedRatio * 10000)/10000;
        return interestEarnedRatio;
    }

    public Integer getQuarter() {
        return quarter;
    }

    public void setQuarter(Integer quarter) {
        this.quarter = quarter;
    }
}
