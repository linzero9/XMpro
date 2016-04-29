package com.gotop.reportjbpm.dao.impl;

import java.util.List;
import java.util.Map;

import com.gotop.reportjbpm.dao.IApprovalDao;
import com.gotop.reportjbpm.model.Approval;
import com.gotop.util.dataSource.SqlMapClientDao;
import com.primeton.utils.Page;

public class ApprovalDao extends SqlMapClientDao implements IApprovalDao {

	@Override
	public List<Approval> queryApprovalList(Map<String, Object> map, Page page) {
		
		return queryForList("T_APPROVAL_SqlMap.queryApproval", map,page);
	}

}
