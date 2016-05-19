package com.gotop.jbpm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts.tiles.xmlDefinition.I18nFactorySet;

import com.gotop.jbpm.dao.ITimeLimitManageDAO;
import com.gotop.jbpm.model.NodeTimeLimitBean;
import com.gotop.jbpm.model.OneAndLoanBean;
import com.gotop.jbpm.model.ProLoanBean;
import com.gotop.jbpm.model.ProTimeModelBean;
import com.gotop.jbpm.model.WorkTimeMainBean;
import com.gotop.jbpm.model.WorkTimeSideBean;
import com.gotop.jbpm.service.ITimeLimitManageService;
import com.primeton.utils.Page;

public class TimeLimitManageService implements ITimeLimitManageService {

	protected Logger log = Logger.getLogger(TimeLimitManageService.class);
	
	protected  ITimeLimitManageDAO timeLimitManageDAO;

	public ITimeLimitManageDAO getTimeLimitManageDAO() {
		return timeLimitManageDAO;
	}

	public void setTimeLimitManageDAO(ITimeLimitManageDAO timeLimitManageDAO) {
		this.timeLimitManageDAO = timeLimitManageDAO;
	}

	@Override
	public List<OneAndLoanBean> queryOneAndLoanList(
			OneAndLoanBean oneAndLoanBean, Page page) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		if(oneAndLoanBean != null){
			if(oneAndLoanBean.getOneCategory_id() != null && !"".equals(oneAndLoanBean.getOneCategory_id())){
				map.put("oneCategory_id", oneAndLoanBean.getOneCategory_id());
			}
		}
		if(oneAndLoanBean != null){
			if(oneAndLoanBean.getLoanCategory_id() != null && !"".equals(oneAndLoanBean.getLoanCategory_id())){
				map.put("loanCategory_id", oneAndLoanBean.getLoanCategory_id());
			}
		}
		
		List<OneAndLoanBean> OneAndLoanBeans = this.timeLimitManageDAO.queryOneAndLoanList(map, page);
		return OneAndLoanBeans;
	}

	@Override
	public List<OneAndLoanBean> checkOneAndLoan(OneAndLoanBean oneAndLoanBean) {
		Map<String, Object> map = new HashMap<String, Object>();
		if(oneAndLoanBean != null){
			if(oneAndLoanBean.getOneCategory_name() != null &&  !"".equals(oneAndLoanBean.getOneCategory_name())){
				map.put("oneCategory_name",  oneAndLoanBean.getOneCategory_name());
			}
			if(oneAndLoanBean.getLoanCategory_name() != null &&  !"".equals(oneAndLoanBean.getLoanCategory_name())){
				map.put("loanCategory_name",  oneAndLoanBean.getLoanCategory_name());
			}
		}
		List list = this.timeLimitManageDAO.checkOneAndLoan(map);
		return list;
	}

	@Override
	public void addOneAndLoan(OneAndLoanBean oneAndLoanBean) {
		this.timeLimitManageDAO.addOneAndLoan(oneAndLoanBean);
	}

	@Override
	public void delOneAndLoan(OneAndLoanBean oneAndLoanBean) {
		this.timeLimitManageDAO.delOneAndLoan(oneAndLoanBean);
	}

	@Override
	public List<ProLoanBean> queryOneCategorylist() {
		Map<String, Object> map = new HashMap<String, Object>();
		List list = this.timeLimitManageDAO.queryOneCategorylist(map);
		return list;
	}
	
	@Override
	public List<ProLoanBean> queryOneCategorylist1(ProLoanBean proLoanBean) {
		Map<String, Object> map = new HashMap<String, Object>();
		if(proLoanBean!=null){
		if (proLoanBean.getProcessName()!=null&&!"".equals(proLoanBean.getProcessName())) {
			
			map.put("processName", proLoanBean.getProcessName());
		}
		}
		List list = this.timeLimitManageDAO.queryOneCategorylist1(map);
		return list;
	}
	

	@Override
	public List<ProLoanBean> queryLoanCategorylist(ProLoanBean proLoanBean) {
		Map<String, Object> map = new HashMap<String, Object>();
		if(proLoanBean != null){
			if(proLoanBean.getOneCategory_name() != null &&  !"".equals(proLoanBean.getOneCategory_name())){
				map.put("oneCategory_name",  proLoanBean.getOneCategory_name());
			}
		}
		List list = this.timeLimitManageDAO.queryLoanCategorylist(map);
		return list;
	}
	
	@Override
	public List<ProLoanBean> queryLoanCategorylist1(ProLoanBean proLoanBean) {
		Map<String, Object> map = new HashMap<String, Object>();
		if(proLoanBean != null){
			if (proLoanBean.getProcessName()!=null&&!"".equals(proLoanBean.getProcessName())) {
				map.put("processName", proLoanBean.getProcessName());
			}
		}
		if(proLoanBean != null){
			if (proLoanBean.getOneCategory_name()!=null&&!"".equals(proLoanBean.getOneCategory_name())) {
				map.put("oneCategory_name", proLoanBean.getOneCategory_name());
			}
		}
		List list = this.timeLimitManageDAO.queryLoanCategorylist1(map);
		return list;
	}

	@Override
	public void insertProTimeLimitModel(ProTimeModelBean proTimeModelBean) {
		this.timeLimitManageDAO.insertProTimeLimitModel(proTimeModelBean);
	}

	@Override
	public void insertProLoanTimeLimit(ProLoanBean proLoanBean2) {
		this.timeLimitManageDAO.insertProLoanTimeLimit(proLoanBean2);
	}

	@Override
	public List<NodeTimeLimitBean> queryNodeTimeLimitList(
			NodeTimeLimitBean nodeTimeLimitBean) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		if(nodeTimeLimitBean != null){
			if(nodeTimeLimitBean.getC_id() != null &&  !"".equals(nodeTimeLimitBean.getC_id())){
				map.put("c_id",  nodeTimeLimitBean.getC_id());
			}
			if(nodeTimeLimitBean.getTaskName() != null &&  !"".equals(nodeTimeLimitBean.getTaskName())){
				map.put("taskName",  nodeTimeLimitBean.getTaskName());
			}
		}
		List list = this.timeLimitManageDAO.queryNodeTimeLimitList(map);
		return list;
	}

	@Override
	public void insertNodeTimeLimit(NodeTimeLimitBean nodeTimeLimitBean) {
		this.timeLimitManageDAO.insertNodeTimeLimit(nodeTimeLimitBean);
	}

	@Override
	public void updateNodeTimeLimit(NodeTimeLimitBean nodeTimeLimitBean) {
		this.timeLimitManageDAO.updateNodeTimeLimit(nodeTimeLimitBean);
	}

	@Override
	public List<ProTimeModelBean> querySelectModel(ProLoanBean proLoanBean) {
		Map<String, Object> map = new HashMap<String, Object>();
		if(proLoanBean != null){
			if(proLoanBean.getDefinitionId()!= null &&  !"".equals(proLoanBean.getDefinitionId())){
				map.put("definitionId",  proLoanBean.getDefinitionId());
			}
		}
		List list = this.timeLimitManageDAO.querySelectModel(map);
		return list;
	}

	@Override
	public List<ProTimeModelBean> checkTimeModelName(
			ProTimeModelBean proTimeModelBean) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		if(proTimeModelBean != null){
			if(proTimeModelBean.getDefinitionId()!= null &&  !"".equals(proTimeModelBean.getDefinitionId())){
				map.put("definitionId",  proTimeModelBean.getDefinitionId());
			}
			if(proTimeModelBean.getTime_modelName()!= null &&  !"".equals(proTimeModelBean.getTime_modelName())){
				map.put("time_modelName",  proTimeModelBean.getTime_modelName());
			}
		}
		List list = this.timeLimitManageDAO.checkTimeModelName(map);
		return list;
	}

	@Override
	public List<OneAndLoanBean> queryProLoanTimeLimit(ProLoanBean proLoanBean) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		if(proLoanBean != null){
			if(proLoanBean.getDefinitionId()!= null &&  !"".equals(proLoanBean.getDefinitionId())){
				map.put("definitionId",  proLoanBean.getDefinitionId());
			}
			if(proLoanBean.getC_id() != null &&  !"".equals(proLoanBean.getC_id())){
				map.put("c_id",  proLoanBean.getC_id());
			}
		}
		List list = this.timeLimitManageDAO.queryProLoanTimeLimit(map);
		return list;
	}

	@Override
	public void updateProLoanTimeLimit(ProLoanBean my_proLoanBean2) {
		this.timeLimitManageDAO.updateProLoanTimeLimit(my_proLoanBean2);
	}

	@Override
	public void deleteTimeLimitManage(ProLoanBean proLoanBean) {
		this.timeLimitManageDAO.deleteTimeLimitManage(proLoanBean);
	}

	@Override
	public void saveWorkTimeIntoTimeMain(
			WorkTimeMainBean workTimeMainBean) {
		
		this.timeLimitManageDAO.saveWorkTimeIntoTimeMain(workTimeMainBean);
	}

	@Override
	public void saveWorkTimeIntoTimeSide(WorkTimeSideBean workTimeSideBean) {
		
		this.timeLimitManageDAO.saveWorkTimeIntoTimeSide(workTimeSideBean);
	}

	@Override
	public List<WorkTimeMainBean> queryValidDayList(Map<String, String> time , Page page) {
		Map<String, Object> map = new HashMap<String, Object>();
		if(time != null){
			if(time.get("query_startDate") != null && !"".equals(time.get("query_startDate"))){
				map.put("query_startDate", time.get("query_startDate"));
			}
			if(time.get("query_endDate") != null && !"".equals(time.get("query_endDate"))){
				map.put("query_endDate", time.get("query_endDate"));
			}
		}
		List list = this.timeLimitManageDAO.queryValidDayList(map, page);
		return list;
	}

	@Override
	public List checkDate(Map<String, String> time) {
		List list = this.timeLimitManageDAO.checkDate(time);
		return list;
	}

	@Override
	public List<WorkTimeSideBean> queryWorkTimeList(
			WorkTimeMainBean workTimeMainBean) {
		
		List list = this.timeLimitManageDAO.queryWorkTimeList(workTimeMainBean);
		return list;
	}

	@Override
	public void updateTimeMain_delState(WorkTimeMainBean workTimeMainBean) {
		this.timeLimitManageDAO.updateTimeMain_delState(workTimeMainBean);
	}

	@Override
	public void updateWorkTimeById(WorkTimeSideBean workTimeSideBean) {
		this.timeLimitManageDAO.updateWorkTimeById(workTimeSideBean);
	}

	@Override
	public void deleteWorkTimeById(WorkTimeSideBean workTimeSideBean) {
		this.timeLimitManageDAO.deleteWorkTimeById(workTimeSideBean);
	}


	@Override
	public List checkWorkTime(Map<String, String> time) {
		List list = this.timeLimitManageDAO.checkWorkTime(time);
		return list;
	}

	
	
}
