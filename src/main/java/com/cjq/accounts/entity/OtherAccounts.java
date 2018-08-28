package com.cjq.accounts.entity;

import java.math.BigDecimal;

public class OtherAccounts {
    private Integer id;

    private Integer accountsId;

    private String other;

    private BigDecimal otherPrice;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAccountsId() {
        return accountsId;
    }

    public void setAccountsId(Integer accountsId) {
        this.accountsId = accountsId;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other == null ? null : other.trim();
    }

    public BigDecimal getOtherPrice() {
        return otherPrice;
    }

    public void setOtherPrice(BigDecimal otherPrice) {
        this.otherPrice = otherPrice;
    }
}