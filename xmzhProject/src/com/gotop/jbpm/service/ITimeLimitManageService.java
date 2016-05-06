package com.gotop.jbpm.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gotop.jbpm.dao.ITimeLimitManageDAO;
import com.gotop.jbpm.model.NodeTimeLimitBean;
import com.gotop.jbpm.model.OneAndLoanBean;
import com.gotop.jbpm.model.ProLoanBean;
import com.gotop.jbpm.model.ProTimeModelBean;
import com.gotop.jbpm.model.WorkTimeMainBean;
import com.gotop.jbpm.model.WorkTimeSideBean;
import com.primeton.utils.Page;

public interface ITimeLimitManageService {

	ITimeLimitManageDAO getTimeLimitManageDAO();

	void setTimeLimitManageDAO(ITimeLimitManageDAO timeLimitManageDAO) ;

	List<OneAndLoanBean> queryOneAndLoanList(OneAndLoanBean oneAndLoanBean,
			Page page);

	List<OneAndLoanBean> checkOneAndLoan(OneAndLoanBean oneAndLoanBean);

	void addOneAndLoan(OneAndLoanBean oneAndLoanBean);

	void delOneAndLoan(OneAndLoanBean oneAndLoanBean);

	List<ProLoanBean> queryOneCategorylist();

	List<ProLoanBean> queryLoanCategorylist(ProLoanBean proLoanBean);

	void insertProTimeLimitModel(ProTimeModelBean proTimeModelBean);

	void insertProLoanTimeLimit(ProLoanBean proLoanBean2);

	List<NodeTimeLimitBean> queryNodeTimeLimitList(
			NodeTimeLimitBean nodeTimeLimitBean);

	void insertNodeTimeLimit(NodeTimeLimitBean nodeTimeLimitBean);

	void updateNodeTimeLimit(NodeTimeLimitBean nodeTimeLimitBean);

	List<ProTimeModelBean> querySelectModel(ProLoanBean proLoanBean);

	List<ProTimeModelBean> checkTimeModelName(ProTimeModelBean proTimeModelBean);

	List<OneAndLoanBean> queryProLoanTimeLimit(ProLoanBean proLoanBean);

	void updateProLoanTimeLimit(ProLoanBean my_proLoanBean2);

	void deleteTimeLimitManage(ProLoanBean proLoanBean);

	void saveWorkTimeIntoTimeMain(WorkTimeMainBean workTimeMaintainBean);

	void saveWorkTimeIntoTimeSide(WorkTimeSideBean workTimeSideBean);

	List<WorkTimeMainBean> queryValidDayList(Map<String, String> time, Page page);

	List checkDate(Map<String, String> time);

	List<WorkTimeSideBean> queryWorkTimeList(WorkTimeMainBean workTimeMainBean);

	void updateTimeMain_delState(WorkTimeMainBean workTimeMainBean);
}
