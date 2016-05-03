package com.gotop.reportjbpm.service.impl;

import java.util.ArrayList;
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
		List<Approval> approvalList=new ArrayList<Approval>();
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
		
		approvalList =approvalDao.queryApprovalList(map,page);
		for (int i = 0; i < approvalList.size(); i++) {
		if (approvalList.get(i).getReceiveTime()!=null) {
			
			String [] time=approvalList.get(i).getReceiveTime().split(",");
		   switch (time.length) {
		case 0:
			   break;
		case 1:
			approvalList.get(i).setReceiveOne(time[0]);
			break;
		case 2:
			approvalList.get(i).setReceiveOne(time[0]);
			approvalList.get(i).setReceiveTwo(time[1]);
			break;
		case 3:
			approvalList.get(i).setReceiveOne(time[0]);
			approvalList.get(i).setReceiveTwo(time[1]);
			approvalList.get(i).setReceiveThree(time[2]);
			break;
		case 4:
			approvalList.get(i).setReceiveOne(time[0]);
			approvalList.get(i).setReceiveTwo(time[1]);
			approvalList.get(i).setReceiveThree(time[2]);
			approvalList.get(i).setReceiveFour(time[3]);
			break;
		case 5:
			approvalList.get(i).setReceiveOne(time[0]);
			approvalList.get(i).setReceiveTwo(time[1]);
			approvalList.get(i).setReceiveThree(time[2]);
			approvalList.get(i).setReceiveFour(time[3]);
			approvalList.get(i).setReceiveFive(time[4]);
			break;

		default:
			approvalList.get(i).setReceiveOne(time[0]);
			approvalList.get(i).setReceiveTwo(time[1]);
			approvalList.get(i).setReceiveThree(time[2]);
			approvalList.get(i).setReceiveFour(time[3]);
			approvalList.get(i).setReceiveFive(time[4]);
			break;
		}
		}
		}
		return approvalList;
	}

}
