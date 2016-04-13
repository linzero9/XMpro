package com.gotop.reportjbpm.service.impl;

import org.apache.log4j.Logger;

import com.gotop.reportjbpm.dao.IPostWorkloadStatisticsDAO;
import com.gotop.reportjbpm.service.IPostWorkloadStatisticsService;

public class PostWorkloadStatisticsService implements
		IPostWorkloadStatisticsService {

	protected Logger log = Logger.getLogger(PostWorkloadStatisticsService.class);
	
	protected IPostWorkloadStatisticsDAO postWorkloadStatisticsDAO;

	public IPostWorkloadStatisticsDAO getPostWorkloadStatisticsDAO() {
		return postWorkloadStatisticsDAO;
	}

	public void setPostWorkloadStatisticsDAO(
			IPostWorkloadStatisticsDAO postWorkloadStatisticsDAO) {
		this.postWorkloadStatisticsDAO = postWorkloadStatisticsDAO;
	}

	
	
}
