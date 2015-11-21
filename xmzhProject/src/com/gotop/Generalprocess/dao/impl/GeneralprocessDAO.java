package com.gotop.Generalprocess.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;

import com.gotop.Generalprocess.dao.IGeneralprocessDAO;
import com.gotop.Generalprocess.model.ProcessModelOne;
import com.gotop.euipApply.dao.impl.TApplyEuipDAO;
import com.gotop.util.dataSource.SqlMapClientDao;

public class GeneralprocessDAO extends SqlMapClientDao implements IGeneralprocessDAO{

	 /**
     * 
     * @abatorgenerated
     */
    protected Logger log = Logger.getLogger(TApplyEuipDAO.class);
    
    public GeneralprocessDAO() {
    	 super();
	}
    
	@Override
	public void addModelOne(ProcessModelOne modelOne) {
		insert("GENERAL_PROCESS_SqlMap.addModelOne", modelOne);
	}

	@Override
	public void uptModelOne(ProcessModelOne modelOne) {
		update("GENERAL_PROCESS_SqlMap.uptModelOne", modelOne);
	}

	@Override
	public ProcessModelOne getProcessModelOneById(String id) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		return (ProcessModelOne)queryForObject("GENERAL_PROCESS_SqlMap.getProcessModelOneById", map);
	}

	@Override
	public List<ProcessModelOne> getProcessModelOneByBussinessId(
			String bussinessId) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("bussinessId", bussinessId);
		List<ProcessModelOne> list = queryForList("GENERAL_PROCESS_SqlMap.getProcessModelOneByBussinessId", map);
		return list;
	}

	@Override
	public List queryOrgName(String empIds) {
		return queryForList("GENERAL_PROCESS_SqlMap.queryOrgName",empIds);
	}

	@Override
	public ProcessModelOne queryModelOne(String processModelId, String flowId) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("processModelId", processModelId);
		map.put("flowId", flowId);
		return (ProcessModelOne) queryForObject("GENERAL_PROCESS_SqlMap.queryModelOne", map);
	}

	
}
