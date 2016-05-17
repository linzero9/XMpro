package com.gotop.reportjbpm.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gotop.reportjbpm.dao.IOperateLogDao;
import com.gotop.reportjbpm.model.OperateLog;
import com.gotop.reportjbpm.service.IOperateLogService;
import com.gotop.util.string.Obj2StrUtils;
import com.primeton.utils.Page;

public class OperateLogService implements IOperateLogService {
	private IOperateLogDao operateLogDao;

	public IOperateLogDao getOperateLogDao() {
		return operateLogDao;
	}

	public void setOperateLogDao(IOperateLogDao operateLogDao) {
		this.operateLogDao = operateLogDao;
	}

	@Override
	public List<OperateLog> queryOperateLog(OperateLog operateLog, Page page) {
		Map<String, Object> map = new HashMap<String, Object>();

	
		if (operateLog.getAirTime() != null
				&& !"".equals(operateLog.getAirTime())) {
				map.put("airTime", operateLog.getAirTime());
		
		}
		if (operateLog.getStopTime() != null
				&& !"".equals(operateLog.getStopTime())) {
			map.put("stopTime",operateLog.getStopTime());
		}

		if (operateLog.getActivityName() != null
				&& !"".equals(operateLog.getActivityName())) {
			
			
			String[] activityNames=operateLog.getActivityName().split(",");
			String activityName="";
			try {
				activityName = Obj2StrUtils.join(activityNames, String.class, ",");
			} catch (Exception e) {
				e.printStackTrace();
			}
			map.put("activityName", activityName);
		}
		if (operateLog.getCustName()!= null
				&& !"".equals(operateLog.getCustName())) {
			map.put("custName", operateLog.getCustName());
		}
		

		return operateLogDao.queryOperateLog(map,page);
	}

	@Override
	public List<OperateLog> queryOperateLogForExcel(OperateLog operateLog) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		if(operateLog!=null){
			
			if (operateLog.getAirTime() != null
					&& !"".equals(operateLog.getAirTime())) {
				map.put("airTime", operateLog.getAirTime());
			}
			if (operateLog.getStopTime() != null
					&& !"".equals(operateLog.getStopTime())) {
				map.put("stopTime", operateLog.getStopTime());
			}
			if (operateLog.getActivityName() != null
					&& !"".equals(operateLog.getActivityName())) {
				
				
				String[] activityNames=operateLog.getActivityName().split(",");
				String activityName="";
				try {
					activityName = Obj2StrUtils.join(activityNames, String.class, ",");
				} catch (Exception e) {
					e.printStackTrace();
				}
				map.put("activityName", activityName);
			}
			if (operateLog.getCustName()!= null
					&& !"".equals(operateLog.getCustName())) {
				map.put("custName", operateLog.getCustName());
			}
		}
		

		

		return operateLogDao.queryOperateLogForExcel(map);
	}

	@Override
	public List<OperateLog> listNodName() {
		List<OperateLog> operateLogs=operateLogDao.listNodName();
		return operateLogs;
	}
}
