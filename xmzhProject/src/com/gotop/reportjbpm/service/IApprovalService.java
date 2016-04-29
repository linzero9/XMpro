package com.gotop.reportjbpm.service;

import java.util.List;

import com.gotop.reportjbpm.model.Approval;
import com.primeton.utils.Page;

public interface IApprovalService {

	List<Approval> queryApprovalList(Approval approval, Page page);

}
