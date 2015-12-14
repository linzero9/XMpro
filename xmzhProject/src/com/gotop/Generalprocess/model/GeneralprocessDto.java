package com.gotop.Generalprocess.model;

import com.gotop.Generalprocess.annonation.GeneralprocessField;


/**
 * *******************************
 * <p>
 * Title: 通用信贷流程
 * </p>
 * 
 * <p>
 * Description: 
 * </p>
 * 
 * <p>
 * Copyright: 2015
 * </p>
 * 
 * <p>
 * Company: GOTOP
 * </p>
 * 
 * @author yyx
 * 
 * @date 2015-12-9
 * 
 * @version 1.0
 * 
 * 
 * *******************************
 */
public class GeneralprocessDto{
	
	/**
     * 流程实例id .
     * @abatorgenerated
     */
    private String executionId;

    private String activityName;
    
    /**
     * 业务类型 .
     * @abatorgenerated
     */
    private String businessType;
    
    /**
     * 业务主键 .
     * @abatorgenerated
     */
    private Long businessKey;
    
    /**
     * 提交人id .
     * @abatorgenerated
     */
    private String preTaskAssingee;
    
    
    /**
     * 下个节点id .
     * @abatorgenerated
     */
    private String nextTaskId;
    
    /**
     * 流程节点对象主键
     */
    private Long taskExeConfigId;
    
    /**
     * 提交人姓名-页面展示
     */
    private String preTaskAssingeeName;
    
    
	
	/****页面查询条件 ****/
	/*****start******/
	
	private String appTimeStrat;
	private String appTimeEnd;
	private String reporttimeStrat;
	private String reporttimeEnd;
	
	/**
	 * 受理支行（一级选项）
	*/
	private String orgCodeOne;
	
	/**
	 * 流程发起时间
	 */
	private String minoperaterDateStrat;
	private String minoperaterDateEnd;
	
	/**
	 * 受理支行（二级选项）
	*/
	private String orgCodeTwo;
		
	/**
	 * 受理支行一	名称
	 */
	private String orgNameOne;
	
	/**
	 * 受理支行二	名称
	 */
	private String orgNameTwo;
	
	/**
	 * 客户名称
	 */
	private String   cust_Name;
	
	/**
	 * 一级分类
	 */
	private String  oneCategory;
	private String  oneCategoryTxt;
		
	/**
	 * 贷种分类
	 */
	private String   loanCategory;
	private String   loanCategoryTxt;
	
	/**
	 * 主调信贷员
	 */
	private String  creator;
	
	/**
	 * 辅调信贷员
	 */
	private String  fdxdy;
	
	
	
	/**
     * 第一审批人.
     * @abatorgenerated
     */
    private String dyApp;

    /**
     * 第二审批人.
     * @abatorgenerated
     */
    private String deApp;
    
    /**
     * 第一审查人.
     * @abatorgenerated
     */
    private String dyCheck;
    
    /**
     * 第二审查人.
     * @abatorgenerated
     */
    private String deCheck;
    
    /**
     * 流程是否结束
     * @abatorgenerated
     */
    private String isEnd;
    
    
    private String currentAssingeeOrgname;
    
    private String  supportCategory;
    /*****end******/
    /****页面查询字段 ****/
    
    /****页面显示字段 *******/
    /*****start******/
    /**
     * 起草人empid
     */
    private Long beginEmpId;
    
    /**
     * 起草人所属机构orgid
     */
    private Long beginOrgId;
    
    /**
     * 当前节点办理人
     */
    private String currentAssingee;
    
    /**
     * 当前节点名称
     */
    private String currentActivityName;
    /**
     * 流程名称
     */
    private String processName;
    
    /**
     * 当前处理人机构
     */
    private String currentActivityOrgName;
    
	private String  apply_bal;
    
	/**
	 * 申请币别 数据字典PROCESS_MONEY
	 */
	private String  currency;
	
	/**
	 * 起草人姓名
	 */
	private String beginEmpname;
	/**
	 * 起草人机构名称
	 */
	private String beginOrgname;
    public String getBeginEmpname() {
		return beginEmpname;
	}

	public void setBeginEmpname(String beginEmpname) {
		this.beginEmpname = beginEmpname;
	}

	public String getBeginOrgname() {
		return beginOrgname;
	}

	public void setBeginOrgname(String beginOrgname) {
		this.beginOrgname = beginOrgname;
	}

	/*****end******/
    /****页面显示字段 *******/
    
    

	public String getAppTimeStrat() {
		return appTimeStrat;
	}

	public void setAppTimeStrat(String appTimeStrat) {
		this.appTimeStrat = appTimeStrat;
	}

	public String getAppTimeEnd() {
		return appTimeEnd;
	}

	public void setAppTimeEnd(String appTimeEnd) {
		this.appTimeEnd = appTimeEnd;
	}

	public String getReporttimeStrat() {
		return reporttimeStrat;
	}

	public void setReporttimeStrat(String reporttimeStrat) {
		this.reporttimeStrat = reporttimeStrat;
	}

	public String getReporttimeEnd() {
		return reporttimeEnd;
	}

	public void setReporttimeEnd(String reporttimeEnd) {
		this.reporttimeEnd = reporttimeEnd;
	}

	public String getOrgCodeOne() {
		return orgCodeOne;
	}

	public void setOrgCodeOne(String orgCodeOne) {
		this.orgCodeOne = orgCodeOne;
	}

	public String getOrgCodeTwo() {
		return orgCodeTwo;
	}

	public void setOrgCodeTwo(String orgCodeTwo) {
		this.orgCodeTwo = orgCodeTwo;
	}

	public String getOrgNameOne() {
		return orgNameOne;
	}

	public void setOrgNameOne(String orgNameOne) {
		this.orgNameOne = orgNameOne;
	}

	public String getOrgNameTwo() {
		return orgNameTwo;
	}

	public void setOrgNameTwo(String orgNameTwo) {
		this.orgNameTwo = orgNameTwo;
	}

	public String getCust_Name() {
		return cust_Name;
	}

	public void setCust_Name(String cust_Name) {
		this.cust_Name = cust_Name;
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

	public String getOneCategoryTxt() {
		return oneCategoryTxt;
	}

	public void setOneCategoryTxt(String oneCategoryTxt) {
		this.oneCategoryTxt = oneCategoryTxt;
	}

	public String getLoanCategoryTxt() {
		return loanCategoryTxt;
	}

	public void setLoanCategoryTxt(String loanCategoryTxt) {
		this.loanCategoryTxt = loanCategoryTxt;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getFdxdy() {
		return fdxdy;
	}

	public void setFdxdy(String fdxdy) {
		this.fdxdy = fdxdy;
	}

	public String getDyApp() {
		return dyApp;
	}

	public void setDyApp(String dyApp) {
		this.dyApp = dyApp;
	}

	public String getDeApp() {
		return deApp;
	}

	public void setDeApp(String deApp) {
		this.deApp = deApp;
	}

	public String getDyCheck() {
		return dyCheck;
	}

	public void setDyCheck(String dyCheck) {
		this.dyCheck = dyCheck;
	}

	public String getDeCheck() {
		return deCheck;
	}

	public void setDeCheck(String deCheck) {
		this.deCheck = deCheck;
	}

	public String getIsEnd() {
		return isEnd;
	}

	public void setIsEnd(String isEnd) {
		this.isEnd = isEnd;
	}

	public Long getBeginEmpId() {
		return beginEmpId;
	}

	public void setBeginEmpId(Long beginEmpId) {
		this.beginEmpId = beginEmpId;
	}

	public Long getBeginOrgId() {
		return beginOrgId;
	}

	public void setBeginOrgId(Long beginOrgId) {
		this.beginOrgId = beginOrgId;
	}

	public String getCurrentAssingee() {
		return currentAssingee;
	}

	public void setCurrentAssingee(String currentAssingee) {
		this.currentAssingee = currentAssingee;
	}

	public String getCurrentActivityName() {
		return currentActivityName;
	}

	public void setCurrentActivityName(String currentActivityName) {
		this.currentActivityName = currentActivityName;
	}

	public String getCurrentActivityOrgName() {
		return currentActivityOrgName;
	}

	public void setCurrentActivityOrgName(String currentActivityOrgName) {
		this.currentActivityOrgName = currentActivityOrgName;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getExecutionId() {
		return executionId;
	}

	public void setExecutionId(String executionId) {
		this.executionId = executionId;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	public Long getBusinessKey() {
		return businessKey;
	}

	public void setBusinessKey(Long businessKey) {
		this.businessKey = businessKey;
	}

	public String getPreTaskAssingee() {
		return preTaskAssingee;
	}

	public void setPreTaskAssingee(String preTaskAssingee) {
		this.preTaskAssingee = preTaskAssingee;
	}

	public String getNextTaskId() {
		return nextTaskId;
	}

	public void setNextTaskId(String nextTaskId) {
		this.nextTaskId = nextTaskId;
	}

	public Long getTaskExeConfigId() {
		return taskExeConfigId;
	}

	public void setTaskExeConfigId(Long taskExeConfigId) {
		this.taskExeConfigId = taskExeConfigId;
	}

	public String getPreTaskAssingeeName() {
		return preTaskAssingeeName;
	}

	public void setPreTaskAssingeeName(String preTaskAssingeeName) {
		this.preTaskAssingeeName = preTaskAssingeeName;
	}

	public String getApply_bal() {
		return apply_bal;
	}

	public void setApply_bal(String apply_bal) {
		this.apply_bal = apply_bal;
	}

	public String getCurrentAssingeeOrgname() {
		return currentAssingeeOrgname;
	}

	public void setCurrentAssingeeOrgname(String currentAssingeeOrgname) {
		this.currentAssingeeOrgname = currentAssingeeOrgname;
	}

	public String getSupportCategory() {
		return supportCategory;
	}

	public void setSupportCategory(String supportCategory) {
		this.supportCategory = supportCategory;
	}

	public String getMinoperaterDateStrat() {
		return minoperaterDateStrat;
	}

	public void setMinoperaterDateStrat(String minoperaterDateStrat) {
		this.minoperaterDateStrat = minoperaterDateStrat;
	}

	public String getMinoperaterDateEnd() {
		return minoperaterDateEnd;
	}

	public void setMinoperaterDateEnd(String minoperaterDateEnd) {
		this.minoperaterDateEnd = minoperaterDateEnd;
	}

	public String getProcessName() {
		return processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}
    
    
    
    
}
