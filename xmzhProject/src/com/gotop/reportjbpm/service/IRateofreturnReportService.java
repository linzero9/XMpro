/**
 * 
 */
package com.gotop.reportjbpm.service;

import java.util.List;
import java.util.Map;

import com.gotop.reportjbpm.dao.IRateofreturnReportDao;
import com.gotop.reportjbpm.model.RateofreturnReport;
import com.primeton.utils.Page;

/**
 * @author gotop
 *
 */
public interface IRateofreturnReportService {
 
	IRateofreturnReportDao getIRefusalrateReportDao();
	
	void setRateofreturnReportDao(IRateofreturnReportDao rateofreturnReportDao);
	
	/**
	 * 退单率查询
	 * @param refusalrateReport
	 * @param page
	 * @return
	 */
	List<RateofreturnReport> rateofreturnReportList(RateofreturnReport rateofreturnReport,Page page);
	
	/**
	 * 导出Excel
	 * @param rateofreturnReport
	 * @param page
	 * @return
	 */
	List<RateofreturnReport> rateofreturnReportListExcel(RateofreturnReport rateofreturnReport);
}
