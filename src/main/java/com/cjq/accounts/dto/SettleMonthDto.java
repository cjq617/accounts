package com.cjq.accounts.dto;

public class SettleMonthDto {

	private String flag;
	
	private String month_date;
	
	private float food_sum;
	
	private float need_sum;
	
	private float before_sum;
	
	private float after_sum;
	
	private float wqx_to_cjq;

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getMonth_date() {
		return month_date;
	}

	public void setMonth_date(String month_date) {
		this.month_date = month_date;
	}

	public float getFood_sum() {
		return food_sum;
	}

	public void setFood_sum(float food_sum) {
		this.food_sum = food_sum;
	}

	public float getNeed_sum() {
		return need_sum;
	}

	public void setNeed_sum(float need_sum) {
		this.need_sum = need_sum;
	}

	public float getBefore_sum() {
		return before_sum;
	}

	public void setBefore_sum(float before_sum) {
		this.before_sum = before_sum;
	}

	public float getAfter_sum() {
		return after_sum;
	}

	public void setAfter_sum(float after_sum) {
		this.after_sum = after_sum;
	}

	public float getWqx_to_cjq() {
		return wqx_to_cjq;
	}

	public void setWqx_to_cjq(float wqx_to_cjq) {
		this.wqx_to_cjq = wqx_to_cjq;
	}
}
