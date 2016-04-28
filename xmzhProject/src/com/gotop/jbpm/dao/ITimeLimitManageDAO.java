package com.gotop.jbpm.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gotop.jbpm.model.NodeTimeLimitBean;
import com.gotop.jbpm.model.OneAndLoanBean;
import com.gotop.jbpm.model.ProLoanBean;
import com.gotop.jbpm.model.ProTimeModelBean;
import com.gotop.jbpm.model.WorkTimeMaintainBean;
import com.primeton.utils.Page;

public interface ITimeLimitManageDAO {

	List<OneAndLoanBean> queryOneAndLoanList(Map<String, Object> map,
			Page page);

	List checkOneAndLoan(Map<String, Object> map);

	void addOneAndLoan(OneAndLoanBean oneAndLoanBean);

	int delOneAndLoan(OneAndLoanBean oneAndLoanBean);

	List queryOneCategorylist(Map<String, Object> map);

	List queryLoanCategorylist(Map<String, Object> map);

	void insertProTimeLimitModel(ProTimeModelBean proTimeModelBean);

	void insertProLoanTimeLimit(ProLoanBean proLoanBean2);

	List queryNodeTimeLimitList(Map<String, Object> map);

	void insertNodeTimeLimit(NodeTimeLimitBean nodeTimeLimitBean);

	int updateNodeTimeLimit(NodeTimeLimitBean nodeTimeLimitBean);

	List querySelectModel(Map<String, Object> map);

	List checkTimeModelName(Map<String, Object> map);

	List queryProLoanTimeLimit(Map<String, Object> map);

	int updateProLoanTimeLimit(ProLoanBean my_proLoanBean2);

	int deleteTimeLimitManage(ProLoanBean proLoanBean);

	void saveWorkTimeIntoTimeMain(WorkTimeMaintainBean workTimeMaintainBean);

	void saveWorkTimeIntoTimeSide(WorkTimeMaintainBean workTimeMaintainBean);

}
