package com.gotop.reportjbpm.service;

import java.util.List;

import com.gotop.reportjbpm.model.ReportCooperateInstitution;
import com.primeton.utils.Page;

public interface IReportCooperateInstitutionService {
	public List<ReportCooperateInstitution> selectReportCooperateInstitution(ReportCooperateInstitution reportCooperateInstitution, Page page);
	public List<ReportCooperateInstitution> selectReportCooperateInstitutionForExcl(ReportCooperateInstitution reportCooperateInstitution);
	
}
