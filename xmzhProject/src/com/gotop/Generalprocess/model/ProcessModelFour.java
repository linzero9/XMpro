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
     * 处理意见 .
     * @abatorgenerated
     */
	@GeneralprocessField(name="处理意见",type="text")
    private String opninionContent;


	@GeneralprocessField(name="整改情况",type="text")
	private String rectification;
	
	
	@GeneralprocessField(name="差错情况",type="misTakeType")
	private String misTakeType;

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
