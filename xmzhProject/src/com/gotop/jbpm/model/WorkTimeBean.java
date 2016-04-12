package com.gotop.jbpm.model;

import java.io.Serializable;

public class WorkTimeBean implements Serializable {

	private Long id;  //ID
	
	private  String model_tableName;  //节点模式的表名
	
	private Double workTime; //工时
	
	private Long op_empid;  //操作员工id
	
	private String op_orgcode;  //操作员工的机构号
	
	private String op_time;  //操作时间

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModel_tableName() {
		return model_tableName;
	}

	public void setModel_tableName(String model_tableName) {
		this.model_tableName = model_tableName;
	}

	public Double getWorkTime() {
		return workTime;
	}

	public void setWorkTime(Double workTime) {
		this.workTime = workTime;
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
