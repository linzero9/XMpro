package com.gotop.reportjbpm.dao.impl;

import java.util.List;
import java.util.Map;
import com.gotop.reportjbpm.dao.IProcessUsedTimeReportDao;
import com.gotop.reportjbpm.model.ProcessUsedTimeReport;
import com.gotop.util.dataSource.SqlMapClientDao;
import com.primeton.utils.Page;

public class ProcessUsedTimeReportDao extends SqlMapClientDao implements IProcessUsedTimeReportDao {

	@Override
	public List<ProcessUsedTimeReport> queryProcessUsedTimeReportList(Map<String, Object> map, Page page) {
		return this.queryForList("T_PROCESSUSEDTIMEREPORT_SqlMap.queryProcessUsedTimeReportList", map,page);
	}

	@Override
	public List<ProcessUsedTimeReport> queryProcessUsedTimeReportListForExcel(Map<String, Object> map) {
		return this.queryForList("T_APPROVAL_SqlMap.queryApprovalList", map);
	}

}
