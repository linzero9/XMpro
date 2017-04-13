package com.gotop.reportjbpm.service.impl;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.gotop.reportjbpm.dao.IProcessUsedTimeReportDao;
import com.gotop.reportjbpm.model.ProcessUsedTimeReport;
import com.gotop.reportjbpm.service.IProcessUsedTimeReportService;
import com.primeton.utils.Page;

public class ProcessUsedTimeReportService implements IProcessUsedTimeReportService {

	private IProcessUsedTimeReportDao processUsedTimeReportDao;
	public IProcessUsedTimeReportDao getProcessUsedTimeReportDao() {
		return processUsedTimeReportDao;
	}

	public void setProcessUsedTimeReportDao(
			IProcessUsedTimeReportDao processUsedTimeReportDao) {
		this.processUsedTimeReportDao = processUsedTimeReportDao;
	}

	@Override
	public List<ProcessUsedTimeReport> queryProcessUsedTimeReportList(
			ProcessUsedTimeReport processUsedTimeReport, Page page) {
	    List<ProcessUsedTimeReport> processUsedTimeReportList =new ArrayList<ProcessUsedTimeReport>();
		Map<String, Object>map=new HashMap<String, Object>();
	    processUsedTimeReportList=processUsedTimeReportDao.queryProcessUsedTimeReportList(map, page);
		return processUsedTimeReportList;
	}

	@Override
	public List<ProcessUsedTimeReport> queryProcessUsedTimeReportListForExcel(
			ProcessUsedTimeReport processUsedTimeReport) {
		return null;
	}

}
