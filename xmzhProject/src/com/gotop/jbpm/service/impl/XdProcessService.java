package com.gotop.jbpm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.gotop.jbpm.dao.IXdProcessDAO;
import com.gotop.jbpm.model.XdCdtypeBean;
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
	@Override
	public List<XdCdtypeBean> queryOneCategoryList(
			XdCdtypeBean xdCdtypeBean, Page page) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		if(xdCdtypeBean != null){
			if(xdCdtypeBean.getProcessName() != null &&  !"".equals(xdCdtypeBean.getProcessName())){
				map.put("processName",  xdCdtypeBean.getProcessName());
			}
			if(xdCdtypeBean.getOneCategory()!= null &&  !"".equals(xdCdtypeBean.getOneCategory())){
				map.put("oneCategory",  xdCdtypeBean.getOneCategory());
			}
		}
		List list = xdProcessDAO.queryOneCategoryList(map,page);
        return list;
	}
	@Override
	public List<XdCdtypeBean> queryLoanCategoryList(
			XdCdtypeBean xdCdtypeBean2, Page page) {
		Map<String, Object> map = new HashMap<String, Object>();
		if(xdCdtypeBean2 != null){
			if(xdCdtypeBean2.getProcessName() != null &&  !"".equals(xdCdtypeBean2.getProcessName())){
				map.put("processName",  xdCdtypeBean2.getProcessName());
			}
			if(xdCdtypeBean2.getOneCategory()!= null &&  !"".equals(xdCdtypeBean2.getOneCategory())){
				map.put("oneCategory",  xdCdtypeBean2.getOneCategory());
			}
		}
		List list = xdProcessDAO.queryLoanCategoryList(map,page);
        return list;
	}
	@Override
	public List<XdCdtypeBean> checkOneCategory(XdCdtypeBean xdCdtypeBean) {
		Map<String, Object> map = new HashMap<String, Object>();
		if(xdCdtypeBean != null){
			if(xdCdtypeBean.getProcessName() != null &&  !"".equals(xdCdtypeBean.getProcessName())){
				map.put("processName",  xdCdtypeBean.getProcessName());
			}
			if(xdCdtypeBean.getOneCategory()!= null &&  !"".equals(xdCdtypeBean.getOneCategory())){
				map.put("oneCategory",  xdCdtypeBean.getOneCategory());
			}
		}
		List list = xdProcessDAO.checkOneCategory(map);
		return list;
	}
	@Override
	public void insertOneCategory(XdCdtypeBean xdCdtypeBean) {
		xdProcessDAO.insertOneCategory(xdCdtypeBean);
		
	}

	
}
