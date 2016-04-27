package com.gotop.reportjbpm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gotop.Generalprocess.model.TGeneralprocessModelone;
import com.gotop.Generalprocess.model.TGeneralprocessModeloneExample;
import com.gotop.reportjbpm.dao.IReportCooperateInstitutionDao;

import com.gotop.reportjbpm.model.ReportCooperateInstitution;

import com.gotop.reportjbpm.service.IReportCooperateInstitutionService;

import com.primeton.utils.Page;

public class ReportCooperateInstitutionService implements IReportCooperateInstitutionService{

	private IReportCooperateInstitutionDao reportCooperateInstitutionDao;
	public void setReportCooperateInstitutionDao(
			IReportCooperateInstitutionDao reportCooperateInstitutionDao) {
		this.reportCooperateInstitutionDao = reportCooperateInstitutionDao;
	}
	
	
	
	
	@Override
public List<ReportCooperateInstitution> selectReportCooperateInstitution(ReportCooperateInstitution reportCooperateInstitution, Page page) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		if (reportCooperateInstitution != null) {
			if (reportCooperateInstitution.getAppTimeStrat() !=null&&!"".equals(reportCooperateInstitution.getAppTimeStrat())) {
				
				String aa=reportCooperateInstitution.getAppTimeStrat();
				map.put("appTimeStrat", reportCooperateInstitution.getAppTimeStrat());
			}
			if (reportCooperateInstitution.getAppTimeEnd() != null&&!"".equals(reportCooperateInstitution.getAppTimeEnd())) {
				String bb=reportCooperateInstitution.getAppTimeEnd();
				map.put("appTimeEnd", reportCooperateInstitution.getAppTimeEnd());
			}
	
		}
		
		return reportCooperateInstitutionDao.selectReportCooperateInstitution(map, page);
	}
	
	@Override
	public List<ReportCooperateInstitution> selectReportCooperateInstitutionForExcl(ReportCooperateInstitution reportCooperateInstitution) {
			
			Map<String, Object> map = new HashMap<String, Object>();
			if (reportCooperateInstitution != null) {
				if (reportCooperateInstitution.getAppTimeStrat() !=null&&!"".equals(reportCooperateInstitution.getAppTimeStrat())) {
					
					String aa=reportCooperateInstitution.getAppTimeStrat();
					map.put("appTimeStrat", reportCooperateInstitution.getAppTimeStrat());
				}
				if (reportCooperateInstitution.getAppTimeEnd() != null&&!"".equals(reportCooperateInstitution.getAppTimeEnd())) {
					String bb=reportCooperateInstitution.getAppTimeEnd();
					map.put("appTimeEnd", reportCooperateInstitution.getAppTimeEnd());
				}
		
			}
			
			return reportCooperateInstitutionDao.selectReportCooperateInstitutionFoeExcl(map);
		}

}
