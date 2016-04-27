package com.gotop.reportjbpm.model;

import java.io.Serializable;
import java.util.Date;

import com.gotop.Generalprocess.annonation.GeneralprocessField;

public class ReportCooperateInstitution implements Serializable{
	/**
	 * 
	 */ 
	private static final long serialVersionUID = 1L;
	@GeneralprocessField(name="序号",type="text",hidden=false)
	private Long number;

	@GeneralprocessField(name="模式一编号,信贷业务编号",type="text",hidden=false)
	private  Long   processModelOneID;
	
	@GeneralprocessField(name="流程ID",type="text",hidden=false)
	private  String  flow_Id;
	
	/**
	 * 结束时间
	 * */
	private String appTimeEnd;
	/**
	 * 开始时间
	 * */
	private String appTimeStrat;
	
	
	 /**
     * 放款日期
     * */
	@GeneralprocessField(name="放款日期",type="date")
     
	private Date endDate;

	@GeneralprocessField(name="客户名称",type="text")
	private String   cust_Name;
	
	@GeneralprocessField(name="申请金额",type="money")
	private String  apply_bal;

	@GeneralprocessField(name="合作机构",type="text")
	private String   coOrganization;

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	public Long getProcessModelOneID() {
		return processModelOneID;
	}

	public void setProcessModelOneID(Long processModelOneID) {
		this.processModelOneID = processModelOneID;
	}

	public String getFlow_Id() {
		return flow_Id;
	}

	public void setFlow_Id(String flow_Id) {
		this.flow_Id = flow_Id;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getCust_Name() {
		return cust_Name;
	}

	public void setCust_Name(String cust_Name) {
		this.cust_Name = cust_Name;
	}

	public String getApply_bal() {
		return apply_bal;
	}

	public void setApply_bal(String apply_bal) {
		this.apply_bal = apply_bal;
	}

	public String getCoOrganization() {
		return coOrganization;
	}

	public void setCoOrganization(String coOrganization) {
		this.coOrganization = coOrganization;
	}

	public String getAppTimeEnd() {
		return appTimeEnd;
	}

	public void setAppTimeEnd(String appTimeEnd) {
		this.appTimeEnd = appTimeEnd;
	}

	public String getAppTimeStrat() {
		return appTimeStrat;
	}

	public void setAppTimeStrat(String appTimeStrat) {
		this.appTimeStrat = appTimeStrat;
	}
	
}
