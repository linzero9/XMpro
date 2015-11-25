package com.gotop.Generalprocess.model;

import java.io.Serializable;

import com.gotop.Generalprocess.annonation.GeneralprocessField;

public class ProcessModelTwo extends ProcessModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@GeneralprocessField(name="流程业务id",type="text",hidden=false)
	private String flow_id;//流程的id
	
	@GeneralprocessField(name="意见内容",type="text")
	private String opninion_content;

	public String getFlow_id() {
		return flow_id;
	}

	public void setFlow_id(String flow_id) {
		this.flow_id = flow_id;
	}

	public String getOpninion_content() {
		return opninion_content;
	}

	public void setOpninion_content(String opninion_content) {
		this.opninion_content = opninion_content;
	}
	
}
