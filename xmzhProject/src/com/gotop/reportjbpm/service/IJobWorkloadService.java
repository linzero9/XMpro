/**
 * 
 */
package com.gotop.reportjbpm.service;

import java.util.List;

import com.gotop.reportjbpm.dao.IJobWorkloadDao;
import com.gotop.reportjbpm.model.JobWorkload;
import com.primeton.utils.Page;

/**
 * @author gotop
 *
 */
public interface IJobWorkloadService {
	
	IJobWorkloadDao getIJobWorkloadDao();
	void setJobWorkloadDao(IJobWorkloadDao jobWorkloadDao);
	
	/**
	 * 岗位工作量统计查询
	 * @param jobWorkload
	 * @param page
	 * @return
	 */
	List<JobWorkload> jobWorkloadList(JobWorkload jobWorkload,Page page);
	
	/**
	 * 导出excel
	 * @param jobWorkload
	 * @param page
	 * @return
	 */
	
	List<JobWorkload> jobWorkloadListExcel(JobWorkload jobWorkload);
	
	/**
	 * 流程节点查询
	 */
	
	List<JobWorkload> listNodName();

}
