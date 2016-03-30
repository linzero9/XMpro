package com.gotop.jbpm.service;

import com.gotop.jbpm.dao.IXdProcessDAO;

public interface IXdProcessService {

	IXdProcessDAO getXdProcessDAO();
	void setXdProcessDAO(IXdProcessDAO xdProcessDAO);
}
