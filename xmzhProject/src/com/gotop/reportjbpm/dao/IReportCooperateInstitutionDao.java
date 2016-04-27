package com.gotop.reportjbpm.dao;

import java.util.List;
import java.util.Map;

import com.gotop.reportjbpm.model.ReportCooperateInstitution;
import com.primeton.utils.Page;

public interface IReportCooperateInstitutionDao {
	public List<ReportCooperateInstitution> selectReportCooperateInstitution(Map<String, Object> map,
			Page page) ;
	public List<ReportCooperateInstitution> selectReportCooperateInstitutionFoeExcl(Map<String, Object> map) ;
	
}
