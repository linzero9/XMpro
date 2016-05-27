package com.gotop.timeMachine.model;

import java.io.Serializable;

public class OverTimeReport  implements Serializable{

	private Long id; //主键
	
	private String reportTime ;//报单时间
	
	private String taskName;//超限环节的任务名称
	
	private String custName;//客户名称
	
	private String oneCategory_name;//一级分类 名称
	
	private String loanCategory_name;//贷种分类 名称
	
	private String orgname;//合作机构
	
	private String orgname_one;//受理支行（一级选项）
	
	private String orgname_two;//受理支行（二级选项）
	
	private String empname;//超限人员
	
	private Double overtime;//超限时长（单位：小时）
	
	private String remark;//备注
	
	private Long request_id ; //请求标识， 用于识别 每次的action请求
	
	private String process_name; //流程模版名称
	
	private String flow_id; //流程实例id
	
	private String starttime;//节点开始时间
	
	private String endtime;//节点结束时间
	
	private Double timeLimitOne;//一次提交时限
	
	private Double timeLimitTwo;//二次提交时限
	
	private int rn;//标志为一次提交还是二次提交。rn=1表示一次提交,不等于1都为二次提交
	
	private Double expendtime;//节点消耗时长
	
	private String end_status;//节点消耗时长
	
	private String reportStarttime; //报单开始时间（只用于JSP页面的查询项）
	private String reportEndtime; //报单结束时间（只用于JSP页面的查询项）
	
	

	public String getReportStarttime() {
		return reportStarttime;
	}

	public void setReportStarttime(String reportStarttime) {
		this.reportStarttime = reportStarttime;
	}

	public String getReportEndtime() {
		return reportEndtime;
	}

	public void setReportEndtime(String reportEndtime) {
		this.reportEndtime = reportEndtime;
	}

	public String getReportTime() {
		return reportTime;
	}

	public void setReportTime(String reportTime) {
		this.reportTime = reportTime;
	}

	

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	

	public String getLoanCategory_name() {
		return loanCategory_name;
	}

	public void setLoanCategory_name(String loanCategory_name) {
		this.loanCategory_name = loanCategory_name;
	}

	public String getOrgname() {
		return orgname;
	}

	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public Double getOvertime() {
		return overtime;
	}

	public void setOvertime(Double overtime) {
		this.overtime = overtime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRequest_id() {
		return request_id;
	}

	public void setRequest_id(Long request_id) {
		this.request_id = request_id;
	}

	public String getProcess_name() {
		return process_name;
	}

	public void setProcess_name(String process_name) {
		this.process_name = process_name;
	}

	public String getFlow_id() {
		return flow_id;
	}

	public void setFlow_id(String flow_id) {
		this.flow_id = flow_id;
	}

	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	

	public Double getTimeLimitOne() {
		return timeLimitOne;
	}

	public void setTimeLimitOne(Double timeLimitOne) {
		this.timeLimitOne = timeLimitOne;
	}

	public Double getTimeLimitTwo() {
		return timeLimitTwo;
	}

	public void setTimeLimitTwo(Double timeLimitTwo) {
		this.timeLimitTwo = timeLimitTwo;
	}

	public int getRn() {
		return rn;
	}

	public void setRn(int rn) {
		this.rn = rn;
	}

	public Double getExpendtime() {
		return expendtime;
	}

	public void setExpendtime(Double expendtime) {
		this.expendtime = expendtime;
	}

	public String getEnd_status() {
		return end_status;
	}

	public void setEnd_status(String end_status) {
		this.end_status = end_status;
	}

	public String getOrgname_one() {
		return orgname_one;
	}

	public void setOrgname_one(String orgname_one) {
		this.orgname_one = orgname_one;
	}

	public String getOrgname_two() {
		return orgname_two;
	}

	public void setOrgname_two(String orgname_two) {
		this.orgname_two = orgname_two;
	}

	public String getOneCategory_name() {
		return oneCategory_name;
	}

	public void setOneCategory_name(String oneCategory_name) {
		this.oneCategory_name = oneCategory_name;
	}

	

	
}
