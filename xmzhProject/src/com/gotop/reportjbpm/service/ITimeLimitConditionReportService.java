package com.gotop.reportjbpm.service;

import java.util.List;
import com.gotop.reportjbpm.model.TimeLimitConditionReport;
import com.primeton.utils.Page;

public interface ITimeLimitConditionReportService {
	/**
	 * 时限情况统计报表
	 * @param approval
	 * @param page
	 * @return
	 */
	List<TimeLimitConditionReport> queryTimeLimitConditionReportList(TimeLimitConditionReport timeLimitConditionReport, Page page);
	/**
	 * 时限情况统计报表导出excel
	 * @param approval
	 * @param page
	 * @return
	 */
	List<TimeLimitConditionReport> queryTimeLimitConditionReportListForExcel(TimeLimitConditionReport timeLimitConditionReport);
	
	

}
