/**
 * 
 */
package com.gotop.reportjbpm.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.apache.log4j.Logger;

import com.gotop.reportjbpm.dao.IJobWorkloadDao;
import com.gotop.reportjbpm.model.JobWorkload;
import com.gotop.util.dataSource.SqlMapClientDao;
import com.primeton.utils.Page;

/**
 * @author gotop
 *
 */
public class JobWorkloadDao extends SqlMapClientDao implements IJobWorkloadDao {
	
	protected Logger log = Logger.getLogger(JobWorkloadDao.class);

	/* 
	 * 查询
	 */
	@Override
	public List jobWorkloadtList(Map<String, Object> map, Page page) {
		// TODO Auto-generated method stub
		
		List  list=queryForList("T_JOBWORKLOAD_SqlMap.jobWorkloadtList", map,page);
		return list;
	}

	/* 
	 * excel
	 */
	@Override
	public List JobWorkloadListExcel(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return queryForList("T_JOBWORKLOAD_SqlMap.jobWorkloadtList", map);
	}

	/**
	 * 流程节点查询
	 */
	@Override
	public List<JobWorkload> listNodName() {
		// TODO Auto-generated method stub
		return queryForList("T_JOBWORKLOAD_SqlMap.listNodName",new HashMap());
	}

}
