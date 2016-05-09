package com.gotop.Generalprocess.model;

public class ProcessSubmitter {
	/*
	 * 流程Id
	 */
	private String flowId;
	
	/*
	 * 提交人
	 */
	private String submitter;
	/*
	 * 当前登入用户
	 */
	private String currenUser;
	
	public String getFlowId() {
		return flowId;
	}
	public void setFlowId(String flowId) {
		this.flowId = flowId;
	}
	
	public String getSubmitter() {
		return submitter;
	}
	public void setSubmitter(String submitter) {
		this.submitter = submitter;
	}
	public String getCurrenUser() {
		return currenUser;
	}
	public void setCurrenUser(String currenUser) {
		this.currenUser = currenUser;
	}
	

}
