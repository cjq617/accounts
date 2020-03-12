package com.cjq.accounts.dto;

import java.math.BigDecimal;

public class SettleDto {

	private String months;

	private String flag;

	private BigDecimal totalFood;

	private BigDecimal supermarket;

	private BigDecimal total;

	public String getMonths() {
		return months;
	}

	public void setMonths(String months) {
		this.months = months;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public BigDecimal getTotalFood() {
		return totalFood;
	}

	public void setTotalFood(BigDecimal totalFood) {
		this.totalFood = totalFood;
	}

	public BigDecimal getSupermarket() {
		return supermarket;
	}

	public void setSupermarket(BigDecimal supermarket) {
		this.supermarket = supermarket;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}
}
