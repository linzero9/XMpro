package com.gotop.jbpm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.gotop.jbpm.dao.ITimeLimitManageDAO;
import com.gotop.jbpm.model.NodeTimeLimitBean;
import com.gotop.jbpm.model.OneAndLoanBean;
import com.gotop.jbpm.model.ProLoanBean;
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
	public void insertProTimeLimitModel(ProLoanBean proLoanBean) {
		this.timeLimitManageDAO.insertProTimeLimitModel(proLoanBean);
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
	
	
}
