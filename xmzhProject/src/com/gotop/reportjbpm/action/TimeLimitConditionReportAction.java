package com.gotop.reportjbpm.action;


import java.util.ArrayList;
import java.util.List;
import com.gotop.crm.util.BaseAction;
import com.gotop.reportjbpm.model.TimeLimitConditionReport;
import com.gotop.reportjbpm.service.ITimeLimitConditionReportService;
public class TimeLimitConditionReportAction extends BaseAction {
    private  TimeLimitConditionReport timeLimitConditionReport;
    private  ITimeLimitConditionReportService timeLimitConditionReportService;
	private List<TimeLimitConditionReport> timeLimitConditionReportList =new ArrayList<TimeLimitConditionReport>();
	public List<TimeLimitConditionReport> getTimeLimitConditionReportList() {
		return timeLimitConditionReportList;
	}
	public void setTimeLimitConditionReportList(
			List<TimeLimitConditionReport> timeLimitConditionReportList) {
		this.timeLimitConditionReportList = timeLimitConditionReportList;
	}
	public ITimeLimitConditionReportService getTimeLimitConditionReportService() {
		return timeLimitConditionReportService;
	}
	public void setTimeLimitConditionReportService(
			ITimeLimitConditionReportService timeLimitConditionReportService) {
		this.timeLimitConditionReportService = timeLimitConditionReportService;
	}
	public TimeLimitConditionReport getTimeLimitConditionReport() {
		return timeLimitConditionReport;
	}
	public void setTimeLimitConditionReport(
			TimeLimitConditionReport timeLimitConditionReport) {
		this.timeLimitConditionReport = timeLimitConditionReport;
	}
	public String timeLimitConditionReportList(){
		timeLimitConditionReportList=timeLimitConditionReportService.queryTimeLimitConditionReportList(timeLimitConditionReport, this.getPage());
		this.setPage(page);
		this.setTimeLimitConditionReportList(timeLimitConditionReportList);
		System.out.println("111122");
		System.out.println("3333333333");
		return "timeLimitConditionReportList";
	}
}
