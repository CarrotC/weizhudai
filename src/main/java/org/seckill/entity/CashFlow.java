package org.seckill.entity;

import javax.xml.crypto.dom.DOMCryptoContext;

public class CashFlow {
    private Integer id;
    private Integer year;
    private Double netCashFlowFromOperating;
    private Double currentMaturitiesOfLongtermDebt;
    private Double notesPavable;
    private Double yearNetCashFlowFromOperating;
    private Double finalCurrentLiabilities;
    private Double finalTotalLiabilities;

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

    public Double getNetCashFlowFromOperating() {
        return netCashFlowFromOperating;
    }

    public void setNetCashFlowFromOperating(Double netCashFlowFromOperating) {
        this.netCashFlowFromOperating = netCashFlowFromOperating;
    }

    public Double getCurrentMaturitiesOfLongtermDebt() {
        return currentMaturitiesOfLongtermDebt;
    }

    public void setCurrentMaturitiesOfLongtermDebt(Double currentMaturitiesOfLongtermDebt) {
        this.currentMaturitiesOfLongtermDebt = currentMaturitiesOfLongtermDebt;
    }

    public Double getNotesPavable() {
        return notesPavable;
    }

    public void setNotesPavable(Double notesPavable) {
        this.notesPavable = notesPavable;
    }

    public Double getYearNetCashFlowFromOperating() {
        return yearNetCashFlowFromOperating;
    }

    public void setYearNetCashFlowFromOperating(Double yearNetCashFlowFromOperating) {
        this.yearNetCashFlowFromOperating = yearNetCashFlowFromOperating;
    }

    public Double getFinalCurrentLiabilities() {
        return finalCurrentLiabilities;
    }

    public void setFinalCurrentLiabilities(Double finalCurrentLiabilities) {
        this.finalCurrentLiabilities = finalCurrentLiabilities;
    }

    public Double getFinalTotalLiabilities() {
        return finalTotalLiabilities;
    }

    public void setFinalTotalLiabilities(Double finalTotalLiabilities) {
        this.finalTotalLiabilities = finalTotalLiabilities;
    }




    public Double getCashMaturityDebtRatio() {
        return this.netCashFlowFromOperating / (this.currentMaturitiesOfLongtermDebt + this.notesPavable);
    }

    public Double getCashFlowDebtRatio() {
        return this.yearNetCashFlowFromOperating / this.finalCurrentLiabilities;
    }

    public Double getTotalCashDebtRatio() {
        return this.netCashFlowFromOperating / this.finalTotalLiabilities;
    }

}
