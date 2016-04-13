package com.gotop.reportjbpm.dao.impl;

import org.apache.log4j.Logger;

import com.gotop.reportjbpm.dao.IPostWorkloadStatisticsDAO;
import com.gotop.util.dataSource.SqlMapClientDao;

public class PostWorkloadStatisticsDAO  extends SqlMapClientDao implements IPostWorkloadStatisticsDAO {

	protected Logger log = Logger.getLogger(PostWorkloadStatisticsDAO.class);

	public PostWorkloadStatisticsDAO() {
		super();
		// TODO 自动生成的构造函数存根
	}
	
	
}
