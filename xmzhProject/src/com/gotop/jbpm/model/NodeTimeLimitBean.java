package com.gotop.jbpm.model;

import java.io.Serializable;

public class NodeTimeLimitBean implements Serializable {

	private String taskName; //节点任务名称
	
	private Double timeLimit; //时限
	
	private Long c_id;
	
	private Long e_id;
	
	private Long op_empid;
	
	private String op_orgcode;
	
	private String op_time;

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public Double getTimeLimit() {
		return timeLimit;
	}

	public void setTimeLimit(Double timeLimit) {
		this.timeLimit = timeLimit;
	}

	public Long getC_id() {
		return c_id;
	}

	public void setC_id(Long c_id) {
		this.c_id = c_id;
	}

	public Long getE_id() {
		return e_id;
	}

	public void setE_id(Long e_id) {
		this.e_id = e_id;
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

	public String getOp_time() {
		return op_time;
	}

	public void setOp_time(String op_time) {
		this.op_time = op_time;
	}
	
	
}
