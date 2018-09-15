package org.seckill.entity;

public class Profitability {
    private String id;
    private Integer year;
    private Integer quarter;
    private Double netCashFlowFromOperating;
    private Double sales;
    private Double finalTotalAssets;
//    private Double saleCashRatio;
//    private Double cashRecoveryRatio;

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

    public Double getNetCashFlowFromOperating() {
        return netCashFlowFromOperating;
    }

    public void setNetCashFlowFromOperating(Double netCashFlowFromOperating) {
        this.netCashFlowFromOperating = netCashFlowFromOperating;
    }

    public Double getSales() {
        return sales;
    }

    public void setSales(Double sales) {
        this.sales = sales;
    }

    public Double getFinalTotalAssets() {
        return finalTotalAssets;
    }

    public void setFinalTotalAssets(Double finalTotalAssets) {
        this.finalTotalAssets = finalTotalAssets;
    }

    public Double getSaleCashRatio() {
        Double saleCashRatio = netCashFlowFromOperating / sales;
        return saleCashRatio;
    }

    public Double getCashRecoveryRatio() {
        Double cashRecoveryRatio = netCashFlowFromOperating / finalTotalAssets;
        return cashRecoveryRatio;
    }


    public Integer getQuarter() {
        return quarter;
    }

    public void setQuarter(Integer quarter) {
        this.quarter = quarter;
    }
}
