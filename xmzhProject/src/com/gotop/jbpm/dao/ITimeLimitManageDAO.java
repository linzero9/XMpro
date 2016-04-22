package com.gotop.jbpm.dao;

import java.util.List;
import java.util.Map;

import com.gotop.jbpm.model.NodeTimeLimitBean;
import com.gotop.jbpm.model.OneAndLoanBean;
import com.gotop.jbpm.model.ProLoanBean;
import com.primeton.utils.Page;

public interface ITimeLimitManageDAO {

	List<OneAndLoanBean> queryOneAndLoanList(Map<String, Object> map,
			Page page);

	List checkOneAndLoan(Map<String, Object> map);

	void addOneAndLoan(OneAndLoanBean oneAndLoanBean);

	int delOneAndLoan(OneAndLoanBean oneAndLoanBean);

	List queryOneCategorylist(Map<String, Object> map);

	List queryLoanCategorylist(Map<String, Object> map);

	void insertProTimeLimitModel(ProLoanBean proLoanBean);

	void insertProLoanTimeLimit(ProLoanBean proLoanBean2);

	List queryNodeTimeLimitList(Map<String, Object> map);

	void insertNodeTimeLimit(NodeTimeLimitBean nodeTimeLimitBean);

	int updateNodeTimeLimit(NodeTimeLimitBean nodeTimeLimitBean);

}
