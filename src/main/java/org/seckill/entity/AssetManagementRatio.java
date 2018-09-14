package org.seckill.entity;

public class AssetManagementRatio {
    private Integer id;
    private Integer year;
    private Double inventoryTurnover;
    private Double inventoryTurnoverInDays;
    private Double accountReceivableTurnover;
    private Double accountReceivableTurnoverInDays;
    private Double operatingCycle;
    private Double currentAssetTurnover;
    private Double totalAssetTurnover;

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

    public Double getInventoryTurnover() {
        return inventoryTurnover;
    }

    public void setInventoryTurnover(Double inventoryTurnover) {
        this.inventoryTurnover = inventoryTurnover;
    }

    public Double getInventoryTurnoverInDays() {
        return inventoryTurnoverInDays;
    }

    public void setInventoryTurnoverInDays(Double inventoryTurnoverInDays) {
        this.inventoryTurnoverInDays = inventoryTurnoverInDays;
    }

    public Double getAccountReceivableTurnover() {
        return accountReceivableTurnover;
    }

    public void setAccountReceivableTurnover(Double accountReceivableTurnover) {
        this.accountReceivableTurnover = accountReceivableTurnover;
    }

    public Double getAccountReceivableTurnoverInDays() {
        return accountReceivableTurnoverInDays;
    }

    public void setAccountReceivableTurnoverInDays(Double accountReceivableTurnoverInDays) {
        this.accountReceivableTurnoverInDays = accountReceivableTurnoverInDays;
    }

    public Double getOperatingCycle() {
        return operatingCycle;
    }

    public void setOperatingCycle(Double operatingCycle) {
        this.operatingCycle = operatingCycle;
    }

    public Double getCurrentAssetTurnover() {
        return currentAssetTurnover;
    }

    public void setCurrentAssetTurnover(Double currentAssetTurnover) {
        this.currentAssetTurnover = currentAssetTurnover;
    }

    public Double getTotalAssetTurnover() {
        return totalAssetTurnover;
    }

    public void setTotalAssetTurnover(Double totalAssetTurnover) {
        this.totalAssetTurnover = totalAssetTurnover;
    }
}
