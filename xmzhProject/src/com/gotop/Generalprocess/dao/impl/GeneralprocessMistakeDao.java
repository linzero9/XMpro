package com.gotop.Generalprocess.dao.impl;

import java.util.List;
import java.util.Map;

import com.gotop.Generalprocess.dao.IGeneralprocessMistakeDao;
import com.gotop.Generalprocess.model.ProcessMistake;
import com.gotop.Generalprocess.model.ProcessSubmitter;
import com.gotop.util.dataSource.SqlMapClientDao;

public class GeneralprocessMistakeDao extends SqlMapClientDao implements IGeneralprocessMistakeDao {
	/**
	 * 查询差错相关
	 * @return 
	 */
	@Override
	public List<ProcessMistake> queryProcessMistake(Map<String, Object> map) {
		List list = queryForList("T_GENERALPROCESS_MISTAKE_SqlMap.queryProcessMistake", map);
		return list;
	}

	/**
	 * 更新整改情况
	 */
	@Override
	public void updateProcessMistake(List<ProcessMistake> processMistakes) {
		for (ProcessMistake processMistake:processMistakes) {
			
			getSqlMapClientTemplate().update("T_GENERALPROCESS_MISTAKE_SqlMap.updateProcessMistake", processMistake);
			
		}
		
	}

	/**
	 * 查询提交人
	 */
	@Override
	public ProcessSubmitter querySubmitter(Map<String, Object> map) {
		
		  return (ProcessSubmitter) queryForObject("T_GENERALPROCESS_MISTAKE_SqlMap.querySubmitter", map);
		
	};

}
