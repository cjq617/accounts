package com.cjq.accounts.entity;

public class Settle {
    private Integer id;

    private String monthDate;

    private String flag;

    private Float foodSum;

    private Float beforeSum;

    private Float afterSum;

    private Float wqxToCjq;

    private Float needSum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMonthDate() {
        return monthDate;
    }

    public void setMonthDate(String monthDate) {
        this.monthDate = monthDate == null ? null : monthDate.trim();
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag == null ? null : flag.trim();
    }

    public Float getFoodSum() {
        return foodSum;
    }

    public void setFoodSum(Float foodSum) {
        this.foodSum = foodSum;
    }

    public Float getBeforeSum() {
        return beforeSum;
    }

    public void setBeforeSum(Float beforeSum) {
        this.beforeSum = beforeSum;
    }

    public Float getAfterSum() {
        return afterSum;
    }

    public void setAfterSum(Float afterSum) {
        this.afterSum = afterSum;
    }

    public Float getWqxToCjq() {
        return wqxToCjq;
    }

    public void setWqxToCjq(Float wqxToCjq) {
        this.wqxToCjq = wqxToCjq;
    }

    public Float getNeedSum() {
        return needSum;
    }

    public void setNeedSum(Float needSum) {
        this.needSum = needSum;
    }
}