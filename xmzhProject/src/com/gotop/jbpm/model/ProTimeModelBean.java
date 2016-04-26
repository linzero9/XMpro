package com.gotop.jbpm.model;

import java.io.Serializable;

public class ProTimeModelBean implements Serializable {

	private Long c_id;
	
	private String time_modelName;
	
	private String definitionId;

	public Long getC_id() {
		return c_id;
	}

	public void setC_id(Long c_id) {
		this.c_id = c_id;
	}

	public String getTime_modelName() {
		return time_modelName;
	}

	public void setTime_modelName(String time_modelName) {
		this.time_modelName = time_modelName;
	}

	public String getDefinitionId() {
		return definitionId;
	}

	public void setDefinitionId(String definitionId) {
		this.definitionId = definitionId;
	}
	
	
}
