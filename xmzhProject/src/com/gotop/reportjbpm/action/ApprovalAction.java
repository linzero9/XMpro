package com.gotop.reportjbpm.action;

import java.util.ArrayList;
import java.util.List;

import sun.print.resources.serviceui;

import com.gotop.crm.util.BaseAction;
import com.gotop.reportjbpm.model.Approval;
import com.gotop.reportjbpm.service.IApprovalService;

public class ApprovalAction extends BaseAction {
	private Approval approval;
	private IApprovalService approvalService;
	private List<Approval> approvalList =new ArrayList<Approval>();
	
	public Approval getApproval() {
		return approval;
	}
	public void setApproval(Approval approval) {
		this.approval = approval;
	}
	public IApprovalService getApprovalService() {
		return approvalService;
	}
	public void setApprovalService(IApprovalService approvalService) {
		this.approvalService = approvalService;
	}
	public List<Approval> getApprovalList() {
		return approvalList;
	}
	public void setApprovalList(List<Approval> approvalList) {
		this.approvalList = approvalList;
	}
	/**
	 * 审批受理台账
	 * @return
	 */
	public String queryApprovalList(){
		approvalList=approvalService.queryApprovalList(approval,this.getPage());
		this.setPage(page);
		this.setApprovalList(approvalList);
		return  "queryApprovalList";
	}
	/**
	 * 审批受理台账导出excel
	 * @return
	 */
	public String queryApprovalListForExcel(){
		approvalList=approvalService.queryApprovalListForExcel(approval);
		this.setApprovalList(approvalList);
		return  "queryApprovalListForExcel";
	}
	
	
	
	

}
