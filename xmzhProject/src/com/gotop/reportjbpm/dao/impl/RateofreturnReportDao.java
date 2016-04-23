package com.gotop.reportjbpm.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.gotop.reportjbpm.dao.IRateofreturnReportDao;
import com.gotop.util.dataSource.SqlMapClientDao;
import com.primeton.utils.Page;

public class RateofreturnReportDao extends SqlMapClientDao implements IRateofreturnReportDao {
	protected Logger log = Logger.getLogger(RateofreturnReportDao.class);
	
	public RateofreturnReportDao(){
		super();
	}
	
	/**
	 * 退单率查询
	 */

	@Override
	public List rateofreturnReportList(Map<String, Object> map, Page page) {

		List  list=queryForList("T_RateofreturnReport_SqlMap.RateofreturnReportList", map,page);

		return list;
	}
/**
 * 导出excel
 */
	@Override
	public List rateofreturnReportListExcel(Map<String, Object> map) {

			return queryForList("T_RateofreturnReport_SqlMap.RateofreturnReportList", map);
	}
	
}
