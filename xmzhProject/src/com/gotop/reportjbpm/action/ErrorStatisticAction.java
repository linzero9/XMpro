 package com.gotop.reportjbpm.action;

import java.util.ArrayList;
import java.util.List;

import com.gotop.crm.util.BaseAction;
import com.gotop.reportjbpm.model.ErrorStatistic;
import com.gotop.reportjbpm.service.IErrorStatisticService;

public class ErrorStatisticAction extends BaseAction {
	private ErrorStatistic errorStatistic;
	private List<ErrorStatistic> errorStatisticList = new ArrayList<ErrorStatistic>();
	private IErrorStatisticService errorStatisticService;
	
	public ErrorStatistic getErrorStatistic() {
		return errorStatistic;
	}
	public void setErrorStatistic(ErrorStatistic errorStatistic) {
		this.errorStatistic = errorStatistic;
	}
	public List<ErrorStatistic> getErrorStatisticList() {
		return errorStatisticList;
	}
	public void setErrorStatisticList(List<ErrorStatistic> errorStatisticList) {
		this.errorStatisticList = errorStatisticList;
	}
	public IErrorStatisticService getErrorStatisticService() {
		return errorStatisticService;
	}
	public void setErrorStatisticService(
			IErrorStatisticService errorStatisticService) {
		this.errorStatisticService = errorStatisticService;
	}
	/**
	 * 查询错误报表情况
	 * @return
	 */
	public String queryErrorStatistic(){
		errorStatisticList = errorStatisticService.queryErrorStatistic(errorStatistic,this.getPage());
		this.setPage(page);
		this.setErrorStatisticList(errorStatisticList);
		return "ErrorStatisticList";
	}
	/**
	 * 查询错误报表情况_导出excel
	 * 
	 * @return
	 */
	public String queryErrorStatisticForExcel(){
		errorStatisticList = errorStatisticService.queryErrorStatisticExcel(errorStatistic);
		this.setErrorStatisticList(errorStatisticList);
		return "ErrorStatisticListExcel";
	}
	/**
	 * 查询所有差错环节
	 * @return
	 */
	public String querytaskNameList(){
		errorStatisticList = errorStatisticService.querytaskNameList();
		this.setErrorStatisticList(errorStatisticList);
		return "querytaskNameList";
	}
	

}
