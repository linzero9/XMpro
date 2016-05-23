package com.gotop.timeMachine.service;

import com.gotop.Generalprocess.model.ProcessModelOne;
import com.gotop.Generalprocess.model.ProcessModelThree;
import com.gotop.jbpm.model.NodeTimeLimitBean;
import com.gotop.jbpm.model.ProTimeModelBean;
import com.gotop.jbpm.model.WorkTimeMainBean;
import com.gotop.jbpm.model.WorkTimeSideBean;
import com.gotop.timeMachine.dao.ITModelTimedayDAO;
import com.gotop.timeMachine.model.HistActinst;
import com.gotop.timeMachine.model.OverTimeReport;
import com.gotop.timeMachine.model.TModelTimeday;
import com.gotop.timeMachine.model.XdproForEnd;
import com.primeton.utils.Page;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ITModelTimedayService {
    /**
     * 通过spring注入DAO的set类.
     * @abatorgenerated
     */
    void settModelTimedayDAO(ITModelTimedayDAO tModelTimedayDAO) throws Exception;

    /**
     * 通过spring注入DAO的get类.
     * @abatorgenerated
     */
    ITModelTimedayDAO gettModelTimedayDAO() throws Exception;


    /**
     * 分页方式查询列表数据
     * @abatorgenerated
     */
    List queryWorkDayListWithPage(TModelTimeday day, Page page) throws Exception;

	List checkDayTime(TModelTimeday day);

	void insertWorkDay(TModelTimeday day);

	void updateWorkDayById(TModelTimeday day);

	void delWorkDayById(TModelTimeday day);

	List<TModelTimeday> queryWorkDayById(TModelTimeday day);

	List<XdproForEnd> queryXdproForEnd();

	List<HistActinst> queryHistActinst(Map<String, Object> map);

	List<ProcessModelOne> queryModelOne(Map<String, Object> map);

	List<ProTimeModelBean> queryLoanModel(Map<String, Object> map);

	List<NodeTimeLimitBean> queryNodeTimeLimit(Map<String, Object> map2);

	List<ProcessModelThree> queryModelThree(Map<String, Object> map);

	Object queryOperatorname(Map<String, Object> map2);

	void insertOverTime(OverTimeReport overTimeReport);

	Object queryRequestId();

	List<OverTimeReport> queryOverTimeReportWithPage(OverTimeReport overTimeReport, Page page); //分页查询 超限报表

	void deleteOverTimeReport(OverTimeReport overTimeReport);

	List<OverTimeReport> queryOverTimeReport(OverTimeReport overTimeReport); //无分页查询 超限报表

	List<WorkTimeMainBean> queryWorkTimeMain();

	List<WorkTimeSideBean> queryWorkTimeSide(WorkTimeMainBean workTimeMainBean);

	List<TModelTimeday> queryWorkDayList(Map<String, Object> map);

	void updateOverTime(OverTimeReport overTimeReport2);
}