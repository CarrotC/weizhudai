package org.seckill.entity;

public class User {

    private String id;

    private String userName;

    private String password;

    private Byte isBank;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setIsBank(Byte isBank) {
        this.isBank = isBank;
    }

    public Byte getIsBank() {
        return isBank;
    }
}
