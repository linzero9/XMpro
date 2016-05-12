package com.gotop.Generalprocess.model;

public class ProcessMistake {
	
	private String mistakeId;
	private String flowId;
	private String money;
	private String mistakeContent;
	private String rectification;
	
	
	public String getFlowId() {
		return flowId;
	}
	public void setFlowId(String flowId) {
		this.flowId = flowId;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public String getMistakeContent() {
		return mistakeContent;
	}
	public void setMistakeContent(String mistakeContent) {
		this.mistakeContent = mistakeContent;
	}
	public String getRectification() {
		return rectification;
	}
	public void setRectification(String rectification) {
		this.rectification = rectification;
	}
	public String getMistakeId() {
		return mistakeId;
	}
	public void setMistakeId(String mistakeId) {
		this.mistakeId = mistakeId;
	}
	

	
}
