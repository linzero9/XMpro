package com.gotop.reportjbpm.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gotop.reportjbpm.dao.IOperateLogDao;
import com.gotop.reportjbpm.model.OperateLog;
import com.gotop.reportjbpm.service.IOperateLogService;
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
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
		if (operateLog.getAirTime() != null
				&& !"".equals(operateLog.getAirTime())) {
				map.put("airTime", sdf.format(sdf1.parse(operateLog.getAirTime())));
		
		}
		if (operateLog.getStopTime() != null
				&& !"".equals(operateLog.getStopTime())) {
			map.put("stopTime",sdf.format(sdf1.parse(operateLog.getStopTime())));
		}
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		if (operateLog.getProcessName() != null
				&& !"".equals(operateLog.getProcessName())) {
			map.put("processName", operateLog.getProcessName());
		}
		if (operateLog.getBusinessTitle()!= null
				&& !"".equals(operateLog.getBusinessTitle())) {
			map.put("businessTitle", operateLog.getBusinessTitle());
		}
		

		return operateLogDao.queryOperateLog(map,page);
	}

	@Override
	public List<OperateLog> queryOperateLogForExcel(OperateLog operateLog) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		if (operateLog.getAirTime() != null
				&& !"".equals(operateLog.getAirTime())) {
			map.put("airTime", operateLog.getAirTime());
		}
		if (operateLog.getStopTime() != null
				&& !"".equals(operateLog.getStopTime())) {
			map.put("stopTime", operateLog.getStopTime());
		}
		if (operateLog.getProcessName() != null
				&& !"".equals(operateLog.getProcessName())) {
			map.put("processName", operateLog.getProcessName());
		}
		if (operateLog.getBusinessTitle()!= null
				&& !"".equals(operateLog.getBusinessTitle())) {
			map.put("businessTitle", operateLog.getBusinessTitle());
		}
		

		return operateLogDao.queryOperateLogForExcel(map);
	}
}
