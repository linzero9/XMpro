/**
 * 
 */
package com.gotop.reportjbpm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.gotop.reportjbpm.dao.IJobWorkloadDao;
import com.gotop.reportjbpm.model.JobWorkload;
import com.gotop.reportjbpm.service.IJobWorkloadService;
import com.primeton.utils.Page;

/**
 * @author gotop
 *
 */
public class JobWorkloadService implements IJobWorkloadService{

	protected Logger log = Logger.getLogger(JobWorkloadService.class);
	private IJobWorkloadDao jobWorkloadDao;
	
	@Override
	public IJobWorkloadDao getIJobWorkloadDao() {
		// TODO Auto-generated method stub
		return jobWorkloadDao;
	}

	@Override
	public void setJobWorkloadDao(IJobWorkloadDao jobWorkloadDao) {
		// TODO Auto-generated method stub
		this.jobWorkloadDao=jobWorkloadDao;
	}
	
	
	/**
	 * 查询岗位工作统计列表
	 */

	@Override
	public List<JobWorkload> jobWorkloadList(JobWorkload jobWorkload, Page page) {
		
		Map<String, Object> map=new HashMap<String, Object>();
		
		if(jobWorkload!=null){
			
			
		}
		List list=jobWorkloadDao.jobWorkloadtList(map, page);
		
		return list;
	}

	@Override
	public List<JobWorkload> jobWorkloadListExcel(JobWorkload jobWorkload) {
		
		Map<String, Object> map=new HashMap<String, Object>();
		
		if(jobWorkload!=null){
			
			
		}
		List list=jobWorkloadDao.JobWorkloadListExcel(map);
		return list;
	}

}
