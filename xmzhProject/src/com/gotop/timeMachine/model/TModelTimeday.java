package com.gotop.timeMachine.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class TModelTimeday implements Serializable {
    /**
     * 主键 .
     * @abatorgenerated
     */
    private BigDecimal id;

    /**
     * 时间(年月日) .
     * @abatorgenerated
     */
    private String time;

    /**
     * 添加的所属机构 .
     * @abatorgenerated
     */
    private String orgcode;

    /**
     * 添加的人员 .
     * @abatorgenerated
     */
    private String role;

    /**
     * 是否在用 .
     * @abatorgenerated
     */
    private String status;

    /**
     * 主键 .
     * @abatorgenerated
     */
    public BigDecimal getId() {
        return id;
    }

    /**
     * 主键 .
     * @abatorgenerated
     */
    public void setId(BigDecimal id) {
        this.id = id;
    }

    /**
     * 时间(年月日) .
     * @abatorgenerated
     */
    public String getTime() {
        return time;
    }

    /**
     * 时间(年月日) .
     * @abatorgenerated
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * 添加的所属机构 .
     * @abatorgenerated
     */
    public String getOrgcode() {
        return orgcode;
    }

    /**
     * 添加的所属机构 .
     * @abatorgenerated
     */
    public void setOrgcode(String orgcode) {
        this.orgcode = orgcode;
    }

    /**
     * 添加的人员 .
     * @abatorgenerated
     */
    public String getRole() {
        return role;
    }

    /**
     * 添加的人员 .
     * @abatorgenerated
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * 是否在用 .
     * @abatorgenerated
     */
    public String getStatus() {
        return status;
    }

    /**
     * 是否在用 .
     * @abatorgenerated
     */
    public void setStatus(String status) {
        this.status = status;
    }
}