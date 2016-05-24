package com.gotop.reportjbpm.model;

import java.io.Serializable;

import com.informix.util.stringUtil;

public class Approval implements Serializable {
	private String nextOrgName;
	private String reportTime;
	private String isurgent;
	private String custName;
	private String oldCust;
	private String oneCategory;
	private String loanCategory;
	private String currency;
	private Double applyBal;
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
	private String yxryjg;

	//审批日期
	private String approvalTime;
//	审查人
	private String checkOne;
//	第二审查人
	private String checkTwo;
//	审查岗审查时间
	private String checkTime;
//	批复日期
	private String replyTime;
//	总的上报接收时间
	private String receiveTime;
//	上报接收时间1
	private String receiveOne;
//	上报接收时间2
	private String receiveTwo;
//	上报接收时间3
	private String receiveThree;
//	上报接收时间4
	private String receiveFour;
//	上报接收时间5
	private String receiveFive;
//	备注
//	private String ww;
//	总的上报退回时间
	private String returnTime;
//	上报退回时间1
	private String returnOne;
//	上报退回时间2
	private String returnTwo;
//	上报退回时间3
	private String returnThree;
//	上报退回时间4
	private String returnFour;
//	上报退回时间5
	private String returnFive;
//	总的上报时间
	private String reportedTime;
	//二次上报
	private String reportedTwo;
	//san次上报
	private String reportedThree;
	//四次上报
	private String reportedFour;
	//五次上报
	private String reportedFive;
	
	public String getReturnTime() {
		return returnTime;
	}
	public void setReturnTime(String returnTime) {
		this.returnTime = returnTime;
	}
	public String getReturnOne() {
		return returnOne;
	}
	public void setReturnOne(String returnOne) {
		this.returnOne = returnOne;
	}
	public String getReturnTwo() {
		return returnTwo;
	}
	public void setReturnTwo(String returnTwo) {
		this.returnTwo = returnTwo;
	}
	public String getReturnThree() {
		return returnThree;
	}
	public void setReturnThree(String returnThree) {
		this.returnThree = returnThree;
	}
	public String getReturnFour() {
		return returnFour;
	}
	public void setReturnFour(String returnFour) {
		this.returnFour = returnFour;
	}
	public String getReturnFive() {
		return returnFive;
	}
	public void setReturnFive(String returnFive) {
		this.returnFive = returnFive;
	}
	public String getReportedTime() {
		return reportedTime;
	}
	public void setReportedTime(String reportedTime) {
		this.reportedTime = reportedTime;
	}
	public String getReportedTwo() {
		return reportedTwo;
	}
	public void setReportedTwo(String reportedTwo) {
		this.reportedTwo = reportedTwo;
	}
	public String getReportedThree() {
		return reportedThree;
	}
	public void setReportedThree(String reportedThree) {
		this.reportedThree = reportedThree;
	}
	public String getReportedFour() {
		return reportedFour;
	}
	public void setReportedFour(String reportedFour) {
		this.reportedFour = reportedFour;
	}
	public String getReportedFive() {
		return reportedFive;
	}
	public void setReportedFive(String reportedFive) {
		this.reportedFive = reportedFive;
	}
	public String getRepTimeStrat() {
		return repTimeStrat;
	}
	public String getApprovalTime() {
		return approvalTime;
	}
	public void setApprovalTime(String approvalTime) {
		this.approvalTime = approvalTime;
	}
	public String getCheckOne() {
		return checkOne;
	}
	public void setCheckOne(String checkOne) {
		this.checkOne = checkOne;
	}
	public String getCheckTwo() {
		return checkTwo;
	}
	public void setCheckTwo(String checkTwo) {
		this.checkTwo = checkTwo;
	}
	public String getCheckTime() {
		return checkTime;
	}
	public void setCheckTime(String checkTime) {
		this.checkTime = checkTime;
	}
	public String getReplyTime() {
		return replyTime;
	}
	public void setReplyTime(String replyTime) {
		this.replyTime = replyTime;
	}
	public String getReceiveTime() {
		return receiveTime;
	}
	public void setReceiveTime(String receiveTime) {
		this.receiveTime = receiveTime;
	}
	public String getReceiveOne() {
		return receiveOne;
	}
	public void setReceiveOne(String receiveOne) {
		this.receiveOne = receiveOne;
	}
	public String getReceiveTwo() {
		return receiveTwo;
	}
	public void setReceiveTwo(String receiveTwo) {
		this.receiveTwo = receiveTwo;
	}
	public String getReceiveThree() {
		return receiveThree;
	}
	public void setReceiveThree(String receiveThree) {
		this.receiveThree = receiveThree;
	}
	public String getReceiveFour() {
		return receiveFour;
	}
	public void setReceiveFour(String receiveFour) {
		this.receiveFour = receiveFour;
	}
	public String getReceiveFive() {
		return receiveFive;
	}
	public void setReceiveFive(String receiveFive) {
		this.receiveFive = receiveFive;
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
	
	
	public String getCustName() {
		return custName;
	}
	
	public String getIsurgent() {
		return isurgent;
	}
	public void setIsurgent(String isurgent) {
		this.isurgent = isurgent;
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
	public Double getApplyBal() {
		return applyBal;
	}
	public void setApplyBal(Double applyBal) {
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
	
	public String getYxryjg() {
		return yxryjg;
	}
	public void setYxryjg(String yxryjg) {
		this.yxryjg = yxryjg;
	}
 
}
