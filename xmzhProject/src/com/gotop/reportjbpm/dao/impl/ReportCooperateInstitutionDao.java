package com.gotop.reportjbpm.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;



import com.gotop.reportjbpm.dao.IReportCooperateInstitutionDao;
import com.gotop.reportjbpm.model.ReportCooperateInstitution;
import com.gotop.util.dataSource.SqlMapClientDao;
import com.primeton.utils.Page;

public class ReportCooperateInstitutionDao extends SqlMapClientDao implements IReportCooperateInstitutionDao{
	protected Logger log = Logger.getLogger(ReportCooperateInstitutionDao.class);
    
    @Override
	public List<ReportCooperateInstitution> selectReportCooperateInstitution(Map<String, Object> map,
			Page page) {
    	
    	List<ReportCooperateInstitution> list=queryForList("ReportCooperateInstitution_SqlMap.queryReportCooperateInstitution", map, page);
    	return list;
    }
	
    @Override
	public List<ReportCooperateInstitution> selectReportCooperateInstitutionFoeExcl(Map<String, Object> map) {
    	
    	List<ReportCooperateInstitution> list=queryForList("ReportCooperateInstitution_SqlMap.queryReportCooperateInstitution", map);
    	return list;
    }
    
	public ReportCooperateInstitutionDao() {
		super();
		// TODO Auto-generated constructor stub
	}
   

       
    
}
