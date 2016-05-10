package com.gotop.Generalprocess.model;

import java.io.Serializable;

import com.gotop.Generalprocess.annonation.GeneralprocessField;

public class ProcessModelFour extends ProcessModel  implements  Serializable{

	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 流程业务的  id .
     * @abatorgenerated
     */
	@GeneralprocessField(name="流程业务id",type="text",hidden=false)
    private String flowId;
	/**
	 * 是否电话核实.
	 * @abatorgenerated
	 */
	@GeneralprocessField(name="是否电话核实",type="text",hidden=false)
	private String dhhs;
	/**
	 * 终审币别.
	 * @abatorgenerated
	 */
	@GeneralprocessField(name="终审币别",type="text",hidden=false)
	private String zscurrency;
	/**
	 * 终审金额 .
	 * @abatorgenerated
	 */
	@GeneralprocessField(name="终审金额",type="text",hidden=false)
	private String zsmoney;

    /**
     * 处理意见 .
     * @abatorgenerated
     */
	@GeneralprocessField(name="处理意见",type="text")
    private String opninionContent;


	@GeneralprocessField(name="整改情况",type="text")
	private String rectification;
	
	
	@GeneralprocessField(name="差错情况",type="misTakeType")
	private String misTakeType;
	
	@GeneralprocessField(name="附件下载",type="fileCont")
	private String fileCont;
	

	public String getFileCont() {
		return fileCont;
	}

	public void setFileCont(String fileCont) {
		this.fileCont =flowId+","+fileCont+",mod4";
	}

	public String getDhhs() {
		return dhhs;
	}

	public void setDhhs(String dhhs) {
		this.dhhs = dhhs;
	}

	public String getZscurrency() {
		return zscurrency;
	}

	public void setZscurrency(String zscurrency) {
		this.zscurrency = zscurrency;
	}

	public String getZsmoney() {
		return zsmoney;
	}

	public void setZsmoney(String zsmoney) {
		this.zsmoney = zsmoney;
	}

	public String getMisTakeType() {
		return misTakeType;
	}

	public void setMisTakeType(String misTakeType) {
		this.misTakeType = misTakeType;
	}

	public String getRectification() {
		return rectification;
	}

	public void setRectification(String rectification) {
		this.rectification = rectification;
	}
	
	public String getFlowId() {
		return flowId;
	}

	public void setFlowId(String flowId) {
		this.flowId = flowId;
	}

	public String getOpninionContent() {
		return opninionContent;
	}

	public void setOpninionContent(String opninionContent) {
		this.opninionContent = opninionContent;
	}
	
}
