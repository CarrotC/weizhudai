package org.seckill.entity;

public class CompanyType {

    private String companyType;

    private String companyName;

    private Byte isRegister;

    public String companyId;

    public void setCompanyType(String companyType){
        this.companyType = companyType;
    }

    public String getCompanyType(){
        return this.companyType;
    }

    public void setCompanyName(String companyName){
        this.companyName = companyName;
    }

    public String getCompanyName(){
        return this.companyName;
    }

    public void setIsRegister(Byte isRegister){
        this.isRegister = isRegister;
    }

    public Byte getIsRegister(){
        return this.isRegister;
    }

    public void setCompanyId(String companyId){
        this.companyId = companyId;
    }

    public String getCompanyId(){
        return this.companyId;
    }



}
