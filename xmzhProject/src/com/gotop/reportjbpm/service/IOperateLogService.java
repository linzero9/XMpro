package com.gotop.reportjbpm.service;

import java.util.List;

import com.gotop.reportjbpm.model.JobWorkload;
import com.gotop.reportjbpm.model.OperateLog;
import com.primeton.utils.Page;

public interface IOperateLogService {
	/**
	 * 操作日志导出查询
	 * @param operateLog
	 * @param page
	 * @return
	 */
	List<OperateLog> queryOperateLog(OperateLog operateLog, Page page);
	/**
	 * 操作日志导出功能导出excel
	 * @return
	 */
	List<OperateLog> queryOperateLogForExcel(OperateLog operateLog);
	
	/**
	 * 流程节点查询
	 */
	
	List<OperateLog> listNodName();

}
