package com.gotop.timeMachine.model;

import java.io.Serializable;

/**
 * @desc 用于存当前节点为“结束”的信贷流程
 * @author liaomeiting
 *
 */
public class XdproForEnd  implements Serializable{

	private String flow_id;  //流程id
	private String definition_id;   //流程模版id
	private String process_name; //流程名称
	
	public String getFlow_id() {
		return flow_id;
	}
	public void setFlow_id(String flow_id) {
		this.flow_id = flow_id;
	}
	public String getDefinition_id() {
		return definition_id;
	}
	public void setDefinition_id(String definition_id) {
		this.definition_id = definition_id;
	}
	public String getProcess_name() {
		return process_name;
	}
	public void setProcess_name(String process_name) {
		this.process_name = process_name;
	}
	
	
	
}
