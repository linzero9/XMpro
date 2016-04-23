/**
 * 
 */
package com.gotop.reportjbpm.model;

/**
 * @author gotop
 *
 */
public class RateofreturnReport {
	
	
	//审批时间开始
	private String appTimeStrat;
	
	//结束时间
	private String appTimeEnd;
	
	
	//一级分类
	private String oneCategory;
	
	 //贷种分类
	private String  loanCategory;
	
	//区支行
	private String orgNameOne;
	
	//二级支行
	private String orgNameTwo;
	
	//本月审批通过笔数
	private String passNumber;
	
	//1次退单率
	private String backOne;
	
	//2次退单率
	private String backTwo;
	
	//3次退单率
	private String backThree;
	
	//4次退单率
	private String backFour;
	
	
	
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
	public String getPassNumber() {
		return passNumber;
	}
	public void setPassNumber(String passNumber) {
		this.passNumber = passNumber;
	}
	public String getBackOne() {
		return backOne;
	}
	public void setBackOne(String backOne) {
		this.backOne = backOne;
	}
	public String getBackTwo() {
		return backTwo;
	}
	public void setBackTwo(String backTwo) {
		this.backTwo = backTwo;
	}
	public String getBackThree() {
		return backThree;
	}
	public void setBackThree(String backThree) {
		this.backThree = backThree;
	}
	public String getBackFour() {
		return backFour;
	}
	public void setBackFour(String backFour) {
		this.backFour = backFour;
	}
	
	
}
