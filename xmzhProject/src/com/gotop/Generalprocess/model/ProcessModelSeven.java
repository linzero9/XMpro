package com.gotop.Generalprocess.model;

import java.io.Serializable;

import com.gotop.Generalprocess.annonation.GeneralprocessField;

public class ProcessModelSeven extends ProcessModel implements Serializable{

    /**
     * 流程实例id .
     * @abatorgenerated
     */
	@GeneralprocessField(name="流程业务id",type="text",hidden=false)
    private String flowId;

    /**
     * 处理意见,01-同意,02-有条件同意,03-退回,04-拒绝 .
     * @abatorgenerated
     */
	@GeneralprocessField(name="审批意见",type="dic",dicname="PROCESS_opn")
    private String handleOpn;

    /**
     * 审批币别 .
     * @abatorgenerated
     */
	@GeneralprocessField(name="审批币别",type="dic",dicname="PROCESS_MONEY")
    private String spBb;

    /**
     * 审批金额 .
     * @abatorgenerated
     */
    @GeneralprocessField(name="审批金额",type="money")
    private String spJe;
    
    
    
    
    
    @GeneralprocessField(name="处理意见",type="text")
    private String optionNews;
    
    
    

    public String getOptionNews() {
		return optionNews;
	}

	public void setOptionNews(String optionNews) {
		this.optionNews = optionNews;
	}

	/**
     * 流程实例id .
     * @abatorgenerated
     */
    public String getFlowId() {
        return flowId;
    }

    /**
     * 流程实例id .
     * @abatorgenerated
     */
    public void setFlowId(String flowId) {
        this.flowId = flowId;
    }

    /**
     * 处理意见,01-同意,02-有条件同意,03-退回,04-拒绝 .
     * @abatorgenerated
     */
    public String getHandleOpn() {
        return handleOpn;
    }

    /**
     * 处理意见,01-同意,02-有条件同意,03-退回,04-拒绝 .
     * @abatorgenerated
     */
    public void setHandleOpn(String handleOpn) {
        this.handleOpn = handleOpn;
    }

    /**
     * 审批币别 .
     * @abatorgenerated
     */
    public String getSpBb() {
        return spBb;
    }

    /**
     * 审批币别 .
     * @abatorgenerated
     */
    public void setSpBb(String spBb) {
        this.spBb = spBb;
    }

    /**
     * 审批金额 .
     * @abatorgenerated
     */
    public String getSpJe() {
        return spJe;
    }

    /**
     * 审批金额 .
     * @abatorgenerated
     */
    public void setSpJe(String spJe) {
        this.spJe = spJe;
    }
}
