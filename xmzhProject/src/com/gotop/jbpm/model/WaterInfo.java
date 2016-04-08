package com.gotop.jbpm.model;

import java.io.Serializable;

public class WaterInfo implements Serializable {

	private Long waterId;
	private String flow_id;
	private String processName;
	private String custName;
	private String apply_bal;
	private String oneCategory;
	private String loanCategory;
	private String coorganization;
	private Long uptEmpid;
	private String uptOrgcode;
	private String uptTime;
	private String uptEmpname;
	private String uptOrgname;
	
	public Long getWaterId() {
		return waterId;
	}
	public void setWaterId(Long waterId) {
		this.waterId = waterId;
	}
	public String getFlow_id() {
		return flow_id;
	}
	public void setFlow_id(String flow_id) {
		this.flow_id = flow_id;
	}
	public String getProcessName() {
		return processName;
	}
	public void setProcessName(String processName) {
		this.processName = processName;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getApply_bal() {
		return apply_bal;
	}
	public void setApply_bal(String apply_bal) {
		this.apply_bal = apply_bal;
	}
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
	public String getCoorganization() {
		return coorganization;
	}
	public void setCoorganization(String coorganization) {
		this.coorganization = coorganization;
	}
	public Long getUptEmpid() {
		return uptEmpid;
	}
	public void setUptEmpid(Long uptEmpid) {
		this.uptEmpid = uptEmpid;
	}
	public String getUptOrgcode() {
		return uptOrgcode;
	}
	public void setUptOrgcode(String uptOrgcode) {
		this.uptOrgcode = uptOrgcode;
	}
	public String getUptTime() {
		return uptTime;
	}
	public void setUptTime(String uptTime) {
		this.uptTime = uptTime;
	}
	public String getUptEmpname() {
		return uptEmpname;
	}
	public void setUptEmpname(String uptEmpname) {
		this.uptEmpname = uptEmpname;
	}
	public String getUptOrgname() {
		return uptOrgname;
	}
	public void setUptOrgname(String uptOrgname) {
		this.uptOrgname = uptOrgname;
	}
	
}
