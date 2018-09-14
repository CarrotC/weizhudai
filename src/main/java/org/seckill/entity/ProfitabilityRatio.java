package org.seckill.entity;

public class ProfitabilityRatio {
    private Integer id;
    private Integer year;
    private Double netProfitRatioInSale;
    private Double grossProfitRatioInSale;
    private Double netProfitRatioInAsset;
    private Double netAssetIncomeRatio;

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

    public Double getNetProfitRatioInSale() {
        return netProfitRatioInSale;
    }

    public void setNetProfitRatioInSale(Double netProfitRatioInSale) {
        this.netProfitRatioInSale = netProfitRatioInSale;
    }

    public Double getGrossProfitRatioInSale() {
        return grossProfitRatioInSale;
    }

    public void setGrossProfitRatioInSale(Double grossProfitRatioInSale) {
        this.grossProfitRatioInSale = grossProfitRatioInSale;
    }

    public Double getNetProfitRatioInAsset() {
        return netProfitRatioInAsset;
    }

    public void setNetProfitRatioInAsset(Double netProfitRatioInAsset) {
        this.netProfitRatioInAsset = netProfitRatioInAsset;
    }

    public Double getNetAssetIncomeRatio() {
        return netAssetIncomeRatio;
    }

    public void setNetAssetIncomeRatio(Double netAssetIncomeRatio) {
        this.netAssetIncomeRatio = netAssetIncomeRatio;
    }
}
