package com.gotop.Generalprocess.dao.impl;

import com.gotop.Generalprocess.dao.ITGeneralprocessModelsixDAO;
import com.gotop.Generalprocess.model.ProcessModelFour;
import com.gotop.Generalprocess.model.ProcessModelSix;

import com.gotop.util.dataSource.SqlMapClientDao;
import com.primeton.utils.Page;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import org.apache.log4j.Logger;
/**
 * 
 * @author wujiajun
 * 
 *
 */
public class TGeneralprocessModelsixDAO extends SqlMapClientDao implements ITGeneralprocessModelsixDAO {
	
	
	
    protected Logger log = Logger.getLogger(TGeneralprocessModelsixDAO.class);
    
    
	@Override
	public ProcessModelSix queryModelSix(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return  (ProcessModelSix) getSqlMapClientTemplate().queryForObject("T_GENERALPROCESS_MODELSIX_SqlMap.queryModelSix", map);
	}

	@Override
	public void addModelSix(ProcessModelSix modelSix) {
		getSqlMapClientTemplate().insert("T_GENERALPROCESS_MODELSIX_SqlMap.addModelSix", modelSix);
		
	}

	@Override
	public void uptModelSix(ProcessModelSix modelSix) {
		getSqlMapClientTemplate().update("T_GENERALPROCESS_MODELSIX_SqlMap.uptModelSix", modelSix);
	}

	@Override
	public ProcessModelSix queryModelSixById(String processModelId) {
		// TODO Auto-generated method stub
	     HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("processModelId", processModelId);
		return (ProcessModelSix) queryForObject("T_GENERALPROCESS_MODELSIX_SqlMap.queryModelSixById", map);
	}

	@Override
	public ProcessModelSix queryModelSixByFlowIdAndTaskName(ProcessModelSix six) {
		return  (ProcessModelSix) getSqlMapClientTemplate().queryForObject("T_GENERALPROCESS_MODELSIX_SqlMap.queryModelSixByFlowIdAndTaskName", six);		
	}
   
}