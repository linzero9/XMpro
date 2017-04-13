package com.gotop.reportjbpm.model;

import java.io.Serializable;

public class TimeLimitConditionReport implements Serializable {
	private static final long serialVersionUID = 1L;
	private String orgNameOne;
	private String orgNameTwo;
	private String oneCategory;
	private String loanCategory;
	private String zdCustManager;
	private String zhgpdTime;
	private String reviewApprovalOneTime;
	private String reviewApprovalTwoTime;
	private String reviewApprovalThreeOrMoreTime;
	private String allProcessTimeOne;
	private String allProcessTimeTwo;
	private String zlwzhApprovalTime;
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
	public String getOneCategory() {
		return oneCategory;
	}
	public void setOneCategory(String oneCategory) {
		this.oneCategory = oneCategory;
	}
	public String getLoanCategory() {
		return loanCategory;
	}
	public void setLoanCategory(String loanCategory) {
		this.loanCategory = loanCategory;
	}
	public String getZdCustManager() {
		return zdCustManager;
	}
	public void setZdCustManager(String zdCustManager) {
		this.zdCustManager = zdCustManager;
	}
	public String getZhgpdTime() {
		return zhgpdTime;
	}
	public void setZhgpdTime(String zhgpdTime) {
		this.zhgpdTime = zhgpdTime;
	}
	public String getReviewApprovalOneTime() {
		return reviewApprovalOneTime;
	}
	public void setReviewApprovalOneTime(String reviewApprovalOneTime) {
		this.reviewApprovalOneTime = reviewApprovalOneTime;
	}
	public String getReviewApprovalTwoTime() {
		return reviewApprovalTwoTime;
	}
	public void setReviewApprovalTwoTime(String reviewApprovalTwoTime) {
		this.reviewApprovalTwoTime = reviewApprovalTwoTime;
	}
	public String getReviewApprovalThreeOrMoreTime() {
		return reviewApprovalThreeOrMoreTime;
	}
	public void setReviewApprovalThreeOrMoreTime(
			String reviewApprovalThreeOrMoreTime) {
		this.reviewApprovalThreeOrMoreTime = reviewApprovalThreeOrMoreTime;
	}
	public String getAllProcessTimeOne() {
		return allProcessTimeOne;
	}
	public void setAllProcessTimeOne(String allProcessTimeOne) {
		this.allProcessTimeOne = allProcessTimeOne;
	}
	public String getAllProcessTimeTwo() {
		return allProcessTimeTwo;
	}
	public void setAllProcessTimeTwo(String allProcessTimeTwo) {
		this.allProcessTimeTwo = allProcessTimeTwo;
	}
	public String getZlwzhApprovalTime() {
		return zlwzhApprovalTime;
	}
	public void setZlwzhApprovalTime(String zlwzhApprovalTime) {
		this.zlwzhApprovalTime = zlwzhApprovalTime;
	}
	
	
}
