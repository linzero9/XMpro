package com.gotop.reportjbpm.model;

import java.io.Serializable;


public class ReportRefusalrate implements Serializable{
	
	private String reporttimeStrat;
	private String reporttimeEnd;
	private String oneCategory;
	private String  oneCategoryTxt;
	private String loanCategory;
	private String   loanCategoryTxt;

	private String orgcodeone;
	private String orgcodetwo;
	private String EA_number;
	private String rejection_number;
	private String refusalrate;
	
	
	public String getReportTimeStrat() {
		return reporttimeStrat;
	}
	public void setReportTimeStrat(String reporttimeStrat) {
		this.reporttimeStrat = reporttimeStrat;
	}
	public String getReportTimeEnd() {
		return reporttimeEnd;
	}
	public void setReportTimeEnd(String reporttimeEnd) {
		this.reporttimeEnd = reporttimeEnd;
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
	
	public String EA_number() {
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
	public String getOrgcodeone() {
		return orgcodeone;
	}
	public void setOrgcodeone(String orgcodeone) {
		this.orgcodeone = orgcodeone;
	}
	public String getOrgcodetwo() {
		return orgcodetwo;
	}
	public void setOrgcodetwo(String orgcodetwo) {
		this.orgcodetwo = orgcodetwo;
	}
	
	
	
	
	
	

}
