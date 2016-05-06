package com.gotop.jbpm.model;

import java.io.Serializable;

public class CopyOfWorkTimeMainBean implements Serializable {

private Long mainID;//主表ID
	
	private String startDate;//开始日期
	
	private String endDate;//结束日期
	
	private String orgcode;//机构号
	
	private Long empid;//员工ID
	
	private Long id;//副表ID
	
	private String timeType;//时间类型
	
	private String startTime;//开始时间
	
	private String endTime;//结束时间

	public Long getMainID() {
		return mainID;
	}

	public void setMainID(Long mainID) {
		this.mainID = mainID;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getOrgcode() {
		return orgcode;
	}

	public void setOrgcode(String orgcode) {
		this.orgcode = orgcode;
	}

	public Long getEmpid() {
		return empid;
	}

	public void setEmpid(Long empid) {
		this.empid = empid;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTimeType() {
		return timeType;
	}

	public void setTimeType(String timeType) {
		this.timeType = timeType;
	}

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
	
	
}
