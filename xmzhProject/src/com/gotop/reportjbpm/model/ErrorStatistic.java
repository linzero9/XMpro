package com.gotop.reportjbpm.model;

import java.io.Serializable;


public class ErrorStatistic implements Serializable{
//	报单起始时间
	private String startTime;
//	报单结束时间
	private String endTime;
//	机构名称
	private String nextOrgName;
//	贷种
	private String loancategory;
//	主调信贷员
	private String nextOprName;
//	辅调信贷员
	private String fdxdy;
//	营业主管
	private String yxzg;
//	差错情况
	private String mistakeContent;
//	扣罚金额
	private String punishBal;
//	差错次数
	private String mistakeNumber;
//	差错环节
	private String taskName;
//	提出差错人
	private String empName;
//	提出差错时间
	private String addTime;
//	客户名称
	private String custName;
//	报单时间
	private String reportTime;
	
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getNextOrgName() {
		return nextOrgName;
	}
	public void setNextOrgName(String nextOrgName) {
		this.nextOrgName = nextOrgName;
	}
	public String getLoancategory() {
		return loancategory;
	}
	public void setLoancategory(String loancategory) {
		this.loancategory = loancategory;
	}
	public String getNextOprName() {
		return nextOprName;
	}
	public void setNextOprName(String nextOprName) {
		this.nextOprName = nextOprName;
	}
	public String getFdxdy() {
		return fdxdy;
	}
	public void setFdxdy(String fdxdy) {
		this.fdxdy = fdxdy;
	}
	public String getYxzg() {
		return yxzg;
	}
	public void setYxzg(String yxzg) {
		this.yxzg = yxzg;
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
	public String getMistakeNumber() {
		return mistakeNumber;
	}
	public void setMistakeNumber(String mistakeNumber) {
		this.mistakeNumber = mistakeNumber;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getAddTime() {
		return addTime;
	}
	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getReportTime() {
		return reportTime;
	}
	public void setReportTime(String reportTime) {
		this.reportTime = reportTime;
	}
	
	
	
	
	

}
