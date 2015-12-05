package com.gotop.Generalprocess.model;

import java.io.Serializable;

public class TGeneralprocessMain implements Serializable {
    /**
     * 主键 .
     * @abatorgenerated
     */
    private Long mainid;

    /**
     * 模板id（这个业务属于哪个流程模板） .
     * @abatorgenerated
     */
    private String templateId;

    /**
     * 规则，用来存储哪些实体类！！ .
     * @abatorgenerated
     */
    private String rules;

    /**
     * null .
     * @abatorgenerated
     */
    private String name;

    /**
     * 业务流程id .
     * @abatorgenerated
     */
    private String businessId;
    
    /**
     * 各个业务主键
     */
    private String ids;
    
    /**
     * 起草人empid
     */
    private Long beginEmpId;
    
    /**
     * 起草人所属机构orgid
     */
    private Long beginOrgId;

    /**
     * 规则，用来存储哪些实体类！！ .
     * @abatorgenerated
     */
    public String getRules() {
        return rules;
    }

    /**
     * 规则，用来存储哪些实体类！！ .
     * @abatorgenerated
     */
    public void setRules(String rules) {
        this.rules = rules;
    }

    /**
     * null .
     * @abatorgenerated
     */
    public String getName() {
        return name;
    }

    /**
     * null .
     * @abatorgenerated
     */
    public void setName(String name) {
        this.name = name;
    }

	public Long getMainid() {
		return mainid;
	}

	public void setMainid(Long mainid) {
		this.mainid = mainid;
	}

	public String getTemplateId() {
		return templateId;
	}

	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}

	public String getBusinessId() {
		return businessId;
	}

	public void setBusinessId(String businessId) {
		this.businessId = businessId;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public Long getBeginEmpId() {
		return beginEmpId;
	}

	public void setBeginEmpId(Long beginEmpId) {
		this.beginEmpId = beginEmpId;
	}

	public Long getBeginOrgId() {
		return beginOrgId;
	}

	public void setBeginOrgId(Long beginOrgId) {
		this.beginOrgId = beginOrgId;
	}

}