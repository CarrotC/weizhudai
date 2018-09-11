package org.seckill.entity;

public class Company {

    private String userName;

    private String socialCredit;

    private String companyType;

    private String legelPersonName;

    private String legelPersonId;

    private Integer registeredCapital;

    private String operatingPeriod;

    private String bankAccount;

    private String companyName;

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

    public void setLegelPersonName(String legelPersonName) {
        this.legelPersonName = legelPersonName;
    }

    public String getLegelPersonName() {
        return legelPersonName;
    }

    public void setLegelPersonId(String legelPersonId) {
        this.legelPersonId = legelPersonId;
    }

    public String getLegelPersonId() {
        return this.legelPersonId;
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


}

