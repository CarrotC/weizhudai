package org.seckill.entity;

import java.util.Date;

public class CompTax {
    private Integer tId;
    private String compId;
    private Date dt;
    private String type;
    private Double taxShouldPay;
    private Double taxPaid;
    private String status;

    public Integer gettId() {
        return tId;
    }

    public void settId(Integer tId) {
        this.tId = tId;
    }

    public String getCompId() {
        return compId;
    }

    public void setCompId(String compId) {
        this.compId = compId;
    }

    public Date getDt() {
        return dt;
    }

    public void setDt(Date dt) {
        this.dt = dt;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getTaxShouldPay() {
        return taxShouldPay;
    }

    public void setTaxShouldPay(Double taxShouldPay) {
        this.taxShouldPay = taxShouldPay;
    }

    public Double getTaxPaid() {
        return taxPaid;
    }

    public void setTaxPaid(Double taxPaid) {
        this.taxPaid = taxPaid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
