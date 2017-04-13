package com.gotop.reportjbpm.action;


import java.util.ArrayList;
import java.util.List;
import com.gotop.crm.util.BaseAction;
import com.gotop.reportjbpm.model.SxApprovalReport;
import com.gotop.reportjbpm.service.ISxApprovalReportService;
public class SxApprovalReportAction extends BaseAction {

	private  SxApprovalReport sxApprovalReport;
	private List<SxApprovalReport> sxApprovalReportList =new ArrayList<SxApprovalReport>();
    private  ISxApprovalReportService sxApprovalReportService;
	private List<SxApprovalReport> sxApprovalReportTitleList =new ArrayList<SxApprovalReport>();
	private List<SxApprovalReport> sxApprovalReportOrgNameOneList =new ArrayList<SxApprovalReport>();
	private List<SxApprovalReport> sxApprovalReportOrgNameTwoList =new ArrayList<SxApprovalReport>();
	public List<SxApprovalReport> getSxApprovalReportOrgNameOneList() {
		return sxApprovalReportOrgNameOneList;
	}
	public void setSxApprovalReportOrgNameOneList(
			List<SxApprovalReport> sxApprovalReportOrgNameOneList) {
		this.sxApprovalReportOrgNameOneList = sxApprovalReportOrgNameOneList;
	}
	public List<SxApprovalReport> getSxApprovalReportOrgNameTwoList() {
		return sxApprovalReportOrgNameTwoList;
	}
	public void setSxApprovalReportOrgNameTwoList(
			List<SxApprovalReport> sxApprovalReportOrgNameTwoList) {
		this.sxApprovalReportOrgNameTwoList = sxApprovalReportOrgNameTwoList;
	}

    public SxApprovalReport getSxApprovalReport() {
		return sxApprovalReport;
	}
	public void setSxApprovalReport(SxApprovalReport sxApprovalReport) {
		this.sxApprovalReport = sxApprovalReport;
	}
	public List<SxApprovalReport> getSxApprovalReportList() {
		return sxApprovalReportList;
	}
	public void setSxApprovalReportList(List<SxApprovalReport> sxApprovalReportList) {
		this.sxApprovalReportList = sxApprovalReportList;
	}
	public ISxApprovalReportService getSxApprovalReportService() {
		return sxApprovalReportService;
	}
	public void setSxApprovalReportService(
			ISxApprovalReportService sxApprovalReportService) {
		this.sxApprovalReportService = sxApprovalReportService;
	}
	public List<SxApprovalReport> getSxApprovalReportTitleList() {
		return sxApprovalReportTitleList;
	}
	public void setSxApprovalReportTitleList(
			List<SxApprovalReport> sxApprovalReportTitleList) {
		this.sxApprovalReportTitleList = sxApprovalReportTitleList;
	}
	public String sxApprovalReportList(){
		sxApprovalReportTitleList=sxApprovalReportService.querySxApprovalReportTitleList(sxApprovalReport);
		sxApprovalReportOrgNameOneList=sxApprovalReportService.querySxApprovalReportOrgNameOneList(sxApprovalReport, this.getPage());
		sxApprovalReportList=sxApprovalReportService.querySxApprovalReportList(sxApprovalReport, this.getPage());
		this.setSxApprovalReportTitleList(sxApprovalReportTitleList);
		this.setSxApprovalReportList(sxApprovalReportList);
		this.setSxApprovalReportOrgNameOneList(sxApprovalReportOrgNameOneList);
		this.setPage(page);
		System.out.println("111122");
		System.out.println("3333333333");
		return "sxApprovalReportList";
	}
}
