package com.gotop.jbpm.model;

import java.io.Serializable;

public class XdProcessBean implements Serializable {

	private Long id;
	
	private String definitionId; //流程定义ID
	
	private String processName;  //流程名称
	
	private String businessType;  //业务类型
	
	private String state;  //状态
	
	private String uploadTime; //提交时间
	
	/*
     * 一级分类
     */
    private String oneCategory;
    
    /*
     *贷种分类 
     */
    private String loanCategory;

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDefinitionId() {
		return definitionId;
	}

	public void setDefinitionId(String definitionId) {
		this.definitionId = definitionId;
	}

	public String getProcessName() {
		return processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}

	public String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getUploadTime() {
		return uploadTime;
	}

	public void setUploadTime(String uploadTime) {
		this.uploadTime = uploadTime;
	}
	
	
}
