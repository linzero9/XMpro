package com.gotop.timeMachine.dao;

import com.gotop.jbpm.model.WorkTimeMainBean;
import com.gotop.timeMachine.model.OverTimeReport;
import com.gotop.timeMachine.model.TModelTimeday;
import com.primeton.utils.Page;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ITModelTimedayDAO {
    
    /**
     * 分页查询信息
     * @abatorgenerated
     */
    List queryWorkDayListWithPage(Map<String, Object> map, Page page) throws Exception;

	List checkDayTime(TModelTimeday day);

	void insertWorkDay(TModelTimeday day);

	void updateWorkDayById(TModelTimeday day);

	void delWorkDayById(TModelTimeday day);

	List queryWorkDayById(TModelTimeday day);

	List queryXdproForEnd();

	List queryHistActinst(Map<String, Object> map);

	List queryModelOne(Map<String, Object> map);

	List queryLoanModel(Map<String, Object> map);

	List queryNodeTimeLimit(Map<String, Object> map2);

	List queryModelThree(Map<String, Object> map);

	Object queryOperatorname(Map<String, Object> map2);

	void insertOverTime(OverTimeReport overTimeReport);

	Object queryRequestId();

	List queryOverTimeReportWithPage(Map<String, Object> map, Page page);  //分页查询 超限报表

	void deleteOverTimeReport(OverTimeReport overTimeReport);

	List queryOverTimeReport(Map<String, Object> map); //无分页 查询 超限报表

	List queryWorkTimeMain();

	List queryWorkTimeSide(WorkTimeMainBean workTimeMainBean);

	List queryWorkDayList(Map<String, Object> map);

	void updateOverTime(OverTimeReport overTimeReport);

	Object queryReportUpdatetime();

}