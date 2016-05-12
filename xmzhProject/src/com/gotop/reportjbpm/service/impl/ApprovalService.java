package com.gotop.reportjbpm.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gotop.reportjbpm.dao.IApprovalDao;
import com.gotop.reportjbpm.model.Approval;
import com.gotop.reportjbpm.service.IApprovalService;
import com.primeton.ext.system.logging.AppConsoleHandler.SystemOutConsole;
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
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
		if (approval.getRepTimeStrat() !=null&&!"".equals(approval.getRepTimeStrat())) {
		
				map.put("repTimeStrat", sdf.format(sdf1.parse(approval.getRepTimeStrat())));
			
		}
		if (approval.getRepTimeEnd() !=null&&!"".equals(approval.getRepTimeEnd())) {
			map.put("repTimeEnd",   sdf.format(sdf1.parse(approval.getRepTimeEnd())));
		}
		if (approval.getAppTimeStrat() !=null&&!"".equals(approval.getAppTimeStrat())) {
			map.put("appTimeStrat",   sdf.format(sdf1.parse(approval.getAppTimeStrat())));
		}
		if (approval.getAppTimeEnd() !=null&&!"".equals(approval.getAppTimeEnd())) {
			map.put("appTimeEnd",  sdf.format(sdf1.parse(approval.getAppTimeEnd())));
		}
		} catch (ParseException e) {
			e.printStackTrace();
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

	@Override
	public List<Approval> queryApprovalListForExcel(Approval approval) {
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
		
		approvalList =approvalDao.queryApprovalListForExcel(map);
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
