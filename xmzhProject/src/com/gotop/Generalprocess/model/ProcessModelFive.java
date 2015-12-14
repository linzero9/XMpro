package com.gotop.Generalprocess.model;

import java.io.Serializable;

import com.gotop.Generalprocess.annonation.GeneralprocessField;

/**
 * 模式五对象
 * @author wsd
 *
 */
public class ProcessModelFive extends ProcessModel  implements  Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 流程实例id
	 */
	@GeneralprocessField(name="流程业务id",type="text",hidden=false)
	private String flowId;
	
	 /**
     * 决策单编号 .
     * @abatorgenerated
     */
	@GeneralprocessField(name="决策单编号",type="text")
    private String polNo;
	
	 /**
     * 表决表编号 .
     * @abatorgenerated
     */
	@GeneralprocessField(name="表决表编号",type="text")
    private String voteNo;
	
	/**
     * 审批方式,0-当签,1-双签,2-会议 .
     * @abatorgenerated
     */
	@GeneralprocessField(name="审批方式",type="dic",dicname="PROCESS_method")
    private String appWay;

    /**
     * 会议期数 .
     * @abatorgenerated
     */
	@GeneralprocessField(name="会议期数",type="text")
    private String meetingCount;

   

    /**
     * 审批岗审结时间,格式YYYYMMDD .
     * @abatorgenerated
     */
	@GeneralprocessField(name="审批岗审结时间",type="text")
    private String appTime;

    /**
     * 审议事项（可多选）,0-评级,1-授信额度,2-单笔业务 .
     * @abatorgenerated
     */
	@GeneralprocessField(name="审议事项",type="dic",dicname="PROCESS_Consideration")
    private String conMatter;

    /**
     * 授信部负责人签批时间,格式YYYYMMDD .
     * @abatorgenerated
     */
	@GeneralprocessField(name="授信部负责人签批时间",type="text")
    private String sxAppTime;

    /**
     * 有权审批人签批时间,格式YYYYMMDD .
     * @abatorgenerated
     */
	@GeneralprocessField(name="有权审批人签批时间",type="text")
    private String yqAppTime;

    /**
     * 第一审批人（会议审批委员） .
     * @abatorgenerated
     */
	@GeneralprocessField(name="第一审批人（会议审批委员）",type="text")
    private String dyApp;

    /**
     * 第二审批人（会议审批委员） .
     * @abatorgenerated
     */
	@GeneralprocessField(name="第二审批人（会议审批委员）",type="text")
    private String deApp;

    /**
     * 会议审批主任委员 .
     * @abatorgenerated
     */
	@GeneralprocessField(name="会议审批主任委员",type="text")
    private String hyZrName;

    /**
     * 会议审批委员1 .
     * @abatorgenerated
     */
	@GeneralprocessField(name="会议审批委员1",type="text")
    private String hyWyOne;

    /**
     * 会议审批委员2 .
     * @abatorgenerated
     */
	@GeneralprocessField(name="会议审批委员2",type="text")
    private String hyWyTwo;

    /**
     * 贷审会秘书一 .
     * @abatorgenerated
     */
	@GeneralprocessField(name="贷审会秘书一",type="text")
    private String dsMsOne;

    /**
     * 贷审会秘书二 .
     * @abatorgenerated
     */
	@GeneralprocessField(name="贷审会秘书二",type="text")
    private String dsMsTwo;

    /**
     * 上会地点 .
     * @abatorgenerated
     */
	@GeneralprocessField(name="上会地点",type="text")
    private String shAddr;

    /**
     * 风险类型,0-低风险,1-非低风险 .
     * @abatorgenerated
     */
	@GeneralprocessField(name="风险类型",type="dic",dicname="PROCESS_risk")
    private String fxType;

    /**
     * 审批类型,0-首次,1-复议,2-变更 .
     * @abatorgenerated
     */
	@GeneralprocessField(name="审批类型",type="dic",dicname="PROCESS_approve")
    private String spType;

    /**
     * 有表决权人数 .
     * @abatorgenerated
     */
	@GeneralprocessField(name="有表决权人数",type="text")
    private String ybjNum;

    /**
     * 会议审议结论,0-同意,1-有条件同意,2-退回,3-拒绝 .
     * @abatorgenerated
     */
	@GeneralprocessField(name="会议审议结论",type="dic",dicname="PROCESS_conclusion")
    private String hySyJl;

    /**
     * 风险币别 .
     * @abatorgenerated
     */
	@GeneralprocessField(name="风险币别",type="dic",dicname="PROCESS_MONEY")
    private String fxBb;

    /**
     * 风险额度,单位万元 .
     * @abatorgenerated
     */
	@GeneralprocessField(name="风险额度",type="money")
    private String fxEd;

    /**
     * 授信币别 .
     * @abatorgenerated
     */
	@GeneralprocessField(name="授信币别",type="dic",dicname="PROCESS_MONEY")
    private String sxBb;

    /**
     * 授信额度,单位万元 .
     * @abatorgenerated
     */
	@GeneralprocessField(name="授信额度",type="money")
    private String sxEd;

    /**
     * 业务币别 .
     * @abatorgenerated
     */
	@GeneralprocessField(name="业务币别",type="dic",dicname="PROCESS_MONEY")
    private String ywBb;

    /**
     * 业务额度,单位万元 .
     * @abatorgenerated
     */
	@GeneralprocessField(name="业务额度",type="money")
    private String ywEd;
	
	 /**
     * 评级结论 .
     * @abatorgenerated
     */
	@GeneralprocessField(name="评级结论",type="text")
    private String pjJl;
	
	@GeneralprocessField(name="处理意见",type="text")
	private  String optionNew;
	
	
	
	
	

	public String getOptionNew() {
		return optionNew;
	}

	public void setOptionNew(String optionNew) {
		this.optionNew = optionNew;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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

	public String getSxAppTime() {
		return sxAppTime;
	}

	public void setSxAppTime(String sxAppTime) {
		this.sxAppTime = sxAppTime;
	}

	public String getYqAppTime() {
		return yqAppTime;
	}

	public void setYqAppTime(String yqAppTime) {
		this.yqAppTime = yqAppTime;
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

	public String getHyWyTwo() {
		return hyWyTwo;
	}

	public void setHyWyTwo(String hyWyTwo) {
		this.hyWyTwo = hyWyTwo;
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

	public String getFxBb() {
		return fxBb;
	}

	public void setFxBb(String fxBb) {
		this.fxBb = fxBb;
	}

	public String getFxEd() {
		return fxEd;
	}

	public void setFxEd(String fxEd) {
		this.fxEd = fxEd;
	}

	public String getSxBb() {
		return sxBb;
	}

	public void setSxBb(String sxBb) {
		this.sxBb = sxBb;
	}

	public String getSxEd() {
		return sxEd;
	}

	public void setSxEd(String sxEd) {
		this.sxEd = sxEd;
	}

	public String getYwBb() {
		return ywBb;
	}

	public void setYwBb(String ywBb) {
		this.ywBb = ywBb;
	}

	public String getYwEd() {
		return ywEd;
	}

	public void setYwEd(String ywEd) {
		this.ywEd = ywEd;
	}

	public String getFlowId() {
		return flowId;
	}

	public void setFlowId(String flowId) {
		this.flowId = flowId;
	}

}
