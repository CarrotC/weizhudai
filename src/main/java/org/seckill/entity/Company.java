package org.seckill.entity;

public class Company {

    private String userName;

    private String socialCredit;

    private String companyType;

    private String legalPersonName;

    private String legalPersonId;

    private Integer registeredCapital;

    private String operatingPeriod;

    private String bankAccount;

    private String companyName;

    private String companyId;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setSocialCredit(String socialCredit) {
        this.socialCredit = socialCredit;
    }

    public String getSocialCredit() {
        return socialCredit;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    public String getCompanyType() {
        return companyType;
    }

    public void setLegalPersonName(String legelPersonName) {
        this.legalPersonName = legalPersonName;
    }

    public String getLegalPersonName() {
        return legalPersonName;
    }

    public void setLegalPersonId(String legalPersonId) {
        this.legalPersonId = legalPersonId;
    }

    public String getLegalPersonId() {
        return this.legalPersonId;
    }

    public void setRegisteredCapital(Integer registeredCapital) {
        this.registeredCapital = registeredCapital;
    }

    public Integer getRegisteredCapital() {
        return  this.registeredCapital;
    }

    public void setOperatingPeriod(String operatingPeriod) {
        this.operatingPeriod = operatingPeriod;
    }

    public String getOperatingPeriod() {
        return this.operatingPeriod;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getBankAccount() {
        return this.bankAccount;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return this.companyName;
    }


    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }
}

