package com.gotop.reportjbpm.dao;

import java.util.List;
import java.util.Map;

import com.gotop.reportjbpm.model.Approval;
import com.primeton.utils.Page;

public interface IApprovalDao {
/**
 * 审批受理台账
 * @param map
 * @param page
 * @return
 */
	List<Approval> queryApprovalList(Map<String, Object> map, Page page);
	/**
	 * 审批受理台账导出Excel
	 * @param map
	 * @param page
	 * @return
	 */
	List<Approval> queryApprovalListForExcel(Map<String, Object> map);

}
