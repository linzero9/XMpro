package com.gotop.reportjbpm.dao.impl;

import java.util.List;
import java.util.Map;

import com.gotop.reportjbpm.dao.TReportRefusalrateDao;
import com.gotop.reportjbpm.model.ReportRefusalrate;
import com.gotop.util.dataSource.SqlMapClientDao;
import com.primeton.utils.Page;

public class ReportRefusalrateDao extends SqlMapClientDao implements TReportRefusalrateDao {

	

	

	@Override
	public List<ReportRefusalrate> selectReportRefusalRate(Map<String, Object> map,
			Page page) {
		return queryForList("T_OMINFORMATION_SqlMap.queryReportRefusalRate", map, page);
	}

}
