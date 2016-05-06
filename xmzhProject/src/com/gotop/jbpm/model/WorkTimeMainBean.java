package com.gotop.jbpm.model;

import java.io.Serializable;

public class WorkTimeMainBean implements Serializable {

    private Long id;//主表ID
	
	private String startDate;//开始日期
	
	private String endDate;//结束日期
	
	private String orgcode;//机构号
	
	private Long empid;//员工ID
	
	private String delState;//员工ID

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

	public String getDelState() {
		return delState;
	}

	public void setDelState(String delState) {
		this.delState = delState;
	}
	
	

}
