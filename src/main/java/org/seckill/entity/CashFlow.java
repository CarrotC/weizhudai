package org.seckill.entity;

import javax.xml.crypto.dom.DOMCryptoContext;

public class CashFlow {
    private Integer id;
    private Integer year;
    private Double netCashFlowFromOperating;
    private Double currentMaturitiesOfLongTermDebt;
    private Double notesPavable;
    private Double netCashFlowFromOperatingByYear;
    private Double finalCurrentLiabilities;
    private Double finalTotalLiabilities;
//    private Double cashMaturityDebtRatio;
//    private Double cashFlowDebtRatio;
//    private Double totalCashDebtRatio;

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

    public Double getCurrentMaturitiesOfLongTermDebt() {
        return currentMaturitiesOfLongTermDebt;
    }

    public void setCurrentMaturitiesOfLongTermDebt(Double currentMaturitiesOfLongTermDebt) {
        this.currentMaturitiesOfLongTermDebt = currentMaturitiesOfLongTermDebt;
    }

    public Double getNotesPavable() {
        return notesPavable;
    }

    public void setNotesPavable(Double notesPavable) {
        this.notesPavable = notesPavable;
    }

    public Double getNetCashFlowFromOperatingByYear() {
        return netCashFlowFromOperatingByYear;
    }

    public void setNetCashFlowFromOperatingByYear(Double netCashFlowFromOperatingByYear) {
        this.netCashFlowFromOperatingByYear = netCashFlowFromOperatingByYear;
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


//    public Double getCashMaturityDebtRatio() {
//        return this.netCashFlowFromOperation;
//    }
//
//    public Double getCashFlowDebtRatio() {
//        return cashFlowDebtRatio;
//    }
//
//    public Double getTotalCashDebtRatio() {
//        return totalCashDebtRatio;
//    }

}
