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
public interface IJobWorkloadDao {
	
	/**
	 * 查询岗位统计量
	 * @param map
	 * @param page
	 * @return
	 */
	List jobWorkloadtList(Map<String, Object> map, Page page);
	
	/**
	 * 导出excel
	 * @param map
	 * @param page
	 * @return
	 */
    List JobWorkloadListExcel(Map<String, Object> map);

}
