package com.gotop.Generalprocess.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class TGeneralprocessModelfour implements Serializable {
    /**
     * 模式四主键 .
     * @abatorgenerated
     */
    private BigDecimal processmodelid;

    /**
     * 流程业务的  id .
     * @abatorgenerated
     */
    private String flowId;

    /**
     * 处理意见 .
     * @abatorgenerated
     */
    private String opninionContent;

    /**
     * 节点名称 .
     * @abatorgenerated
     */
    private String taskname;

    /**
     * 模式四主键 .
     * @abatorgenerated
     */
    public BigDecimal getProcessmodelid() {
        return processmodelid;
    }

    /**
     * 模式四主键 .
     * @abatorgenerated
     */
    public void setProcessmodelid(BigDecimal processmodelid) {
        this.processmodelid = processmodelid;
    }

    /**
     * 流程业务的  id .
     * @abatorgenerated
     */
    public String getFlowId() {
        return flowId;
    }

    /**
     * 流程业务的  id .
     * @abatorgenerated
     */
    public void setFlowId(String flowId) {
        this.flowId = flowId;
    }

    /**
     * 处理意见 .
     * @abatorgenerated
     */
    public String getOpninionContent() {
        return opninionContent;
    }

    /**
     * 处理意见 .
     * @abatorgenerated
     */
    public void setOpninionContent(String opninionContent) {
        this.opninionContent = opninionContent;
    }

    /**
     * 节点名称 .
     * @abatorgenerated
     */
    public String getTaskname() {
        return taskname;
    }

    /**
     * 节点名称 .
     * @abatorgenerated
     */
    public void setTaskname(String taskname) {
        this.taskname = taskname;
    }
}