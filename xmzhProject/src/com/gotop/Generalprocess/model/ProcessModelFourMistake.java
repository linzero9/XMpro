package com.gotop.Generalprocess.model;

public class ProcessModelFourMistake {

	private long mistakeId;
	
	private String flowId;
	
	private String mistakeContent;
	
	private String punishBal;
	
	private String empid;
	
	private String taskName;
	
	private String processModelIdFour;

	private String addTime;
	/*
	 * 整改情况 
	 */
	private String rectification;
	
	public String getRectification() {
		return rectification;
	}

	public void setRectification(String rectification) {
		this.rectification = rectification;
	}

	public String getAddTime() {
		return addTime;
	}

	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}

	public long getMistakeId() {
		return mistakeId;
	}

	public void setMistakeId(long mistakeId) {
		this.mistakeId = mistakeId;
	}

	public String getFlowId() {
		return flowId;
	}

	public void setFlowId(String flowId) {
		this.flowId = flowId;
	}

	public String getMistakeContent() {
		return mistakeContent;
	}

	public void setMistakeContent(String mistakeContent) {
		this.mistakeContent = mistakeContent;
	}

	public String getPunishBal() {
		return punishBal;
	}

	public void setPunishBal(String punishBal) {
		this.punishBal = punishBal;
	}

	public String getEmpid() {
		return empid;
	}

	public void setEmpid(String empid) {
		this.empid = empid;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getProcessModelIdFour() {
		return processModelIdFour;
	}

	public void setProcessModelIdFour(String processModelIdFour) {
		this.processModelIdFour = processModelIdFour;
	}
	
}
