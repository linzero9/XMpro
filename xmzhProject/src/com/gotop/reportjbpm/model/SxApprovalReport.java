package com.gotop.reportjbpm.model;

import java.io.Serializable;

public class SxApprovalReport implements Serializable {
	private static final long serialVersionUID = 1L;
	private String orgNameOne;
	private String orgNameTwo;
	private String oneCategory;
	private String oneCategoryNum;
	private String oneCategoryMoney;
	public String getOrgNameOne() {
		return orgNameOne;
	}
	public void setOrgNameOne(String orgNameOne) {
		this.orgNameOne = orgNameOne;
	}
	public String getOrgNameTwo() {
		return orgNameTwo;
	}
	public void setOrgNameTwo(String orgNameTwo) {
		this.orgNameTwo = orgNameTwo;
	}
	public String getOneCategoryNum() {
		return oneCategoryNum;
	}
	public void setOneCategoryNum(String oneCategoryNum) {
		this.oneCategoryNum = oneCategoryNum;
	}
	public String getOneCategoryMoney() {
		return oneCategoryMoney;
	}
	public void setOneCategoryMoney(String oneCategoryMoney) {
		this.oneCategoryMoney = oneCategoryMoney;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getOneCategory() {
		return oneCategory;
	}
	public void setOneCategory(String oneCategory) {
		this.oneCategory = oneCategory;
	}
}
