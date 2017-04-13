package com.gotop.reportjbpm.dao;

import java.util.List;
import java.util.Map;
import com.gotop.reportjbpm.model.SxApprovalReport;
import com.primeton.utils.Page;

public interface ISxApprovalReportDao {
/**
 * 授信审批报表
 * @param map
 * @param page
 * @return
 */
	List<SxApprovalReport> querySxApprovalReportList(Map<String, Object> map, Page page);
	/**
	 * 授信审批报表标题头
	 * @param approval
	 * @param page
	 * @return
	 */
	List<SxApprovalReport> querySxApprovalReportTitleList(Map<String, Object> map);
	/**
	 * 授信审批报表导出Excel
	 * @param map
	 * @param page
	 * @return
	 */
	List<SxApprovalReport> querySxApprovalReportListForExcel(Map<String, Object> map);
	
	/**
	 * 查询一级机构列名
	 * @param map
	 * @param page
	 * @return
	 */
	List<SxApprovalReport> querySxApprovalReportOrgNameOneList(Map<String, Object> map, Page page);

}
