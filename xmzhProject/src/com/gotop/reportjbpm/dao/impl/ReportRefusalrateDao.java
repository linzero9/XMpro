package com.gotop.reportjbpm.dao.impl;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import org.apache.log4j.Logger;

import com.gotop.reportjbpm.dao.TReportRefusalrateDao;
import com.gotop.reportjbpm.model.ReportRefusalrate;
import com.gotop.util.dataSource.SqlMapClientDao;
import com.primeton.utils.Page;

public class ReportRefusalrateDao extends SqlMapClientDao implements TReportRefusalrateDao {

	
	protected Logger log = Logger.getLogger(ReportRefusalrateDao.class);

	public ReportRefusalrateDao() {
		super();
		// TODO 自动生成的构造函数存根
	}
	

	@Override
	public List<ReportRefusalrate> selectReportRefusalRate(Map<String, Object> map,
			Page page) {
		return queryForList("T_REPORTREFUSALRATE_SqlMap.queryReportRefusalRate", map, page);
	}
	@Override
	public List<ReportRefusalrate> queryReportRefusalrateForExcel(
			Map<String, Object> map) {
		return queryForList("T_ERRORSTATISTIC_SqlMap.queryReportRefusalrate",map);
	}
	
	
	
	
	
	
	@Override
	public List<ReportRefusalrate> queryOneCategoryList() {
		return queryForList("T_REPORTREFUSALRATE_SqlMap.queryOneCategoryList", new HashMap());
	}
	@Override
	public List<ReportRefusalrate> queryLoanCategoryList() {
		return queryForList("T_REPORTREFUSALRATE_SqlMap.queryOneCategoryList", new HashMap());
	}

}
