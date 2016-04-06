package com.gotop.jbpm.service;

import java.util.List;

import com.gotop.jbpm.dao.IXdProcessDAO;
import com.gotop.jbpm.model.XdCdtypeBean;
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

	List<XdCdtypeBean> queryOneCategoryList(XdCdtypeBean xdCdtypeBean,
			Page page);
	
	List<XdCdtypeBean> queryLoanCategoryList(XdCdtypeBean xdCdtypeBean2,
			Page page);

	List<XdCdtypeBean> checkOneCategory(XdCdtypeBean xdCdtypeBean);

	void insertOneCategory(XdCdtypeBean xdCdtypeBean);
	
}
