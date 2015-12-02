package com.gotop.Generalprocess.model;

import java.io.Serializable;

import com.gotop.Generalprocess.annonation.GeneralprocessField;

public class ProcessModelSix  extends ProcessModel  implements  Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	@GeneralprocessField(name="流程id",type="text")
	private  String flow_id;
	
	@GeneralprocessField(name="抵押送件时间",type="text")
	private String  MORTGAGE_TIME;
	
	@GeneralprocessField(name="收到他项时间",type="text")
	private String RECEIVE_TIME;
	
	@GeneralprocessField(name="公积金中心申请时间",type="text")
	private String  APPLICATION_TIME;
	
	@GeneralprocessField(name="公积金中心下达放款指标时间",type="text")
	private  String  ISSUED_TIME;
	
	@GeneralprocessField(name="支用类别",type="dic",dicname="PROCESS_pay")
	private  String SUPPORT_CATEGORY;
	
	@GeneralprocessField(name="支用金额",type="text")
	private  String  SUPPORT_MONEY;
	
	@GeneralprocessField(name="是否风险额度重检",type="dic",dicname="PROCESS_QuotaCheck")
	private String RISK;
	
	@GeneralprocessField(name="处理意见",type="text")
	private String PROCESSING_OPINION;

	public String getFlow_id() {
		return flow_id;
	}

	public void setFlow_id(String flow_id) {
		this.flow_id = flow_id;
	}

	public String getMORTGAGE_TIME() {
		return MORTGAGE_TIME;
	}

	public void setMORTGAGE_TIME(String mORTGAGE_TIME) {
		MORTGAGE_TIME = mORTGAGE_TIME;
	}

	public String getRECEIVE_TIME() {
		return RECEIVE_TIME;
	}

	public void setRECEIVE_TIME(String rECEIVE_TIME) {
		RECEIVE_TIME = rECEIVE_TIME;
	}

	public String getAPPLICATION_TIME() {
		return APPLICATION_TIME;
	}

	public void setAPPLICATION_TIME(String aPPLICATION_TIME) {
		APPLICATION_TIME = aPPLICATION_TIME;
	}

	public String getISSUED_TIME() {
		return ISSUED_TIME;
	}

	public void setISSUED_TIME(String iSSUED_TIME) {
		ISSUED_TIME = iSSUED_TIME;
	}

	public String getSUPPORT_CATEGORY() {
		return SUPPORT_CATEGORY;
	}

	public void setSUPPORT_CATEGORY(String sUPPORT_CATEGORY) {
		SUPPORT_CATEGORY = sUPPORT_CATEGORY;
	}

	public String getSUPPORT_MONEY() {
		return SUPPORT_MONEY;
	}

	public void setSUPPORT_MONEY(String sUPPORT_MONEY) {
		SUPPORT_MONEY = sUPPORT_MONEY;
	}

	public String getRISK() {
		return RISK;
	}

	public void setRISK(String rISK) {
		RISK = rISK;
	}

	public String getPROCESSING_OPINION() {
		return PROCESSING_OPINION;
	}

	public void setPROCESSING_OPINION(String pROCESSING_OPINION) {
		PROCESSING_OPINION = pROCESSING_OPINION;
	}
	
	
	
	
	

}
