package com.gotop.timeMachine.model;

import java.io.Serializable;

public class OverTimeReport  implements Serializable{

	private Long id; //主键
	
	private String reportTime ;//报单时间
	
	private String taskName;//超限环节的任务名称
	
	private String custName;//客户名称
	
	private String loanCategory_name;//贷种分类 名称
	
	private String orgname;//机构名
	
	private String empname;//超限人员
	
	private Double overtime;//超限时长（单位：小时）
	
	private String remark;//备注
	
	private Long request_id ; //请求标识， 用于识别 每次的action请求
	
	private String process_name; //流程名称
	
	private String reportStarttime; //报单开始时间（只用于JSP页面的查询项）
	private String reportEndtime; //报单结束时间（只用于JSP页面的查询项）
	
	

	public String getReportStarttime() {
		return reportStarttime;
	}

	public void setReportStarttime(String reportStarttime) {
		this.reportStarttime = reportStarttime;
	}

	public String getReportEndtime() {
		return reportEndtime;
	}

	public void setReportEndtime(String reportEndtime) {
		this.reportEndtime = reportEndtime;
	}

	public String getReportTime() {
		return reportTime;
	}

	public void setReportTime(String reportTime) {
		this.reportTime = reportTime;
	}

	

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	

	public String getLoanCategory_name() {
		return loanCategory_name;
	}

	public void setLoanCategory_name(String loanCategory_name) {
		this.loanCategory_name = loanCategory_name;
	}

	public String getOrgname() {
		return orgname;
	}

	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public Double getOvertime() {
		return overtime;
	}

	public void setOvertime(Double overtime) {
		this.overtime = overtime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRequest_id() {
		return request_id;
	}

	public void setRequest_id(Long request_id) {
		this.request_id = request_id;
	}

	public String getProcess_name() {
		return process_name;
	}

	public void setProcess_name(String process_name) {
		this.process_name = process_name;
	}

	

	
}
