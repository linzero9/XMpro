package com.gotop.timeMachine.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class TModelTimeday implements Serializable {
    /**
     * 主键 .
     * @abatorgenerated
     */
    private Long id;

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
    private Long empid;

    /**
     * 是否在用 .
     * @abatorgenerated
     */
    private String status;
    
    private  String  type;
    
    private String remark;
    
    private String orgname;
    
    private String empname;
    
    private String startDate; //开始日期，给页面查询项用
    
    private String endDate; //结束日期，给页面查询项用
    
    
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

   

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public Long getEmpid() {
		return empid;
	}

	public void setEmpid(Long empid) {
		this.empid = empid;
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

	public String getOrgname() {
		return orgname;
	}

	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
    
    
}