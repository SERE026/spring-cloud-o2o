package com.merchant.model;

/**
 * 商户账户表
 * @author luoqw
 * 2016-9-5下午3:39:18
 */
public class MerchantsAccount {
    private Integer id;

    private String account;

    private String password;

    private String useStatus;

    private Integer allowCount;

    private String passKeyword;

    private String accountType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getUseStatus() {
        return useStatus;
    }

    public void setUseStatus(String useStatus) {
        this.useStatus = useStatus == null ? null : useStatus.trim();
    }

    public Integer getAllowCount() {
        return allowCount;
    }

    public void setAllowCount(Integer allowCount) {
        this.allowCount = allowCount;
    }

    public String getPassKeyword() {
        return passKeyword;
    }

    public void setPassKeyword(String passKeyword) {
        this.passKeyword = passKeyword == null ? null : passKeyword.trim();
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType == null ? null : accountType.trim();
    }
}