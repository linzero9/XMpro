package com.gotop.Generalprocess.dao.impl;

import java.util.HashMap;

import com.gotop.Generalprocess.dao.ITGeneralprocessModelfiveDAO;
import com.gotop.Generalprocess.model.ProcessModelFive;
import com.gotop.util.dataSource.SqlMapClientDao;
import org.apache.log4j.Logger;

public class TGeneralprocessModelfiveDAO extends SqlMapClientDao implements ITGeneralprocessModelfiveDAO {
    /**
     * 
     * @abatorgenerated
     */
    protected Logger log = Logger.getLogger(TGeneralprocessModelfiveDAO.class);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table T_GENERALPROCESS_MODELFIVE
     *
     * @abatorgenerated 
     */
    public TGeneralprocessModelfiveDAO() {
        super();
    }

	@Override
	public ProcessModelFive queryModelFive(HashMap<String, Object> map) {
		return (ProcessModelFive) getSqlMapClientTemplate().queryForObject("T_GENERALPROCESS_MODELFIVE_SqlMap.queryModelFive", map);
	}

	@Override
	public void addModelFive(ProcessModelFive modelFive) {
		getSqlMapClientTemplate().insert("T_GENERALPROCESS_MODELFIVE_SqlMap.addModelFive", modelFive);
	}

	@Override
	public void uptModelFive(ProcessModelFive modelFive) {
		getSqlMapClientTemplate().update("T_GENERALPROCESS_MODELFIVE_SqlMap.uptModelFive", modelFive);
	}

	@Override
	public ProcessModelFive queryModelFiveById(String processModelId) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("processModelId", processModelId);
		return (ProcessModelFive) queryForObject("T_GENERALPROCESS_MODELFIVE_SqlMap.queryModelFiveById", map);
	}

}