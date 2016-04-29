package com.gotop.reportjbpm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gotop.reportjbpm.dao.IApprovalDao;
import com.gotop.reportjbpm.model.Approval;
import com.gotop.reportjbpm.service.IApprovalService;
import com.primeton.utils.Page;

public class ApprovalService implements IApprovalService {

	private IApprovalDao approvalDao;
	
	public IApprovalDao getApprovalDao() {
		return approvalDao;
	}

	public void setApprovalDao(IApprovalDao approvalDao) {
		this.approvalDao = approvalDao;
	}

	@Override
	public List<Approval> queryApprovalList(Approval approval, Page page) {
		Map<String, Object>map=new HashMap<String, Object>();
		if (approval.getRepTimeStrat() !=null&&!"".equals(approval.getRepTimeStrat())) {
			map.put("repTimeStrat", approval.getRepTimeStrat());
		}
		if (approval.getRepTimeEnd() !=null&&!"".equals(approval.getRepTimeEnd())) {
			map.put("repTimeEnd", approval.getRepTimeEnd());
		}
		if (approval.getAppTimeStrat() !=null&&!"".equals(approval.getAppTimeStrat())) {
			map.put("appTimeStrat", approval.getAppTimeStrat());
		}
		if (approval.getAppTimeEnd() !=null&&!"".equals(approval.getAppTimeEnd())) {
			map.put("appTimeEnd", approval.getAppTimeEnd());
		}
		
		return approvalDao.queryApprovalList(map,page);
	}

}
