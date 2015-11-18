package com.gotop.Generalprocess.model;

import java.io.Serializable;

import com.gotop.Generalprocess.annonation.GeneralprocessField;

public class ProcessModelTwo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@GeneralprocessField(name="唯一主键",type="text",hidden=false)
	private Integer rec_id;//主键
	
	@GeneralprocessField(name="流程业务id",type="text",hidden=false)
	private Integer flow_Id;//流程的id
	
	@GeneralprocessField(name="来源类型",type="text")
	private String Resource_type;
	
	@GeneralprocessField(name="意见内容",type="text")
	private String opninion_content;
	
	@GeneralprocessField(name="操作类型",type="text")
	private String operator_type;
	
	@GeneralprocessField(name="操作员",type="text")
	private String operator;
	
	@GeneralprocessField(name="创建日期",type="date")
	private String operater_date;
	
	@GeneralprocessField(name="操作时间",type="date")
	private String operater_time;

	@GeneralprocessField(name="节点编号",type="text")
	private String node_id;
	
	@GeneralprocessField(name="节点名称",type="text")
	private String Node_name;
	
	@GeneralprocessField(name="操作人机构",type="text")
	private String orgid;

	@GeneralprocessField(name="下个节点操作人",type="text")
	private String next_opr_name;

	public Integer getRec_id() {
		return rec_id;
	}

	public void setRec_id(Integer rec_id) {
		this.rec_id = rec_id;
	}

	public Integer getFlow_Id() {
		return flow_Id;
	}

	public void setFlow_Id(Integer flow_Id) {
		this.flow_Id = flow_Id;
	}

	public String getResource_type() {
		return Resource_type;
	}

	public void setResource_type(String resource_type) {
		Resource_type = resource_type;
	}

	public String getOpninion_content() {
		return opninion_content;
	}

	public void setOpninion_content(String opninion_content) {
		this.opninion_content = opninion_content;
	}

	public String getOperator_type() {
		return operator_type;
	}

	public void setOperator_type(String operator_type) {
		this.operator_type = operator_type;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getOperater_date() {
		return operater_date;
	}

	public void setOperater_date(String operater_date) {
		this.operater_date = operater_date;
	}

	public String getOperater_time() {
		return operater_time;
	}

	public void setOperater_time(String operater_time) {
		this.operater_time = operater_time;
	}

	public String getNode_id() {
		return node_id;
	}

	public void setNode_id(String node_id) {
		this.node_id = node_id;
	}

	public String getNode_name() {
		return Node_name;
	}

	public void setNode_name(String node_name) {
		Node_name = node_name;
	}

	public String getOrgid() {
		return orgid;
	}

	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}

	public String getNext_opr_name() {
		return next_opr_name;
	}

	public void setNext_opr_name(String next_opr_name) {
		this.next_opr_name = next_opr_name;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
