package com.gotop.reportjbpm.model;

import java.io.Serializable;


public class ReportRefusalrate implements Serializable{
	
	private String stratdate;
	private String enddate;
	private String oneCategory;
	private String  oneCategoryTxt;
	private String loanCategory;
	private String   loanCategoryTxt;
	private String orgname;
	private String orgnametwo;
	private String EA_number;
	private String rejection_number;
	private String refusalrate;
	
	//上报合计
	private String upnum;
	//拒贷笔数
	private String downnum;
	//拒贷率合计
	private String dowup;
	
	

	public String getDowup() {
		return dowup;
	}
	public void setDowup(String dowup) {
		this.dowup = dowup;
	}
	public String getUpnum() {
		return upnum;
	}
	public void setUpnum(String upnum) {
		this.upnum = upnum;
	}
	public String getDownnum() {
		return downnum;
	}
	public void setDownnum(String downnum) {
		this.downnum = downnum;
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
	public void setLoanCategoryId(String loanCategory) {
		this.loanCategory = loanCategory;
	}
	
	public String getEA_number() {
		return EA_number;
	}
	public void setEA_number(String EA_number) {
		this.EA_number = EA_number;
	}
	public String getRejection_number() {
		return rejection_number;
	}
	public void setRejection_number(String rejection_number) {
		this.rejection_number = rejection_number;
	}
	public String getRefusalrate() {
		return refusalrate;
	}
	public void setRefusalrate(String refusalrate) {
		this.refusalrate = refusalrate;
	}
	public String getOneCategoryTxt() {
		return oneCategoryTxt;
	}
	public void setOneCategoryTxt(String oneCategoryTxt) {
		this.oneCategoryTxt = oneCategoryTxt;
	}
	public String getLoanCategoryTxt() {
		return loanCategoryTxt;
	}
	public void setLoanCategoryTxt(String loanCategoryTxt) {
		this.loanCategoryTxt = loanCategoryTxt;
	}
	public String getOrgname() {
		return orgname;
	}
	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}
	public String getOrgnametwo() {
		return orgnametwo;
	}
	public void setOrgnametwo(String orgnametwo) {
		this.orgnametwo = orgnametwo;
	}
	public String getStratdate() {
		return stratdate;
	}
	public void setStratdate(String stratdate) {
		this.stratdate = stratdate;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	
	
	

}
