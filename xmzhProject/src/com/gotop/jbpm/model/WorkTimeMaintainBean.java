package com.gotop.jbpm.model;

import java.io.Serializable;

public class WorkTimeMaintainBean implements Serializable {

private Long mainID;
	
	private String startDate;
	
	private String endDate;
	
	private String orgcode;
	
	private Long empid;
	
	private Long id;
	
	private String timeType;
	
	private String startTime;
	
	private String endTime;

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
