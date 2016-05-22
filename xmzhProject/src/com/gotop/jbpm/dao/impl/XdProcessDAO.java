package com.gotop.jbpm.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.gotop.deviceManagement.dao.impl.DeviceManDetailDAO;
import com.gotop.jbpm.dao.IXdProcessDAO;
import com.gotop.jbpm.model.WaterInfo;
import com.gotop.jbpm.model.WorkTimeBean;
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
		List list = queryForList("XD_PROCESS_SqlMap.queryOneCategoryList2", map);
		return list;
	}

	@Override
	public void insert(XdCdtypeBean xdCdtypeBean) {
		getSqlMapClientTemplate().insert("XD_PROCESS_SqlMap.insert", xdCdtypeBean);
		
	}


	@Override
	public int delete(XdCdtypeBean xdCdtypeBean) {
		int rows = getSqlMapClientTemplate().delete("XD_PROCESS_SqlMap.delete", xdCdtypeBean);
        return rows;
	}

	@Override
	public List checkLoanCategory(Map<String, Object> map) {
		List list = queryForList("XD_PROCESS_SqlMap.queryLoanCategoryList", map);
		return list;
	}

	@Override
	public List<XdProcessTaskAssignee> queryXdStartProcessList(
			Map<String, Object> map, Page page) {
		
		List<XdProcessTaskAssignee> xdProcessTaskAssignees = this.queryForList("XD_PROCESS_SqlMap.queryXdStartProcessList", map, page);
		return xdProcessTaskAssignees;
	}

	@Override
	public int uptModelOneInfo(XdProcessTaskAssignee xdProcessTaskAssignee) {
		int count = getSqlMapClientTemplate().update("XD_PROCESS_SqlMap.uptModelOneInfo", xdProcessTaskAssignee);
		return count;
	}

	@Override
	public void insertWater(WaterInfo waterInfo) {
		getSqlMapClientTemplate().insert("XD_PROCESS_SqlMap.insertWater", waterInfo);
		
	}
	/**
	 * 更新流程标题
	 */
	@Override
	public void updateTitle(XdProcessTaskAssignee xdProcessTaskAssignee) {
		getSqlMapClientTemplate().update("XD_PROCESS_SqlMap.updateTitle", xdProcessTaskAssignee);
		
	}

	@Override
	public List<WaterInfo> queryLoanUptWater(Map<String, Object> map, Page page) {
		List list = queryForList("XD_PROCESS_SqlMap.queryLoanUptWater", map, page);
		return list;
	}

	@Override
	public List<WorkTimeBean> queryWorkTime(Map<String, Object> map) {
		List list = queryForList("XD_PROCESS_SqlMap.queryWorkTime", map);
		return list;
	}

	@Override
	public void insertWorkTime(WorkTimeBean workTimeBean) {
		getSqlMapClientTemplate().insert("XD_PROCESS_SqlMap.insertWorkTime", workTimeBean);
		
	}

	@Override
	public int updateWorkTime(WorkTimeBean workTimeBean) {
		int count = getSqlMapClientTemplate().update("XD_PROCESS_SqlMap.updateWorkTime", workTimeBean);
		return count;
	}
//修改模式三保单次数
	@Override
	public int uptModelThreeInfo(XdProcessTaskAssignee xdProcessTaskAssignee) {
		int count = getSqlMapClientTemplate().update("XD_PROCESS_SqlMap.uptModelThreeInfo", xdProcessTaskAssignee);
		return count;
	}


}
