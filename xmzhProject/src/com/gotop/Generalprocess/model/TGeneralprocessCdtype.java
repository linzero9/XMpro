package com.gotop.Generalprocess.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class TGeneralprocessCdtype implements Serializable {
    /**
     * 模式2主键 .
     * @abatorgenerated
     */
    private BigDecimal cdtypeid;

    /**
     * 流程名称 .
     * @abatorgenerated
     */
    private String processName;

    /**
     * 一级分类 .
     * @abatorgenerated
     */
    private String firstClass;

    /**
     * 贷种分类 .
     * @abatorgenerated
     */
    private String creditType;

    /**
     * 时限参数列表 .
     * @abatorgenerated
     */
    private String limitTime;

    /**
     * 模式2主键 .
     * @abatorgenerated
     */
    public BigDecimal getCdtypeid() {
        return cdtypeid;
    }

    /**
     * 模式2主键 .
     * @abatorgenerated
     */
    public void setCdtypeid(BigDecimal cdtypeid) {
        this.cdtypeid = cdtypeid;
    }

    /**
     * 流程名称 .
     * @abatorgenerated
     */
    public String getProcessName() {
        return processName;
    }

    /**
     * 流程名称 .
     * @abatorgenerated
     */
    public void setProcessName(String processName) {
        this.processName = processName;
    }

    /**
     * 一级分类 .
     * @abatorgenerated
     */
    public String getFirstClass() {
        return firstClass;
    }

    /**
     * 一级分类 .
     * @abatorgenerated
     */
    public void setFirstClass(String firstClass) {
        this.firstClass = firstClass;
    }

    /**
     * 贷种分类 .
     * @abatorgenerated
     */
    public String getCreditType() {
        return creditType;
    }

    /**
     * 贷种分类 .
     * @abatorgenerated
     */
    public void setCreditType(String creditType) {
        this.creditType = creditType;
    }

    /**
     * 时限参数列表 .
     * @abatorgenerated
     */
    public String getLimitTime() {
        return limitTime;
    }

    /**
     * 时限参数列表 .
     * @abatorgenerated
     */
    public void setLimitTime(String limitTime) {
        this.limitTime = limitTime;
    }
}