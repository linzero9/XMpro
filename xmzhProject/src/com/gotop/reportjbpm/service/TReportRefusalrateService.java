package com.gotop.reportjbpm.service;

import java.util.List;

import com.gotop.reportjbpm.dao.TReportRefusalrateDao;
import com.gotop.reportjbpm.model.ReportRefusalrate;
import com.primeton.utils.Page;

public interface TReportRefusalrateService {
	
	
	 TReportRefusalrateDao getReportRefusalrateDao();
	
	void setReportRefusalrateDao( TReportRefusalrateDao reportRefusalrateDao);
	
	List<ReportRefusalrate> selectReportRefusalRate(ReportRefusalrate reportRefusalrate,Page page);

}
