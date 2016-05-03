package com.gotop.reportjbpm.service;

import java.util.List;

import com.gotop.reportjbpm.model.Approval;
import com.primeton.utils.Page;

public interface IApprovalService {
	/**
	 * 审查审批受理台账
	 * @param approval
	 * @param page
	 * @return
	 */
	List<Approval> queryApprovalList(Approval approval, Page page);
	/**
	 * 审查审批受理台账导出excel
	 * @param approval
	 * @param page
	 * @return
	 */
	List<Approval> queryApprovalListForExcel(Approval approval);
	
	

}
