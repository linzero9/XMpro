/**
 * 
 */
package com.gotop.reportjbpm.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gotop.crm.util.BaseAction;
import com.gotop.reportjbpm.dao.IRateofreturnReportDao;
import com.gotop.reportjbpm.model.RateofreturnReport;
import com.gotop.reportjbpm.service.IRateofreturnReportService;

/**
 * @author gotop
 *
 */
public class RateofreturnReportAction extends BaseAction {
	
	protected IRateofreturnReportService rateofreturnReportService;
	
	private RateofreturnReport rateofreturnReport;
	
	private  List<RateofreturnReport> list;

	
	

	public List<RateofreturnReport> getList() {
		return list;
	}
	public RateofreturnReport getRateofreturnReport() {
		return rateofreturnReport;
	}
	public void setRateofreturnReport(RateofreturnReport rateofreturnReport) {
		this.rateofreturnReport = rateofreturnReport;
	}
	public void setList(List<RateofreturnReport> list) {
		this.list = list;
	}
	public IRateofreturnReportService getRateofreturnReportService() {
		return rateofreturnReportService;
	}
	public void setRateofreturnReportService(
			IRateofreturnReportService rateofreturnReportService) {
		this.rateofreturnReportService = rateofreturnReportService;
	}




  /**
   * 退单率查询
   * @return
   */
	public String rateofreturnReportList(){
		
		list=rateofreturnReportService.rateofreturnReportList(rateofreturnReport, this.getPage());
		this.setList(list);
		return "rateofreturnReportlist";
	}
	
	/**
	 * 导出Excel
	 * @return
	 */
	public String exportExcel(){
		
		if(rateofreturnReport==null){
			rateofreturnReport=new RateofreturnReport();
		}
		
		list=rateofreturnReportService.rateofreturnReportListExcel(rateofreturnReport);
		this.setList(list);
		return "exportExcel";
	}
	

	
}
