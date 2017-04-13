package com.gotop.reportjbpm.dao;

import java.util.List;
import java.util.Map;
import com.gotop.reportjbpm.model.TimeLimitConditionReport;
import com.primeton.utils.Page;

public interface ITimeLimitConditionReportDao {
/**
 * 时限情况统计报表
 * @param map
 * @param page
 * @return
 */
	List<TimeLimitConditionReport> queryTimeLimitConditionReportList(Map<String, Object> map, Page page);
	/**
	 * 时限情况统计报表导出Excel
	 * @param map
	 * @param page
	 * @return
	 */
	List<TimeLimitConditionReport> queryTimeLimitConditionReportListForExcel(Map<String, Object> map);

}
