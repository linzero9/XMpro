package com.gotop.reportjbpm.service;

import java.util.List;
import com.gotop.reportjbpm.model.ProcessUsedTimeReport;
import com.primeton.utils.Page;

public interface IProcessUsedTimeReportService {
	/**
	 * 流程用时统计报表
	 * @param approval
	 * @param page
	 * @return
	 */
	List<ProcessUsedTimeReport> queryProcessUsedTimeReportList(ProcessUsedTimeReport processUsedTimeReport, Page page);
	/**
	 * 流程用时统计报表导出excel
	 * @param approval
	 * @param page
	 * @return
	 */
	List<ProcessUsedTimeReport> queryProcessUsedTimeReportListForExcel(ProcessUsedTimeReport processUsedTimeReport);
	
	

}
