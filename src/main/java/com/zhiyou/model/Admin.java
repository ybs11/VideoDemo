package com.zhiyou.model;

public class Admin {
    private Integer adminId;

    private String accounts;

    private String password;

    private String adminRemark;

    private Integer adminIsSuper;

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAccounts() {
        return accounts;
    }

    public void setAccounts(String accounts) {
        this.accounts = accounts == null ? null : accounts.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getAdminRemark() {
        return adminRemark;
    }

    public void setAdminRemark(String adminRemark) {
        this.adminRemark = adminRemark == null ? null : adminRemark.trim();
    }

    public Integer getAdminIsSuper() {
        return adminIsSuper;
    }

    public void setAdminIsSuper(Integer adminIsSuper) {
        this.adminIsSuper = adminIsSuper;
    }
}