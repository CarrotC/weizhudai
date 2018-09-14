package org.seckill.entity;

public class ProfitabilityRatio {
    private Integer id;
    private Integer year;
    private Double netProfits;
    private Double salesRevenue;
    private Double salesCost;
    private Double initialTotalAssets;
    private Double finalTotalAssets;
    private Double initialOwnerEquity;
    private Double finalOwnerEquity;

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

    public Double getNetProfits() {
        return netProfits;
    }

    public void setNetProfits(Double netProfits) {
        this.netProfits = netProfits;
    }

    public Double getSalesRevenue() {
        return salesRevenue;
    }

    public void setSalesRevenue(Double salesRevenue) {
        this.salesRevenue = salesRevenue;
    }

    public Double getSalesCost() {
        return salesCost;
    }

    public void setSalesCost(Double salesCost) {
        this.salesCost = salesCost;
    }

    public Double getInitialTotalAssets() {
        return initialTotalAssets;
    }

    public void setInitialTotalAssets(Double initialTotalAssets) {
        this.initialTotalAssets = initialTotalAssets;
    }

    public Double getFinalTotalAssets() {
        return finalTotalAssets;
    }

    public void setFinalTotalAssets(Double finalTotalAssets) {
        this.finalTotalAssets = finalTotalAssets;
    }

    public Double getInitialOwnerEquity() {
        return initialOwnerEquity;
    }

    public void setInitialOwnerEquity(Double initialOwnerEquity) {
        this.initialOwnerEquity = initialOwnerEquity;
    }

    public Double getFinalOwnerEquity() {
        return finalOwnerEquity;
    }

    public void setFinalOwnerEquity(Double finalOwnerEquity) {
        this.finalOwnerEquity = finalOwnerEquity;
    }

    public Double getNetProfitRatioInSale() {//销售净利润
        Double netProfitRatioInSale = netProfits / salesRevenue;
        netProfitRatioInSale = Double.valueOf(Math.round(netProfitRatioInSale * 100) / 100);
        return netProfitRatioInSale;
    }

    public Double getGrossProfitRatioInSale() {//销售毛利润
        Double grossProfitRatioInSale = (salesRevenue - salesCost) / salesRevenue;
        grossProfitRatioInSale = Double.valueOf(Math.round(grossProfitRatioInSale * 100) / 100);
        return grossProfitRatioInSale;
    }

    public Double getNetProfitRatioInAsset() {//资产净利润(总资产报酬)
        Double temp = (initialTotalAssets + finalTotalAssets) / 2;
        temp = Double.valueOf(Math.round(temp * 100) / 100);
        Double netProfitRatioInAsset = netProfits / temp;
        return netProfitRatioInAsset;
    }

    public Double getNetAssetIncomeRatio() {//净资产收益率（权益报酬率）
        Double temp = (initialOwnerEquity + finalOwnerEquity) / 2;
        temp = Double.valueOf(Math.round(temp * 100) / 100);
        Double netAssetIncomeRatio = netProfits / temp;
        return netAssetIncomeRatio;
    }
}
