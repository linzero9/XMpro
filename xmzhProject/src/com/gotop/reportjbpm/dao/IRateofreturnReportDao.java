/**
 * 
 */
package com.gotop.reportjbpm.dao;

import java.util.List;
import java.util.Map;

import com.primeton.utils.Page;

/**
 * @author gotop
 *
 */
public interface IRateofreturnReportDao {
	
	/**
	 * 查询退单率
	 * @param map
	 * @param page
	 * @return
	 */
	List rateofreturnReportList(Map<String, Object> map, Page page);
	
	/**
	 * 查询退单率合计
	 * @param map
	 * @param page
	 * @return
	 */
	List rateofreturnReportListSum(Map<String, Object> map);
	
	/**
	 * 导出excel
	 * @param map
	 * @param page
	 * @return
	 */
    List rateofreturnReportListExcel(Map<String, Object> map);

}
