package com.gotop.reportjbpm.action;

import java.util.List;

import com.gotop.crm.util.BaseAction;
import com.gotop.reportjbpm.dao.IJobWorkloadDao;
import com.gotop.reportjbpm.model.JobWorkload;
import com.gotop.reportjbpm.service.IJobWorkloadService;

public class JobWorkloadAction extends BaseAction{
	
	protected IJobWorkloadService jobWorkloadService;
	private JobWorkload jobWorkload;
	private List<JobWorkload> jobWorkloadList;
	public IJobWorkloadService getJobWorkloadService() {
		return jobWorkloadService;
	}
	public void setJobWorkloadService(IJobWorkloadService jobWorkloadService) {
		this.jobWorkloadService = jobWorkloadService;
	}
	public JobWorkload getJobWorkload() {
		return jobWorkload;
	}
	public void setJobWorkload(JobWorkload jobWorkload) {
		this.jobWorkload = jobWorkload;
	}
	public List<JobWorkload> getJobWorkloadList() {
		return jobWorkloadList;
	}
	public void setJobWorkloadList(List<JobWorkload> jobWorkloadList) {
		this.jobWorkloadList = jobWorkloadList;
	}
	
	
	/**
	 * 查询
	 * @return
	 */
	public String  jobWorkloadLists(){
		
		jobWorkloadList=jobWorkloadService.jobWorkloadList(jobWorkload, this.getPage());
		this.setJobWorkloadList(jobWorkloadList);
		
		return "jobWorkloadLists";
	}
	
	
	/**
	 * excel
	 * @return
	 */
	public String  jobWorkloadExcel(){
		
		if(jobWorkload==null){
			jobWorkload=new JobWorkload();
		}
		jobWorkloadList=jobWorkloadService.jobWorkloadListExcel(jobWorkload);
		this.setJobWorkloadList(jobWorkloadList);
		return "jobWorkloadExcel";
	}

}
