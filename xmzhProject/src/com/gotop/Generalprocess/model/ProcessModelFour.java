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
