package com.gotop.jbpm.model;

import java.io.Serializable;

public class OneAndLoanBean implements Serializable {

	private Long d_id;
	
	private String oneCategory_id;  //一级分类id
	
	private String oneCategory_name;  //一级分类 名称
	
	private String loanCategory_id;  //贷种分类id
	
	private String loanCategory_name;  //贷种分类 名称
	

	public Long getD_id() {
		return d_id;
	}

	public void setD_id(Long d_id) {
		this.d_id = d_id;
	}

	public String getOneCategory_id() {
		return oneCategory_id;
	}

	public void setOneCategory_id(String oneCategory_id) {
		this.oneCategory_id = oneCategory_id;
	}

	public String getOneCategory_name() {
		return oneCategory_name;
	}

	public void setOneCategory_name(String oneCategory_name) {
		this.oneCategory_name = oneCategory_name;
	}

	public String getLoanCategory_id() {
		return loanCategory_id;
	}

	public void setLoanCategory_id(String loanCategory_id) {
		this.loanCategory_id = loanCategory_id;
	}

	public String getLoanCategory_name() {
		return loanCategory_name;
	}

	public void setLoanCategory_name(String loanCategory_name) {
		this.loanCategory_name = loanCategory_name;
	}
	
	
}
