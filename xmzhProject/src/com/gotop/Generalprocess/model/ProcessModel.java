package com.gotop.Generalprocess.model;

import com.gotop.Generalprocess.annonation.GeneralprocessField;

public abstract class ProcessModel implements  ProcessModelPublic{

	/**
	 * 模式通用主键
	 */
	@GeneralprocessField(name="唯一标识字段",type="text",hidden=false)
	private Long processModelId;

	/**
	 * 模式节点名称
	 */
	@GeneralprocessField(name="节点的显示名称",type="title")
	private String taskName;
	
	/**
	 * 模式通用意见
	 */
	@GeneralprocessField(name="模式通用意见",type="text",hidden=false)
	public String opinion;
	
	
	@GeneralprocessField(name="通用的客户姓名",type="text",hidden=false)
	private  String pubCustName;
	
	
	
	@GeneralprocessField(name="通用的FLOWID",type="text",hidden=false)
	private  String pubFlowId;
	
	
	

	public String getPubFlowId() {
		return pubFlowId;
	}

	public void setPubFlowId(String pubFlowId) {
		this.pubFlowId = pubFlowId;
	}



	public String getPubCustName() {
		return pubCustName;
	}

	public void setPubCustName(String pubCustName) {
		this.pubCustName = pubCustName;
	}

	public Long getProcessModelId() {
		return processModelId;
	}

	public void setProcessModelId(Long processModelId) {
		this.processModelId = processModelId;
	}

	public String getOpinion() {
		return opinion;
	}

	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	
}
