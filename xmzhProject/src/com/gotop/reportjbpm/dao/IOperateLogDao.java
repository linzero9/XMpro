package com.gotop.reportjbpm.dao;

import java.util.List;
import java.util.Map;

import com.gotop.reportjbpm.model.OperateLog;
import com.primeton.utils.Page;

public interface IOperateLogDao {
	/**
	 * 操作日志导出查询
	 * @param map
	 * @param page
	 * @return
	 */
	List<OperateLog> queryOperateLog(Map<String, Object> map, Page page);
	/**
	 * 操作日志导出功能导出excel
	 * @param map
	 * @param page
	 * @return
	 */
	List<OperateLog> queryOperateLogForExcel(Map<String, Object> map);

}
