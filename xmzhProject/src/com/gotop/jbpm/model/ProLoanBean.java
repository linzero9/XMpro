package com.gotop.jbpm.model;

import java.io.Serializable;

public class ProLoanBean implements Serializable {
	
	private Long b_id;
	
	private Long c_id;
	
	private String definitionId;
	
	private String processName;
	
	private String oneCategory_name;  //一级分类 名称
	
	private String loanCategory_name;  //贷种分类 名称
	
private String init_oneCategory_name;  //一级分类 名称
	
	private String init_loanCategory_name;  //贷种分类 名称
	
	private Long op_empid; //操作员工id
	
	private String op_orgcode; //操作员工机构

	public String getDefinitionId() {
		return definitionId;
	}

	public void setDefinitionId(String definitionId) {
		this.definitionId = definitionId;
	}

	public String getOneCategory_name() {
		return oneCategory_name;
	}

	public void setOneCategory_name(String oneCategory_name) {
		this.oneCategory_name = oneCategory_name;
	}

	public String getLoanCategory_name() {
		return loanCategory_name;
	}

	public void setLoanCategory_name(String loanCategory_name) {
		this.loanCategory_name = loanCategory_name;
	}

	public String getProcessName() {
		return processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}

	

	public Long getOp_empid() {
		return op_empid;
	}

	public void setOp_empid(Long op_empid) {
		this.op_empid = op_empid;
	}

	public String getOp_orgcode() {
		return op_orgcode;
	}

	public void setOp_orgcode(String op_orgcode) {
		this.op_orgcode = op_orgcode;
	}

	public Long getB_id() {
		return b_id;
	}

	public void setB_id(Long b_id) {
		this.b_id = b_id;
	}

	public Long getC_id() {
		return c_id;
	}

	public void setC_id(Long c_id) {
		this.c_id = c_id;
	}

	public String getInit_oneCategory_name() {
		return init_oneCategory_name;
	}

	public void setInit_oneCategory_name(String init_oneCategory_name) {
		this.init_oneCategory_name = init_oneCategory_name;
	}

	public String getInit_loanCategory_name() {
		return init_loanCategory_name;
	}

	public void setInit_loanCategory_name(String init_loanCategory_name) {
		this.init_loanCategory_name = init_loanCategory_name;
	}
	
	
}
