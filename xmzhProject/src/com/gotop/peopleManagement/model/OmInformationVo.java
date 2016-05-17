package com.gotop.peopleManagement.model;

import java.io.Serializable;

public class OmInformationVo implements Serializable {
	
	private String orgName;
	private String	roleName;
	private String posiName;
	
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getPosiName() {
		return posiName;
	}
	public void setPosiName(String posiName) {
		this.posiName = posiName;
	}
}
