package com.gotop.Generalprocess.dao.impl;

import java.util.HashMap;

import com.gotop.Generalprocess.dao.ITGeneralprocessModelsevenDAO;
import com.gotop.Generalprocess.model.ProcessModelSeven;
import com.gotop.util.dataSource.SqlMapClientDao;
import org.apache.log4j.Logger;

public class TGeneralprocessModelsevenDAO extends SqlMapClientDao implements ITGeneralprocessModelsevenDAO {
    /**
     * 
     * @abatorgenerated
     */
    protected Logger log = Logger.getLogger(TGeneralprocessModelsevenDAO.class);

    public TGeneralprocessModelsevenDAO() {
        super();
    }

	@Override
	public ProcessModelSeven queryModelSeven(HashMap<String, Object> map) {
		return (ProcessModelSeven) getSqlMapClientTemplate().queryForObject("T_GENERALPROCESS_MODELSEVEN_SqlMap.queryModelSeven", map);
	}

	@Override
	public void addModelSeven(ProcessModelSeven modelSeven) {
		getSqlMapClientTemplate().insert("T_GENERALPROCESS_MODELSEVEN_SqlMap.addModelSeven", modelSeven);
	}

	@Override
	public void uptModelSeven(ProcessModelSeven modelSeven) {
		getSqlMapClientTemplate().update("T_GENERALPROCESS_MODELSEVEN_SqlMap.uptModelSeven", modelSeven);
	}

	@Override
	public ProcessModelSeven queryModelSevenById(String processModelId) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("processModelId", processModelId);
		return (ProcessModelSeven) queryForObject("T_GENERALPROCESS_MODELSEVEN_SqlMap.queryModelSevenById", map);
	}

}