package com.gotop.jbpm.model;

import java.io.Serializable;

public class WorkTimeSideBean implements Serializable {

	private Long id;//副表ID
	
	private Long mainID;//主表ID
	
	private String timeType;//时间类型
	
	private String startTime;//开始时间
	
	private String endTime;//结束时间

	public Long getMainID() {
		return mainID;
	}

	public void setMainID(Long mainID) {
		this.mainID = mainID;
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
