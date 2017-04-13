package com.gotop.reportjbpm.service.impl;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.gotop.reportjbpm.dao.ITimeLimitConditionReportDao;
import com.gotop.reportjbpm.model.TimeLimitConditionReport;
import com.gotop.reportjbpm.service.ITimeLimitConditionReportService;
import com.primeton.utils.Page;

public class TimeLimitConditionReportService implements ITimeLimitConditionReportService  {

	private ITimeLimitConditionReportDao timeLimitConditionReportDao;
	

	public ITimeLimitConditionReportDao getTimeLimitConditionReportDao() {
		return timeLimitConditionReportDao;
	}

	public void setTimeLimitConditionReportDao(
			ITimeLimitConditionReportDao timeLimitConditionReportDao) {
		this.timeLimitConditionReportDao = timeLimitConditionReportDao;
	}

	@Override
	public List<TimeLimitConditionReport> queryTimeLimitConditionReportList(
			TimeLimitConditionReport timeLimitConditionReport, Page page) {
	    List<TimeLimitConditionReport> timeLimitConditionReportList =new ArrayList<TimeLimitConditionReport>();
		Map<String, Object>map=new HashMap<String, Object>();
		timeLimitConditionReportList=timeLimitConditionReportDao.queryTimeLimitConditionReportList(map, page);
		return timeLimitConditionReportList;
	}

	@Override
	public List<TimeLimitConditionReport> queryTimeLimitConditionReportListForExcel(
			TimeLimitConditionReport timeLimitConditionReport) {
		return null;
	}


}
