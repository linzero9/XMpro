package com.gotop.jbpm.service;

import java.util.List;

import com.gotop.jbpm.dao.IXdProcessDAO;
import com.gotop.jbpm.model.XdProcessBean;
import com.gotop.jbpm.model.XdProcessTaskAssignee;
import com.primeton.utils.Page;

public interface IXdProcessService {

	IXdProcessDAO getXdProcessDAO();
	
	void setXdProcessDAO(IXdProcessDAO xdProcessDAO);
	
	List<XdProcessTaskAssignee> queryXdMyToDoList(
			XdProcessTaskAssignee xdProcessTaskAssignee, Page page);

	List<XdProcessBean> queryXdProcessList(XdProcessBean xdProcessBean,
			Page page);
	
}
