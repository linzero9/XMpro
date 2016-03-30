package com.gotop.jbpm.service.impl;

import org.apache.log4j.Logger;

import com.gotop.jbpm.dao.IXdProcessDAO;
import com.gotop.jbpm.service.IXdProcessService;

public class XdProcessService implements IXdProcessService {

	protected Logger log = Logger.getLogger(XdProcessService.class);
	
	protected IXdProcessDAO xdProcessDAO;
	
	public IXdProcessDAO getXdProcessDAO() {
		return xdProcessDAO;
	}
	public void setXdProcessDAO(IXdProcessDAO xdProcessDAO) {
		this.xdProcessDAO = xdProcessDAO;
	}
	
}
