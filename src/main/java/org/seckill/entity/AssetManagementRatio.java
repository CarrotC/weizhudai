package org.seckill.entity;

public class AssetManagementRatio {
    private String id;
    private Integer year;
    private Integer quarter;
    private Double sellingCost;
    private Double initialInventory;
    private Double finalInventory;
    private Double salesRevenue;
    private Double initialReceivables;
    private Double finalReceivables;
    private Double initialTotalAssets;
    private Double finalTotalAssets;
    private Double initialCurrentAssets;
    private Double finalCurrentAssets;
//    private Double inventoryTurnover;
//    private Double inventoryTurnoverInDays;
//    private Double accountReceivableTurnover;
//    private Double accountReceivableTurnoverInDays;
//    private Double operatingCycle;
//    private Double currentAssetTurnover;
//    private Double totalAssetTurnover;

    public String getId() {
        return id;
    }

    public void setId(String  id) {
        this.id = id;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Double getSellingCost() {
        return sellingCost;
    }

    public void setSellingCost(Double sellingCost) {
        this.sellingCost = sellingCost;
    }

    public Double getInitialInventory() {
        return initialInventory;
    }

    public void setInitialInventory(Double initialInventory) {
        this.initialInventory = initialInventory;
    }

    public Double getFinalInventory() {
        return finalInventory;
    }

    public void setFinalInventory(Double finalInventory) {
        this.finalInventory = finalInventory;
    }

    public Double getSalesRevenue() {
        return salesRevenue;
    }

    public void setSalesRevenue(Double salesRevenue) {
        this.salesRevenue = salesRevenue;
    }

    public Double getInitialReceivables() {
        return initialReceivables;
    }

    public void setInitialReceivables(Double initialReceivables) {
        this.initialReceivables = initialReceivables;
    }

    public Double getFinalReceivables() {
        return finalReceivables;
    }

    public void setFinalReceivables(Double finalReceivables) {
        this.finalReceivables = finalReceivables;
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

    public Double getInitialCurrentAssets() {
        return initialCurrentAssets;
    }

    public void setInitialCurrentAssets(Double initialCurrentAssets) {
        this.initialCurrentAssets = initialCurrentAssets;
    }

    public Double getFinalCurrentAssets() {
        return finalCurrentAssets;
    }

    public void setFinalCurrentAssets(Double finalCurrentAssets) {
        this.finalCurrentAssets = finalCurrentAssets;
    }



    public Double getInventoryTurnover() {//存货周期率
        double t = sellingCost / ((initialInventory + finalInventory) / 2);
        t = (double)Math.round(t * 10000) / 10000;
        return t;
    }

    public Double getInventoryTurnoverInDays() {//存货周转天数
        double t = 360 / getInventoryTurnover();
        t = (double)Math.round(t * 10000) / 10000;
        return t;
    }

    public Double getAccountReceivableTurnover() {//应收账款周转率
        double t = salesRevenue / ((initialReceivables + finalReceivables) / 2);
        t = (double)Math.round(t * 10000) / 10000;
        return t;
    }

    public Double getAccountReceivableTurnoverInDays() {//应收账款周转天数
        double t =  360 / getAccountReceivableTurnover();
        t = (double)Math.round(t * 10000) / 10000;
        return t;
    }

    public Double getOperatingCycle() {//营业周期
        double t= getInventoryTurnoverInDays() + getAccountReceivableTurnoverInDays();
        t = (double)Math.round(t * 10000) / 10000;
        return t;
    }

    public Double getCurrentAssetTurnover() {//流动资产周转率
        double t = salesRevenue / ((initialCurrentAssets + finalCurrentAssets) / 2);
        t = (double)Math.round(t * 10000) / 10000;
        return t;
    }

    public Double getTotalAssetTurnover() {//总资产周转率
        double t= salesRevenue / ((initialTotalAssets + finalTotalAssets) / 2);
        t = (double)Math.round(t * 10000) / 10000;
        return t;
    }



    public Integer getQuarter() {
        return quarter;
    }

    public void setQuarter(Integer quarter) {
        this.quarter = quarter;
    }
}
