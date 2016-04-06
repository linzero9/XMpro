package com.gotop.jbpm.model;

import java.io.Serializable;

public class XdCdtypeBean implements Serializable {

	private Long cdtypeid;
	
	private String processName;
	
	private String oneCategory;
	
	private String loanCategory;
	
	private String limit_time;
	
	private String oneCategoryId;
	

	public String getOneCategoryId() {
		return oneCategoryId;
	}

	public void setOneCategoryId(String oneCategoryId) {
		this.oneCategoryId = oneCategoryId;
	}

	public Long getCdtypeid() {
		return cdtypeid;
	}

	public void setCdtypeid(Long cdtypeid) {
		this.cdtypeid = cdtypeid;
	}

	public String getProcessName() {
		return processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
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

	public String getLimit_time() {
		return limit_time;
	}

	public void setLimit_time(String limit_time) {
		this.limit_time = limit_time;
	}
	
	
}
