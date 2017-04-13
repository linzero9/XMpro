package com.gotop.reportjbpm.service;

import java.util.List;
import com.gotop.reportjbpm.model.SxApprovalReport;
import com.primeton.utils.Page;

public interface ISxApprovalReportService {
	
	/**
	 * 授信审批报表
	 * @param approval
	 * @param page
	 * @return
	 */
	List<SxApprovalReport> querySxApprovalReportList(SxApprovalReport sxApprovalReport, Page page);
	

	/**
	 * 授信审批报表标题头
	 * @param approval
	 * @param page
	 * @return
	 */
	List<SxApprovalReport> querySxApprovalReportTitleList(SxApprovalReport sxApprovalReport);
	/**
	 * 授信审批报表导出excel
	 * @param approval
	 * @param page
	 * @return
	 */
	List<SxApprovalReport> querySxApprovalReportListForExcel(SxApprovalReport sxApprovalReport);
	

	/**
	 * 查询一级机构列名
	 * @param approval
	 * @param page
	 * @return
	 */
	List<SxApprovalReport> querySxApprovalReportOrgNameOneList(SxApprovalReport sxApprovalReport, Page page);
	

}
