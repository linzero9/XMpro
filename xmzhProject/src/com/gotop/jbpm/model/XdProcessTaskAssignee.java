package com.gotop.jbpm.model;

import java.io.Serializable;

public class XdProcessTaskAssignee implements Serializable {

	 /**
     * 主键 .
     * @abatorgenerated
     */
    private Long id;

    /**
     * 流程实例id .
     * @abatorgenerated
     */
    private String executionId;

    private String assignee;
    
    
    /**
     * 上个节点id .
     * @abatorgenerated
     */
    private String preTaskId;

    /**
     * 提交人id .
     * @abatorgenerated
     */
    private String preTaskAssingee;

    /**
     * 提交结构 .
     * @abatorgenerated
     */
    private Long preTaskOrg;

    /**
     * 提交时间 .
     * @abatorgenerated
     */
    private String preTaskTime;

    /**
     * 下个节点id .
     * @abatorgenerated
     */
    private String nextTaskId;

    /**
     * 节点id .
     * @abatorgenerated
     */
    private String taskId;

    /**
     * 业务主键 .
     * @abatorgenerated
     */
    private Long businessKey;

    /**
     * 业务类型 .
     * @abatorgenerated
     */
    private String businessType;
    
    /**
     * 提交人姓名-页面展示
     */
    private String preTaskAssingeeName;
    
    /**
     * 提交人机构名称-页面展示
     */
    private String preTaskOrgName;
    
    /**
     * 流程名称-页面展示
     */
    private String processName;
    
    
    private String businessTitle;

    /**
     * 流程类型-名称
     */
    private String businessName;
    
    private Long processTaskAssigneeId;
    
    private Long parentId;
    
    private String isChild;
    
    /*
     * 客户名称
     */
    private String custName;
    
    /*
     * 一级分类
     */
    private String oneCategory;
    
    /*
     *贷种分类 
     */
    private String loanCategory;
    

    
    /*
     * 上报时间
     */
    private String reportTime;
    
    /*
     * 申请金额
     */
    private String apply_bal;
    
    /*
     * 合作机构
     */
    private String coorganization;
    
    /**
     * 营销人员
     */
    private String yxry;
    /**
     * 营销人员机构
     */
    private String yxryjg;
    /**
     * 报单次数
     */
    private String reportcnt;
    
    /*
     * 流程标题
     */
    
	public String getReportcnt() {
		return reportcnt;
	}

	public String getYxry() {
		return yxry;
	}

	public void setYxry(String yxry) {
		this.yxry = yxry;
	}

	public String getYxryjg() {
		return yxryjg;
	}

	public void setYxryjg(String yxryjg) {
		this.yxryjg = yxryjg;
	}

	public void setReportcnt(String reportcnt) {
		this.reportcnt = reportcnt;
	}

	public String getApply_bal() {
		return apply_bal;
	}

	public void setApply_bal(String apply_bal) {
		this.apply_bal = apply_bal;
	}

	public String getCoorganization() {
		return coorganization;
	}

	public void setCoorganization(String coorganization) {
		this.coorganization = coorganization;
	}

	public Long getId() {
		return id;
	}
	
	//一级分类 数据字典ID 
	private String oneCategoryId;
	
	//贷种分类 数据字典ID ,用逗号间隔
	private String loanCategoryId;

	public String getLoanCategoryId() {
		return loanCategoryId;
	}

	public void setLoanCategoryId(String loanCategoryId) {
		this.loanCategoryId = loanCategoryId;
	}

	public String getOneCategoryId() {
		return oneCategoryId;
	}

	public void setOneCategoryId(String oneCategoryId) {
		this.oneCategoryId = oneCategoryId;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getExecutionId() {
		return executionId;
	}

	public void setExecutionId(String executionId) {
		this.executionId = executionId;
	}

	public String getAssignee() {
		return assignee;
	}

	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}

	public String getPreTaskId() {
		return preTaskId;
	}

	public void setPreTaskId(String preTaskId) {
		this.preTaskId = preTaskId;
	}

	public String getPreTaskAssingee() {
		return preTaskAssingee;
	}

	public void setPreTaskAssingee(String preTaskAssingee) {
		this.preTaskAssingee = preTaskAssingee;
	}

	public Long getPreTaskOrg() {
		return preTaskOrg;
	}

	public void setPreTaskOrg(Long preTaskOrg) {
		this.preTaskOrg = preTaskOrg;
	}

	public String getPreTaskTime() {
		return preTaskTime;
	}

	public void setPreTaskTime(String preTaskTime) {
		this.preTaskTime = preTaskTime;
	}

	public String getNextTaskId() {
		return nextTaskId;
	}

	public void setNextTaskId(String nextTaskId) {
		this.nextTaskId = nextTaskId;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public Long getBusinessKey() {
		return businessKey;
	}

	public void setBusinessKey(Long businessKey) {
		this.businessKey = businessKey;
	}

	public String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	public String getPreTaskAssingeeName() {
		return preTaskAssingeeName;
	}

	public void setPreTaskAssingeeName(String preTaskAssingeeName) {
		this.preTaskAssingeeName = preTaskAssingeeName;
	}

	public String getPreTaskOrgName() {
		return preTaskOrgName;
	}

	public void setPreTaskOrgName(String preTaskOrgName) {
		this.preTaskOrgName = preTaskOrgName;
	}

	public String getProcessName() {
		return processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}

	public String getBusinessTitle() {
		return businessTitle;
	}

	public void setBusinessTitle(String businessTitle) {
		this.businessTitle = businessTitle;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public Long getProcessTaskAssigneeId() {
		return processTaskAssigneeId;
	}

	public void setProcessTaskAssigneeId(Long processTaskAssigneeId) {
		this.processTaskAssigneeId = processTaskAssigneeId;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getIsChild() {
		return isChild;
	}

	public void setIsChild(String isChild) {
		this.isChild = isChild;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getOneCategory() {
		return oneCategory;
	}

	public void setOneCategory(String oneCategory) {
		this.oneCategory = oneCategory;
	}

	public String getLoanCategory() {
		return loanCategory;
	}

	public void setLoanCategory(String loanCategory) {
		this.loanCategory = loanCategory;
	}



	public String getReportTime() {
		return reportTime;
	}

	public void setReportTime(String reportTime) {
		this.reportTime = reportTime;
	}
    
    
}
