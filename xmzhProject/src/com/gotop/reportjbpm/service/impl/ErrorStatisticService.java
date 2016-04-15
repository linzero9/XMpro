package com.gotop.reportjbpm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.enterprisedt.util.debug.Logger;
import com.gotop.reportjbpm.dao.IErrorStatisticDao;
import com.gotop.reportjbpm.model.ErrorStatistic;
import com.gotop.reportjbpm.service.IErrorStatisticService;
import com.primeton.utils.Page;

public class ErrorStatisticService implements IErrorStatisticService {

	protected Logger log = Logger.getLogger(ErrorStatisticService.class);
	private IErrorStatisticDao errorStatisticDao;
	
	public IErrorStatisticDao getErrorStatisticDao() {
		return errorStatisticDao;
	}
	public void setErrorStatisticDao(IErrorStatisticDao errorStatisticDao) {
		this.errorStatisticDao = errorStatisticDao;
	}
	

	@Override
	public List<ErrorStatistic> queryErrorStatistic(ErrorStatistic errorStatistic, Page page) {
		
		
		Map<String, Object>map = new HashMap<String, Object>();
		 StringBuffer stringBuffer = new StringBuffer();
		 if (errorStatistic.getTaskName()!=null&&!"".equals(errorStatistic.getTaskName())) {
			 String[] array =errorStatistic.getTaskName().split(",");
			 for (int i = 0; i < array.length; i++) {
				 stringBuffer.append("'");
				stringBuffer.append(array[i]);
				stringBuffer.append("'");
				stringBuffer.append(",");
			}
			 stringBuffer=stringBuffer.deleteCharAt(stringBuffer.length()-1);
			 
			 map.put("taskName", stringBuffer); 
		}
			
		if (errorStatistic.getStartTime()!=null&&!"".equals(errorStatistic.getStartTime())) {
			map.put("startTime", errorStatistic.getStartTime());
		}
		if (errorStatistic.getEndTime()!=null&&!"".equals(errorStatistic.getEndTime())) {
			map.put("endTime", errorStatistic.getEndTime());
		}
		if (errorStatistic.getCustName()!=null&&!"".equals(errorStatistic.getCustName())) {
			map.put("custName", errorStatistic.getCustName());
		}
		
		
		List<ErrorStatistic> errorStatistics = errorStatisticDao.queryErrorStatistic(map,page);
		
		for (int i = 0; i < errorStatistics.size(); i++) {
			errorStatistics.get(i).setMistakeNumber("1");
			
		}
		return errorStatistics;
	}
	@Override
	public List<ErrorStatistic> queryErrorStatisticExcel(
			ErrorStatistic errorStatistic) {
		
		Map<String, Object>map = new HashMap<String, Object>();
		 StringBuffer stringBuffer = new StringBuffer();
		 if (errorStatistic.getTaskName()!=null&&!"".equals(errorStatistic.getTaskName())) {
			 String[] array =errorStatistic.getTaskName().split(",");
			 for (int i = 0; i < array.length; i++) {
				 stringBuffer.append("'");
				stringBuffer.append(array[i]);
				stringBuffer.append("'");
				stringBuffer.append(",");
			}
			 stringBuffer=stringBuffer.deleteCharAt(stringBuffer.length()-1);
			 
			 map.put("taskName", stringBuffer); 
		}
			
		
		if (errorStatistic.getStartTime()!=null&&!"".equals(errorStatistic.getStartTime())) {
			map.put("startTime", errorStatistic.getStartTime());
		}
		if (errorStatistic.getEndTime()!=null&&!"".equals(errorStatistic.getEndTime())) {
			map.put("endTime", errorStatistic.getEndTime());
		}
		if (errorStatistic.getCustName()!=null&&!"".equals(errorStatistic.getCustName())) {
			map.put("custName", errorStatistic.getCustName());
		}
		
		
		List<ErrorStatistic> errorStatistics = errorStatisticDao.queryErrorStatisticForExcel(map);
		for (int i = 0; i < errorStatistics.size(); i++) {
			errorStatistics.get(i).setMistakeNumber("1");
			
		}
		return errorStatistics;
	}
	@Override
	public List<ErrorStatistic> querytaskNameList() {
		List<ErrorStatistic> errorStatistics=errorStatisticDao.querytaskNameList();
		return errorStatistics;
	}

}
