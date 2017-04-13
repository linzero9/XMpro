package com.gotop.reportjbpm.dao.impl;

import java.util.List;
import java.util.Map;

import com.gotop.reportjbpm.dao.ISxApprovalReportDao;
import com.gotop.reportjbpm.model.SxApprovalReport;
import com.gotop.util.dataSource.SqlMapClientDao;
import com.primeton.utils.Page;

public class SxApprovalReportDao extends SqlMapClientDao implements ISxApprovalReportDao {

	@Override
	public List<SxApprovalReport> querySxApprovalReportList(
			Map<String, Object> map, Page page) {
		return this.queryForList("T_SXAPPROVALREPORT_SqlMap.querySxApprovalReportList", map,page);
	}

	@Override
	public List<SxApprovalReport> querySxApprovalReportListForExcel(
			Map<String, Object> map) {
		return this.queryForList("T_APPROVAL_SqlMap.queryApprovalList", map);
	}

	@Override
	public List<SxApprovalReport> querySxApprovalReportTitleList(
			Map<String, Object> map) {
		// TODO Auto-generated method stub
		return this.queryForList("T_SXAPPROVALREPORT_SqlMap.querySxApprovalReportTitleList", map);
	}

	@Override
	public List<SxApprovalReport> querySxApprovalReportOrgNameOneList(
			Map<String, Object> map, Page page) {
		return this.queryForList("T_SXAPPROVALREPORT_SqlMap.querySxApprovalReportOrgNameOneList", map,page);
	}

	

}
