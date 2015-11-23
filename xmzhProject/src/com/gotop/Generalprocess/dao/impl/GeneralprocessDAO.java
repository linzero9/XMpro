package com.gotop.Generalprocess.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.gotop.Generalprocess.dao.IGeneralprocessDAO;
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
	public List queryOrgName(String empIds) {
		return queryForList("GENERAL_PROCESS_SqlMap.queryOrgName",empIds);
	}

}
