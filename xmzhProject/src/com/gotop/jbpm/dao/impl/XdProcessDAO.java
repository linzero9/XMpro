package com.gotop.jbpm.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.gotop.deviceManagement.dao.impl.DeviceManDetailDAO;
import com.gotop.jbpm.dao.IXdProcessDAO;
import com.gotop.jbpm.model.XdCdtypeBean;
import com.gotop.jbpm.model.XdProcessBean;
import com.gotop.jbpm.model.XdProcessTaskAssignee;
import com.gotop.util.dataSource.SqlMapClientDao;
import com.primeton.utils.Page;

public class XdProcessDAO  extends SqlMapClientDao  implements IXdProcessDAO{

	protected Logger log = Logger.getLogger(DeviceManDetailDAO.class);

	public XdProcessDAO() {
		super();
		// TODO 自动生成的构造函数存根
	}

	@Override
	public List<XdProcessTaskAssignee> queryXdMyToDoList(
			Map<String, Object> map, Page page) {
		
		List<XdProcessTaskAssignee> xdProcessTaskAssignees = this.queryForList("XD_PROCESS_SqlMap.queryXdMyTodoList", map, page);
		return xdProcessTaskAssignees;
	}

	@Override
	public List<XdProcessBean> queryXdProcessList(Map<String, Object> map,
			Page page) {
		List<XdProcessBean> xdProcessBeans = this.queryForList("XD_PROCESS_SqlMap.queryXdProcessList", map, page);
		return xdProcessBeans;
	}

	@Override
	public List queryOneCategoryList(Map<String, Object> map, Page page) {
		List list = queryForList("XD_PROCESS_SqlMap.queryOneCategoryList", map, page);
		return list;
	}

	@Override
	public List queryLoanCategoryList(Map<String, Object> map, Page page) {
		List list = queryForList("XD_PROCESS_SqlMap.queryLoanCategoryList", map, page);
		return list;
	}

	@Override
	public List checkOneCategory(Map<String, Object> map) {
		List list = queryForList("XD_PROCESS_SqlMap.queryOneCategoryList", map);
		return list;
	}

	@Override
	public void insertOneCategory(XdCdtypeBean xdCdtypeBean) {
		getSqlMapClientTemplate().insert("XD_PROCESS_SqlMap.insertOneCategory", xdCdtypeBean);
		
	}

	
}
