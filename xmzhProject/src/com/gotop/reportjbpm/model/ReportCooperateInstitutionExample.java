package com.gotop.reportjbpm.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.gotop.Generalprocess.model.TGeneralprocessModeloneExample;



public class ReportCooperateInstitutionExample {
	 /**
     * 
     * @abatorgenerated
     */
    protected Logger log = Logger.getLogger(ReportCooperateInstitutionExample.class);

    /**
     * 排序字段.
     * @abatorgenerated
     */
    protected String orderByClause;

    /**
     * sql条件.
     * @abatorgenerated
     */
    protected List oredCriteria;

    /**
     * 分页查询的起始行数.
     * @abatorgenerated
     */
    private Integer oracleStart;

    /**
     * 分页查询结束行数.
     * @abatorgenerated
     */
    private Integer oracleEnd;

    /** * @abatorgenerated  */
    public ReportCooperateInstitutionExample() {
        oredCriteria = new ArrayList();
    }

	public ReportCooperateInstitutionExample(ReportCooperateInstitutionExample example) {
		this.orderByClause = example.orderByClause;
        this.oredCriteria = example.oredCriteria;
        this.oracleStart = example.oracleStart;
        this.oracleEnd = example.oracleEnd;
	}
    
}
