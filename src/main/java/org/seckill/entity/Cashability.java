package org.seckill.entity;

public class Cashability {
    private String id;
    private Integer year;
    private Integer quarter;
    private Double currentAssets;
    private Double currentLiabilities;
    private Double inventory;

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

    public Double getCurrentAssets() {
        return currentAssets;
    }

    public void setCurrentAssets(Double currentAssets) {
        this.currentAssets = currentAssets;
    }

    public Double getCurrentLiabilities() {
        return currentLiabilities;
    }

    public void setCurrentLiabilities(Double currentLiabilities) {
        this.currentLiabilities = currentLiabilities;
    }

    public Double getInventory() {
        return inventory;
    }

    public void setInventory(Double inventory) {
        this.inventory = inventory;
    }

    public Double getCurrentRatio() {
        return this.currentAssets / this.currentLiabilities;
    }

    public Double getQuickRatio() {
        return (this.currentAssets - this.inventory) / this.currentLiabilities;
    }



    public Integer getQuarter() {
        return quarter;
    }

    public void setQuarter(Integer quarter) {
        this.quarter = quarter;
    }



}
