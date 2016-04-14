package com.gotop.reportjbpm.action;

import java.util.ArrayList;
import java.util.List;

import com.gotop.crm.util.BaseAction;
import com.gotop.reportjbpm.model.ReportRefusalrate;
import com.gotop.reportjbpm.service.TReportRefusalrateService;

public class ReportRefusalrateAction extends BaseAction {
	
	private ReportRefusalrate reportRefusalrate;
	private List<ReportRefusalrate> reportRefusalRate = new ArrayList<ReportRefusalrate>();
	private TReportRefusalrateService reportRefusalrateService;
	public ReportRefusalrate getReportRefusalrate() {
		return reportRefusalrate;
	}
	public void setReportRefusalrate(ReportRefusalrate reportRefusalrate) {
		this.reportRefusalrate = reportRefusalrate;
	}
	public List<ReportRefusalrate> getReportRefusalRate() {
		return reportRefusalRate;
	}
	public void setReportRefusalRate(List<ReportRefusalrate> reportRefusalRate) {
		this.reportRefusalRate = reportRefusalRate;
	}
	public TReportRefusalrateService getReportRefusalrateService() {
		return reportRefusalrateService;
	}
	public void setReportRefusalrateService(TReportRefusalrateService reportRefusalrateService) {
		this.reportRefusalrateService = reportRefusalrateService;
	}
	/**
	 * 查询人员信息
	 * @return
	 */
	public String queryReportRefusalRate(){
		reportRefusalRate=reportRefusalrateService.selectReportRefusalRate(this.getReportRefusalrate(),this.getPage());
		this.setPage(page);
		this.setReportRefusalRate(reportRefusalRate);
		return"queryReportRefusalRate";
	}

	
}
