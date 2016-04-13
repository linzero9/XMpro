package com.gotop.reportjbpm.service;

import com.gotop.reportjbpm.dao.IPostWorkloadStatisticsDAO;


public interface IPostWorkloadStatisticsService {
	
	IPostWorkloadStatisticsDAO getPostWorkloadStatisticsDAO();
	
	void setPostWorkloadStatisticsDAO(
			IPostWorkloadStatisticsDAO postWorkloadStatisticsDAO);

}
