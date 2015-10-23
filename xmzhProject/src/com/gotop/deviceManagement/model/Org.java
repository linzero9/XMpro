package com.gotop.deviceManagement.model;

import java.io.Serializable;

public class Org  implements  Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long orgid;
	
	private   String  orgcode;
	
	private   String  orgname;

	public Long getOrgid() {
		return orgid;
	}

	public void setOrgid(Long orgid) {
		this.orgid = orgid;
	}

	public String getOrgcode() {
		return orgcode;
	}

	public void setOrgcode(String orgcode) {
		this.orgcode = orgcode;
	}

	public String getOrgname() {
		return orgname;
	}

	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}
	
	
}
