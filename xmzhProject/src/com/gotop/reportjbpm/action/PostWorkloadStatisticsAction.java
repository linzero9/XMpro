package com.gotop.reportjbpm.action;

import com.gotop.crm.util.BaseAction;
import com.gotop.reportjbpm.service.IPostWorkloadStatisticsService;


public class PostWorkloadStatisticsAction extends BaseAction {

	protected IPostWorkloadStatisticsService  postWorkloadStatisticsService;

	
	
	public IPostWorkloadStatisticsService getPostWorkloadStatisticsService() {
		return postWorkloadStatisticsService;
	}



	public void setPostWorkloadStatisticsService(
			IPostWorkloadStatisticsService postWorkloadStatisticsService) {
		this.postWorkloadStatisticsService = postWorkloadStatisticsService;
	}



	public String queryJobWorkload(){
		return "Report_Jobworkload";
	}
}
