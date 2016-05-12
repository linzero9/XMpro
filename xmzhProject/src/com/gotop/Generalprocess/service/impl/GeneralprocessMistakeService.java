package com.gotop.Generalprocess.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gotop.Generalprocess.dao.IGeneralprocessMistakeDao;
import com.gotop.Generalprocess.model.ProcessMistake;
import com.gotop.Generalprocess.model.ProcessSubmitter;
import com.gotop.Generalprocess.service.IGeneralprocessMistakeService;

public class GeneralprocessMistakeService implements IGeneralprocessMistakeService {
	private	IGeneralprocessMistakeDao generalprocessMistakeDao;
	
public IGeneralprocessMistakeDao getGeneralprocessMistakeDao() {
		return generalprocessMistakeDao;
	}

	public void setGeneralprocessMistakeDao(
			IGeneralprocessMistakeDao generalprocessMistakeDao) {
		this.generalprocessMistakeDao = generalprocessMistakeDao;
	}
/**
 * 查询差错情况
 * @return
 */
public List<ProcessMistake> queryProcessMistake(ProcessMistake processMistake){
	Map<String, Object> map =new HashMap<String, Object>();
	if (processMistake.getFlowId()!=null&&!"".equals(processMistake.getFlowId())) {
		map.put("flowId", processMistake.getFlowId());
	}
	
	
	return generalprocessMistakeDao.queryProcessMistake(map);
		
		 
	}
/**
 * 更新整改情况
 * @return
 */	
public void updateProcessMistake(List<ProcessMistake> processMistakes){
	
	generalprocessMistakeDao.updateProcessMistake(processMistakes);
	
	
}

/**
 * 查询提交人
 */
public ProcessSubmitter querySubmitter(ProcessSubmitter processSubmitter){
	Map<String, Object>map=new HashMap<String, Object>();
	if (processSubmitter.getFlowId()!=null&&!"".equals(processSubmitter.getFlowId())) {
		map.put("flowId", processSubmitter.getFlowId());
	}
	processSubmitter=generalprocessMistakeDao.querySubmitter(map);
	
	return processSubmitter;
}

}
