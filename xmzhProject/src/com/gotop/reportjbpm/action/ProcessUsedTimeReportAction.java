package com.gotop.reportjbpm.action;


import java.util.ArrayList;
import java.util.List;
import com.gotop.crm.util.BaseAction;
import com.gotop.reportjbpm.model.ProcessUsedTimeReport;
import com.gotop.reportjbpm.service.IProcessUsedTimeReportService;
public class ProcessUsedTimeReportAction extends BaseAction {

	private ProcessUsedTimeReport processUsedTimeReport;
	private IProcessUsedTimeReportService processUsedTimeReportService;
	private List<ProcessUsedTimeReport> processUsedTimeReportList =new ArrayList<ProcessUsedTimeReport>();
	
	public List<ProcessUsedTimeReport> getProcessUsedTimeReportList() {
		return processUsedTimeReportList;
	}
	public void setProcessUsedTimeReportList(
			List<ProcessUsedTimeReport> processUsedTimeReportList) {
		this.processUsedTimeReportList = processUsedTimeReportList;
	}
	public IProcessUsedTimeReportService getProcessUsedTimeReportService() {
		return processUsedTimeReportService;
	}
	public void setProcessUsedTimeReportService(
			IProcessUsedTimeReportService processUsedTimeReportService) {
		this.processUsedTimeReportService = processUsedTimeReportService;
	}
	public ProcessUsedTimeReport getProcessUsedTimeReport() {
		return processUsedTimeReport;
	}
	public void setProcessUsedTimeReport(ProcessUsedTimeReport processUsedTimeReport) {
		this.processUsedTimeReport = processUsedTimeReport;
	}
	public String processUsedTimeReportList(){
		processUsedTimeReportList=processUsedTimeReportService.queryProcessUsedTimeReportList(processUsedTimeReport, this.getPage());
		this.setPage(page);
		this.setProcessUsedTimeReportList(processUsedTimeReportList);
		System.out.println("1111");
		System.out.println("3333333333");
		return "processUsedTimeReportList";
	}
}
