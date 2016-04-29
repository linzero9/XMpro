package com.gotop.reportjbpm.dao;

import java.util.List;
import java.util.Map;

import com.gotop.reportjbpm.model.Approval;
import com.primeton.utils.Page;

public interface IApprovalDao {

	List<Approval> queryApprovalList(Map<String, Object> map, Page page);

}
