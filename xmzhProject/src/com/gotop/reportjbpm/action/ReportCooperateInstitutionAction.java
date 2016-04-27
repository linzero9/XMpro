package com.gotop.reportjbpm.action;



import java.util.List;

import com.gotop.crm.util.BaseAction;
import com.gotop.reportjbpm.model.ReportCooperateInstitution;
import com.gotop.reportjbpm.service.IReportCooperateInstitutionService;

import com.primeton.utils.Page;
import com.primeton.utils.pageCondExpand;

public class ReportCooperateInstitutionAction extends BaseAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private IReportCooperateInstitutionService reportCooperateInstitutionService;
    
	private ReportCooperateInstitution cooperateInstitutionDto; 
	
	private List<ReportCooperateInstitution> cooperateInstitutionDtos;
	;
	public Page page;
      
    public Page getPage() {
    	if(page==null){
			page = new Page();
			page.setBegin(0);
			page.setLength(10);
			page.setCount(0);
			page.setCount(true);
		}
		return page;
	}
    
    
	public void setPage(Page page) {
		pageCondExpand pce = new pageCondExpand();
		pce.putPageCond(page);
		this.page = page;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public void setReportCooperateInstitutionService(
			IReportCooperateInstitutionService reportCooperateInstitutionService) {
		this.reportCooperateInstitutionService = reportCooperateInstitutionService;
	}


	public ReportCooperateInstitution getCooperateInstitutionDto() {
		return cooperateInstitutionDto;
	}


	public void setCooperateInstitutionDto(
			ReportCooperateInstitution cooperateInstitutionDto) {
		this.cooperateInstitutionDto = cooperateInstitutionDto;
	}


	public IReportCooperateInstitutionService getReportCooperateInstitutionService() {
		return reportCooperateInstitutionService;
	}
	 
	public List<ReportCooperateInstitution> getCooperateInstitutionDtos() {
		return cooperateInstitutionDtos;
	}


	public void setCooperateInstitutionDtos(
			List<ReportCooperateInstitution> cooperateInstitutionDtos) {
		this.cooperateInstitutionDtos = cooperateInstitutionDtos;
	}

/**
 * 查询
 * */
	public String queryReportCooperateInstitution()
	{
	
		cooperateInstitutionDtos=reportCooperateInstitutionService.selectReportCooperateInstitution(cooperateInstitutionDto, page);
		return "ReportCooperateInstitution";
	}
	/**
	 * 导出excl表格
	 * */
	
	public String queryReportCooperateInstitutionForExcl()
	{
	
		cooperateInstitutionDtos=reportCooperateInstitutionService.selectReportCooperateInstitutionForExcl(cooperateInstitutionDto);
		return "ReportCooperateInstitutionForExcl";
	}
}
