package com.gotop.reportjbpm.model;

import java.io.Serializable;

import com.informix.util.stringUtil;

public class Approval implements Serializable {
	private String nextOrgName;
	private String reportTime;
	private String iSurgent;
	private String custName;
	private String oldCust;
	private String oneCategory;
	private String loanCategory;
	private String currency;
	private String applyBal;
	private String orgNameOne;
	private String orgNameTwo;
	private String yxry;
	private String nextOprName;
	private String fdxdy;
	private String surveyTime;
	private String appWay;
	private String polNo;
	private String meetingCount;
	private String voteNo;
	private String appTime;
	private String conMatter;
	private String dsMsOne;
	private String dsMsTwo;
	private String dyApp;
	private String deApp;
	private String hyZrName;
	private String hyWyOne;
	private String shAddr;
	private String fxType;
	private String spType;
	private String ybjNum;
	private String hySyJl;
	private String pjJl;
	private String fxEd;
	private String sxEd;
	private String ywEd;
	private String repTimeStrat;
	private String repTimeEnd;
	private String appTimeStrat;
	private String appTimeEnd;

	//	审查人
//	private String ywEd;
//	第二审查人
//	private String ywEd;
//	审查岗审查时间
//	private String ywEd;
//	批复日期
//	private String ywEd;
//	上报
//	private String ywEd;
//	备注
//	private String ww;
	
	public String getRepTimeStrat() {
		return repTimeStrat;
	}
	public void setRepTimeStrat(String repTimeStrat) {
		this.repTimeStrat = repTimeStrat;
	}
	public String getRepTimeEnd() {
		return repTimeEnd;
	}
	public void setRepTimeEnd(String repTimeEnd) {
		this.repTimeEnd = repTimeEnd;
	}
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
	public String getNextOrgName() {
		return nextOrgName;
	}
	public void setNextOrgName(String nextOrgName) {
		this.nextOrgName = nextOrgName;
	}
	public String getReportTime() {
		return reportTime;
	}
	public void setReportTime(String reportTime) {
		this.reportTime = reportTime;
	}
	public String getiSurgent() {
		return iSurgent;
	}
	public void setiSurgent(String iSurgent) {
		this.iSurgent = iSurgent;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getOldCust() {
		return oldCust;
	}
	public void setOldCust(String oldCust) {
		this.oldCust = oldCust;
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
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getApplyBal() {
		return applyBal;
	}
	public void setApplyBal(String applyBal) {
		this.applyBal = applyBal;
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
	public String getYxry() {
		return yxry;
	}
	public void setYxry(String yxry) {
		this.yxry = yxry;
	}
	public String getNextOprName() {
		return nextOprName;
	}
	public void setNextOprName(String nextOprName) {
		this.nextOprName = nextOprName;
	}
	public String getFdxdy() {
		return fdxdy;
	}
	public void setFdxdy(String fdxdy) {
		this.fdxdy = fdxdy;
	}
	public String getSurveyTime() {
		return surveyTime;
	}
	public void setSurveyTime(String surveyTime) {
		this.surveyTime = surveyTime;
	}
	public String getAppWay() {
		return appWay;
	}
	public void setAppWay(String appWay) {
		this.appWay = appWay;
	}
	public String getPolNo() {
		return polNo;
	}
	public void setPolNo(String polNo) {
		this.polNo = polNo;
	}
	public String getMeetingCount() {
		return meetingCount;
	}
	public void setMeetingCount(String meetingCount) {
		this.meetingCount = meetingCount;
	}
	public String getVoteNo() {
		return voteNo;
	}
	public void setVoteNo(String voteNo) {
		this.voteNo = voteNo;
	}
	public String getAppTime() {
		return appTime;
	}
	public void setAppTime(String appTime) {
		this.appTime = appTime;
	}
	public String getConMatter() {
		return conMatter;
	}
	public void setConMatter(String conMatter) {
		this.conMatter = conMatter;
	}
	public String getDsMsOne() {
		return dsMsOne;
	}
	public void setDsMsOne(String dsMsOne) {
		this.dsMsOne = dsMsOne;
	}
	public String getDsMsTwo() {
		return dsMsTwo;
	}
	public void setDsMsTwo(String dsMsTwo) {
		this.dsMsTwo = dsMsTwo;
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
	public String getHyZrName() {
		return hyZrName;
	}
	public void setHyZrName(String hyZrName) {
		this.hyZrName = hyZrName;
	}
	public String getHyWyOne() {
		return hyWyOne;
	}
	public void setHyWyOne(String hyWyOne) {
		this.hyWyOne = hyWyOne;
	}
	public String getShAddr() {
		return shAddr;
	}
	public void setShAddr(String shAddr) {
		this.shAddr = shAddr;
	}
	public String getFxType() {
		return fxType;
	}
	public void setFxType(String fxType) {
		this.fxType = fxType;
	}
	public String getSpType() {
		return spType;
	}
	public void setSpType(String spType) {
		this.spType = spType;
	}
	public String getYbjNum() {
		return ybjNum;
	}
	public void setYbjNum(String ybjNum) {
		this.ybjNum = ybjNum;
	}
	public String getHySyJl() {
		return hySyJl;
	}
	public void setHySyJl(String hySyJl) {
		this.hySyJl = hySyJl;
	}
	public String getPjJl() {
		return pjJl;
	}
	public void setPjJl(String pjJl) {
		this.pjJl = pjJl;
	}
	public String getFxEd() {
		return fxEd;
	}
	public void setFxEd(String fxEd) {
		this.fxEd = fxEd;
	}
	public String getSxEd() {
		return sxEd;
	}
	public void setSxEd(String sxEd) {
		this.sxEd = sxEd;
	}
	public String getYwEd() {
		return ywEd;
	}
	public void setYwEd(String ywEd) {
		this.ywEd = ywEd;
	}
	
	
 
}
