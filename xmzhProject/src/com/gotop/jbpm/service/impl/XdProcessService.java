package com.gotop.jbpm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.gotop.jbpm.dao.IXdProcessDAO;
import com.gotop.jbpm.model.XdProcessBean;
import com.gotop.jbpm.model.XdProcessTaskAssignee;
import com.gotop.jbpm.service.IXdProcessService;
import com.primeton.utils.Page;

public class XdProcessService implements IXdProcessService {

	protected Logger log = Logger.getLogger(XdProcessService.class);
	
	protected IXdProcessDAO xdProcessDAO;
	
	public IXdProcessDAO getXdProcessDAO() {
		return xdProcessDAO;
	}
	public void setXdProcessDAO(IXdProcessDAO xdProcessDAO) {
		this.xdProcessDAO = xdProcessDAO;
	}
	@Override
	public List<XdProcessTaskAssignee> queryXdMyToDoList(
			XdProcessTaskAssignee xdProcessTaskAssignee, Page page) {
		Map<String, Object> map = new HashMap<String, Object>();
		if(xdProcessTaskAssignee != null){
			if(xdProcessTaskAssignee.getCustName() != null && !"".equals(xdProcessTaskAssignee.getCustName())){
				map.put("custName", xdProcessTaskAssignee.getCustName());
			}
			if(xdProcessTaskAssignee.getOneCategory() != null && !"".equals(xdProcessTaskAssignee.getOneCategory())){
				map.put("oneCategoryId", xdProcessTaskAssignee.getOneCategoryId());
			}
			if(xdProcessTaskAssignee.getLoanCategory() != null && !"".equals(xdProcessTaskAssignee.getLoanCategory())){
				map.put("loanCategoryId", xdProcessTaskAssignee.getLoanCategoryId());
			}
		}
		List<XdProcessTaskAssignee> xdProcessTaskAssignees = this.xdProcessDAO.queryXdMyToDoList(map, page);
		return xdProcessTaskAssignees;
	}
	@Override
	public List<XdProcessBean> queryXdProcessList(XdProcessBean xdProcessBean,
			Page page) {
		Map<String, Object> map = new HashMap<String, Object>();
		if(xdProcessBean != null){
			if(xdProcessBean.getProcessName() != null && !"".equals(xdProcessBean.getProcessName())){
				map.put("processName", xdProcessBean.getProcessName());
			}
		}
		List<XdProcessBean> xdProcessBeans = this.xdProcessDAO.queryXdProcessList(map, page);
		return xdProcessBeans;
	}
	
}
