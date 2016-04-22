package com.gotop.jbpm.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.gotop.jbpm.dao.ITimeLimitManageDAO;
import com.gotop.jbpm.model.NodeTimeLimitBean;
import com.gotop.jbpm.model.OneAndLoanBean;
import com.gotop.jbpm.model.ProLoanBean;
import com.gotop.util.dataSource.SqlMapClientDao;
import com.primeton.utils.Page;

public class TimeLimitManageDAO extends SqlMapClientDao  implements ITimeLimitManageDAO{

	protected Logger log = Logger.getLogger(TimeLimitManageDAO.class);

	public TimeLimitManageDAO() {
		super();
		// TODO 自动生成的构造函数存根
	}

	@Override
	public List<OneAndLoanBean> queryOneAndLoanList(
			Map<String, Object> map, Page page) {
		
		List<OneAndLoanBean> oneAndLoanBeans = this.queryForList("TimeLimitManage_SqlMap.queryOneAndLoanList", map, page);
		return oneAndLoanBeans;
	}

	@Override
	public List checkOneAndLoan(Map<String, Object> map) {
		List list = queryForList("TimeLimitManage_SqlMap.checkOneAndLoan", map);
		return list;
	}

	@Override
	public void addOneAndLoan(OneAndLoanBean oneAndLoanBean) {
		getSqlMapClientTemplate().insert("TimeLimitManage_SqlMap.addOneAndLoan", oneAndLoanBean);
		
	}

	@Override
	public int delOneAndLoan(OneAndLoanBean oneAndLoanBean) {
		int rows = getSqlMapClientTemplate().delete("TimeLimitManage_SqlMap.delOneAndLoan", oneAndLoanBean);
        return rows;
	}

	@Override
	public List queryOneCategorylist(Map<String, Object> map) {
		List list = queryForList("TimeLimitManage_SqlMap.queryOneCategorylist", map);
		return list;
	}

	@Override
	public List queryLoanCategorylist(Map<String, Object> map) {
		List list = queryForList("TimeLimitManage_SqlMap.queryLoanCategorylist", map);
		return list;
	}

	@Override
	public void insertProTimeLimitModel(ProLoanBean proLoanBean) {
		getSqlMapClientTemplate().insert("TimeLimitManage_SqlMap.insertProTimeLimitModel",proLoanBean);
	}

	@Override
	public void insertProLoanTimeLimit(ProLoanBean proLoanBean2) {
		getSqlMapClientTemplate().insert("TimeLimitManage_SqlMap.insertProLoanTimeLimit", proLoanBean2);
	}

	@Override
	public List queryNodeTimeLimitList(Map<String, Object> map) {
		List list = queryForList("TimeLimitManage_SqlMap.queryNodeTimeLimitList", map);
		return list;
	}

	@Override
	public void insertNodeTimeLimit(NodeTimeLimitBean nodeTimeLimitBean) {
		getSqlMapClientTemplate().insert("TimeLimitManage_SqlMap.insertNodeTimeLimit", nodeTimeLimitBean);
	}

	@Override
	public int updateNodeTimeLimit(NodeTimeLimitBean nodeTimeLimitBean) {
		int count = getSqlMapClientTemplate().update("TimeLimitManage_SqlMap.updateNodeTimeLimit", nodeTimeLimitBean);
		return count;
	}

}
