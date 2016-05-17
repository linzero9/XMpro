package com.gotop.timeMachine.service.impl;

import com.gotop.Generalprocess.model.ProcessModelOne;
import com.gotop.Generalprocess.model.ProcessModelThree;
import com.gotop.jbpm.model.NodeTimeLimitBean;
import com.gotop.jbpm.model.ProTimeModelBean;
import com.gotop.timeMachine.dao.ITModelTimedayDAO;
import com.gotop.timeMachine.model.HistActinst;
import com.gotop.timeMachine.model.OverTimeReport;
import com.gotop.timeMachine.model.TModelTimeday;
import com.gotop.timeMachine.model.XdproForEnd;
import com.gotop.timeMachine.service.ITModelTimedayService;
import com.primeton.utils.Page;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

public class TModelTimedayService implements ITModelTimedayService {
    /**
     * 
     * @abatorgenerated
     */
    protected Logger log = Logger.getLogger(TModelTimedayService.class);

    /**
     * 通过spring注入的DAO对象.
     * @abatorgenerated
     */
    protected ITModelTimedayDAO tModelTimedayDAO;

    /**
     * 通过spring注入DAO的set类.
     * @abatorgenerated
     */
    public void settModelTimedayDAO(ITModelTimedayDAO tModelTimedayDAO) throws Exception {
        this.tModelTimedayDAO = tModelTimedayDAO;
    }

    /**
     * 通过spring注入DAO的get类.
     * @abatorgenerated
     */
    public ITModelTimedayDAO gettModelTimedayDAO() throws Exception {
        return this.tModelTimedayDAO;
    }


    /**
     * 分页方式查询列表数据
     * @abatorgenerated
     */
    public List queryWorkDayListWithPage(TModelTimeday day, Page page) throws Exception {
        List list = tModelTimedayDAO.queryWorkDayListWithPage(day,page);
        return list;
    }

	@Override
	public List checkDayTime(TModelTimeday day) {
		List list = tModelTimedayDAO.checkDayTime(day);
        return list;
	}

	@Override
	public void insertWorkDay(TModelTimeday day) {
		this.tModelTimedayDAO.insertWorkDay(day);
	}

	@Override
	public void updateWorkDayById(TModelTimeday day) {
		this.tModelTimedayDAO.updateWorkDayById(day);
	}

	@Override
	public void delWorkDayById(TModelTimeday day) {
		this.tModelTimedayDAO.delWorkDayById(day);
	}

	@Override
	public List<TModelTimeday> queryWorkDayById(TModelTimeday day) {
		List list = tModelTimedayDAO.queryWorkDayById(day);
        return list;
	}

	@Override
	public List<XdproForEnd> queryXdproForEnd() {
		//Map<String, Object> map = new HashMap<String, Object>();
		List list = tModelTimedayDAO.queryXdproForEnd();
        return list;
	}

	@Override
	public List<HistActinst> queryHistActinst(Map<String, Object> map) {
		List list = tModelTimedayDAO.queryHistActinst(map);
        return list;
	}

	@Override
	public List<ProcessModelOne> queryModelOne(Map<String, Object> map) {
		List list = tModelTimedayDAO.queryModelOne(map);
        return list;
	}

	@Override
	public List<ProTimeModelBean> queryLoanModel(Map<String, Object> map) {
		List list = tModelTimedayDAO.queryLoanModel(map);
        return list;
	}

	@Override
	public List<NodeTimeLimitBean> queryNodeTimeLimit(Map<String, Object> map2) {
		List list = tModelTimedayDAO.queryNodeTimeLimit(map2);
        return list;
	}

	@Override
	public List<ProcessModelThree> queryModelThree(Map<String, Object> map) {
		List list = tModelTimedayDAO.queryModelThree(map);
        return list;
	}

	@Override
	public List queryOperatorname(Map<String, Object> map2) {
		List list = tModelTimedayDAO.queryOperatorname(map2);
        return list;
	}

	@Override
	public void insertOverTime(OverTimeReport overTimeReport) {
		this.tModelTimedayDAO.insertOverTime(overTimeReport);
	}

	@Override
	public Object queryRequestId() {
		Object object = this.tModelTimedayDAO.queryRequestId();
		return object;
	}

	@Override
	public List<OverTimeReport> queryOverTimeReport(OverTimeReport overTimeReport, Page page) {
		List list = this.tModelTimedayDAO.queryOverTimeReport(overTimeReport, page);
		return list;
	}

	@Override
	public void deleteOverTimeReport(OverTimeReport overTimeReport) {
		this.tModelTimedayDAO.deleteOverTimeReport(overTimeReport);
	}

	@Override
	public List<OverTimeReport> queryOverTimeReport(
			OverTimeReport overTimeReport) {
		List list = this.tModelTimedayDAO.queryOverTimeReport(overTimeReport);
		return list;
	}

}