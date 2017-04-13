package com.gotop.reportjbpm.service.impl;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.gotop.reportjbpm.dao.ISxApprovalReportDao;
import com.gotop.reportjbpm.model.SxApprovalReport;
import com.gotop.reportjbpm.service.ISxApprovalReportService;
import com.primeton.utils.Page;

public class SxApprovalReportService implements ISxApprovalReportService  {

	public ISxApprovalReportDao getSxApprovalReportDao() {
		return sxApprovalReportDao;
	}

	public void setSxApprovalReportDao(ISxApprovalReportDao sxApprovalReportDao) {
		this.sxApprovalReportDao = sxApprovalReportDao;
	}

	private ISxApprovalReportDao sxApprovalReportDao;
	@Override
	public List<SxApprovalReport> querySxApprovalReportList(
			SxApprovalReport sxApprovalReport, Page page) {
		List<SxApprovalReport> sxApprovalReportList =new ArrayList<SxApprovalReport>();
		Map<String, Object>map=new HashMap<String, Object>();
		sxApprovalReportList=sxApprovalReportDao.querySxApprovalReportList(map, page);
		return sxApprovalReportList;
	}

	@Override
	public List<SxApprovalReport> querySxApprovalReportListForExcel(
			SxApprovalReport sxApprovalReport) {
		return null;
	}

	@Override
	public List<SxApprovalReport> querySxApprovalReportTitleList(
			SxApprovalReport sxApprovalReport) {
		 List<SxApprovalReport> sxApprovalReportTitleList =new ArrayList<SxApprovalReport>();
		 Map<String, Object>map=new HashMap<String, Object>();
		 sxApprovalReportTitleList=sxApprovalReportDao.querySxApprovalReportTitleList(map);
		return sxApprovalReportTitleList;
	}

	@Override
	public List<SxApprovalReport> querySxApprovalReportOrgNameOneList(
			SxApprovalReport sxApprovalReport, Page page) {
		List<SxApprovalReport> sxApprovalReportOrgNameOneList =new ArrayList<SxApprovalReport>();
		Map<String, Object>map=new HashMap<String, Object>();
		sxApprovalReportOrgNameOneList=sxApprovalReportDao.querySxApprovalReportOrgNameOneList(map, page);
		return sxApprovalReportOrgNameOneList;
	}

	

}
