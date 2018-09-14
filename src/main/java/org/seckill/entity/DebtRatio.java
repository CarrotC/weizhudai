package org.seckill.entity;

public class DebtRatio {
    private Integer id;
    private Integer year;
    private Double assetLiabilityRatio;
    private Double equityRatio;
    private Double tangibleDebtRatio;
    private Double interestEarnedRatio;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Double getAssetLiabilityRatio() {
        return assetLiabilityRatio;
    }

    public void setAssetLiabilityRatio(Double assetLiabilityRatio) {
        this.assetLiabilityRatio = assetLiabilityRatio;
    }

    public Double getEquityRatio() {
        return equityRatio;
    }

    public void setEquityRatio(Double equityRatio) {
        this.equityRatio = equityRatio;
    }

    public Double getTangibleDebtRatio() {
        return tangibleDebtRatio;
    }

    public void setTangibleDebtRatio(Double tangibleDebtRatio) {
        this.tangibleDebtRatio = tangibleDebtRatio;
    }

    public Double getInterestEarnedRatio() {
        return interestEarnedRatio;
    }

    public void setInterestEarnedRatio(Double interestEarnedRatio) {
        this.interestEarnedRatio = interestEarnedRatio;
    }
}
