package org.seckill.entity;

public class Profitability {
    private Integer id;
    private Integer year;
    private Double saleCashRatio;
    private Double cashRecoveryRatio;

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

    public Double getSaleCashRatio() {
        return saleCashRatio;
    }

    public void setSaleCashRatio(Double saleCashRatio) {
        this.saleCashRatio = saleCashRatio;
    }

    public Double getCashRecoveryRatio() {
        return cashRecoveryRatio;
    }

    public void setCashRecoveryRatio(Double cashRecoveryRatio) {
        this.cashRecoveryRatio = cashRecoveryRatio;
    }
}
