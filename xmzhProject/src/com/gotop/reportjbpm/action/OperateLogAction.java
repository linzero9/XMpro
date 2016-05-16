package com.gotop.reportjbpm.action;

import java.util.ArrayList;
import java.util.List;

import com.gotop.crm.util.BaseAction;
import com.gotop.reportjbpm.model.OperateLog;
import com.gotop.reportjbpm.service.IOperateLogService;

public class OperateLogAction extends BaseAction {
	
	private IOperateLogService operateLogService;
	private OperateLog operateLog;
	private List<OperateLog>operateLogList=new ArrayList<OperateLog>();
	
	public OperateLog getOperateLog() {
		return operateLog;
	}

	public void setOperateLog(OperateLog operateLog) {
		this.operateLog = operateLog;
	}

	public List<OperateLog> getOperateLogList() {
		return operateLogList;
	}

	public void setOperateLogList(List<OperateLog> operateLogList) {
		this.operateLogList = operateLogList;
	}

	public IOperateLogService getOperateLogService() {
		return operateLogService;
	}

	public void setOperateLogService(IOperateLogService operateLogService) {
		this.operateLogService = operateLogService;
	}
	/**
	 * 操作日志导出查询
	 * @return
	 */
	public String queryOperateLog(){
		operateLogList=operateLogService.queryOperateLog(operateLog,this.getPage());
		this.setPage(page);
		this.setOperateLogList(operateLogList);
		return"queryOperateLog";
	}
	/**
	 * 操作日志导出功能导出excel
	 * @return
	 */
	public String queryOperateLogForExcel(){
		operateLogList=operateLogService.queryOperateLogForExcel(operateLog);
		this.setOperateLogList(operateLogList);
		return"queryOperateLogForExcel";
	}
	/**
	 * 岗位工作量节点名称查询
	 * @return
	 */
	public String operateLogNodeName(){
		
		operateLogList=operateLogService.listNodName();
		this.setOperateLogList(operateLogList);
		return "operateLogNodeName";
	}  
}
