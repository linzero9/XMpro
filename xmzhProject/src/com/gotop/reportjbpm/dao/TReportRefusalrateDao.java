package com.gotop.reportjbpm.dao;

import java.util.List;
import java.util.Map;

import com.gotop.reportjbpm.model.ReportRefusalrate;
import com.primeton.utils.Page;

public interface TReportRefusalrateDao {

	List<ReportRefusalrate> selectReportRefusalRate(Map<String, Object> map,Page page);
	List<ReportRefusalrate> queryReportRefusalrateForExcel(Map<String, Object> map);
	
	
	List<ReportRefusalrate> queryOneCategoryList();
	List<ReportRefusalrate> queryLoanCategoryList();
}
