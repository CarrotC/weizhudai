package org.seckill.entity;

public class Cashability {
    private String id;
    private Integer year;
    private Integer quarter;
    private Double currentAsset;
    private Double currentLiabililties;
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


    public Double getCurrentAsset() {
        return currentAsset;
    }

    public void setCurrentAsset(Double currentAsset) {
        this.currentAsset = currentAsset;
    }

    public Double getCurrentLiabililties() {
        return currentLiabililties;
    }

    public void setCurrentLiabililties(Double currentLiabililties) {
        this.currentLiabililties = currentLiabililties;
    }

    public Double getInventory() {
        return inventory;
    }

    public void setInventory(Double inventory) {
        this.inventory = inventory;
    }

    public Double getCurrentRatio() {
        return this.currentAsset / this.currentLiabililties;
    }

    public Double getQuickRatio() {
        return (this.currentAsset - this.inventory) / this.currentLiabililties;
    }



    public Integer getQuarter() {
        return quarter;
    }

    public void setQuarter(Integer quarter) {
        this.quarter = quarter;
    }
}
