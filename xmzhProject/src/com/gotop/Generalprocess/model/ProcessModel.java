package com.gotop.Generalprocess.model;

public abstract class ProcessModel implements  ProcessModelPublic{

	/**
	 * 模式通用主键
	 */
	private Long processModelId;

	/**
	 * 模式节点名称
	 */
	private String taskName;
	
	/**
	 * 模式通用意见
	 */
	public String opinion;

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
