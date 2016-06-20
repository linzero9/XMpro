package com.gotop.timeMachine.dao.impl;

import com.gotop.jbpm.model.WorkTimeMainBean;
import com.gotop.timeMachine.dao.ITModelTimedayDAO;
import com.gotop.timeMachine.model.OverTimeReport;
import com.gotop.timeMachine.model.TModelTimeday;
import com.gotop.util.dataSource.SqlMapClientDao;
import com.primeton.utils.Page;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

public class TModelTimedayDAO extends SqlMapClientDao implements ITModelTimedayDAO {
    /**
     * 
     * @abatorgenerated
     */
    protected Logger log = Logger.getLogger(TModelTimedayDAO.class);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table T_MODEL_TIMEDAY
     *
     * @abatorgenerated 
     */
    public TModelTimedayDAO() {
        super();
    }


    /**
     * 分页查询信息
     * @abatorgenerated
     */
    public List queryWorkDayListWithPage(Map<String, Object> map, Page page) throws Exception {
        List list = queryForList("T_MODEL_TIMEDAY_SqlMap.queryWorkDayListWithPage", map, page);
        return list;
    }


	@Override
	public List checkDayTime(TModelTimeday day) {
		 List list = queryForList("T_MODEL_TIMEDAY_SqlMap.checkDayTime", day);
	        return list;
	}


	@Override
	public void insertWorkDay(TModelTimeday day) {
		getSqlMapClientTemplate().insert("T_MODEL_TIMEDAY_SqlMap.insertWorkDay", day);
	}


	@Override
	public void updateWorkDayById(TModelTimeday day) {
		getSqlMapClientTemplate().update("T_MODEL_TIMEDAY_SqlMap.updateWorkDayById", day);
	}


	@Override
	public void delWorkDayById(TModelTimeday day) {
		getSqlMapClientTemplate().delete("T_MODEL_TIMEDAY_SqlMap.delWorkDayById", day);
	}


	@Override
	public List queryWorkDayById(TModelTimeday day) {
		List list = queryForList("T_MODEL_TIMEDAY_SqlMap.queryWorkDayById", day);
        return list;
	}


	@Override
	public List queryXdproForEnd() {
		List list = queryForList("T_MODEL_TIMEDAY_SqlMap.queryXdproForEnd", null);
        return list;
	}


	@Override
	public List queryHistActinst(Map<String, Object> map) {
		List list = queryForList("T_MODEL_TIMEDAY_SqlMap.queryHistActinst", map);
        return list;
	}


	@Override
	public List queryModelOne(Map<String, Object> map) {
		List list = queryForList("T_GENERALPROCESS_MODELONE_SqlMap.queryModelOne", map);
        return list;
	}


	@Override
	public List queryLoanModel(Map<String, Object> map) {
		List list = queryForList("T_MODEL_TIMEDAY_SqlMap.queryLoanModel", map);
        return list;
	}


	@Override
	public List queryNodeTimeLimit(Map<String, Object> map2) {
		List list = queryForList("T_MODEL_TIMEDAY_SqlMap.queryNodeTimeLimit", map2);
        return list;
	}


	@Override
	public List queryModelThree(Map<String, Object> map) {
		List list = queryForList("T_GENERALPROCESS_MODELTHREE_SqlMap.queryModelThree", map);
        return list;
	}


	@Override
	public Object queryOperatorname(Map<String, Object> map2) {
		Object object = queryForObject("T_MODEL_TIMEDAY_SqlMap.queryOperatorname", map2);
        return object;
	}


	@Override
	public void insertOverTime(OverTimeReport overTimeReport) {
		getSqlMapClientTemplate().insert("T_MODEL_TIMEDAY_SqlMap.insertOverTime", overTimeReport);
	}


	@Override
	public Object  queryRequestId() {
		Object object = queryForObject("T_MODEL_TIMEDAY_SqlMap.queryRequestId");
        return object;
	}


	@Override
	public List queryOverTimeReportWithPage(Map<String, Object> map , Page page) {
		List list = queryForList("T_MODEL_TIMEDAY_SqlMap.queryOverTimeReport", map, page);
        return list;
	}


	@Override
	public void deleteOverTimeReport(OverTimeReport overTimeReport) {
		getSqlMapClientTemplate().delete("T_MODEL_TIMEDAY_SqlMap.deleteOverTimeReport", overTimeReport);
	}


	@Override
	public List queryOverTimeReport(Map<String, Object> map) {
		List list = queryForList("T_MODEL_TIMEDAY_SqlMap.queryOverTimeReport", map);
        return list;
	}


	@Override
	public List queryWorkTimeMain() {
		List list = queryForList("T_MODEL_TIMEDAY_SqlMap.queryWorkTimeMain", null);
        return list;
	}


	@Override
	public List queryWorkTimeSide(WorkTimeMainBean workTimeMainBean) {
		List list = queryForList("T_MODEL_TIMEDAY_SqlMap.queryWorkTimeSide", workTimeMainBean);
        return list;
	}


	@Override
	public List queryWorkDayList(Map<String, Object> map) {
		List list = queryForList("T_MODEL_TIMEDAY_SqlMap.queryWorkDayList", map);
        return list;
	}


	@Override
	public void updateOverTime(OverTimeReport overTimeReport) {
		
		getSqlMapClientTemplate().update("T_MODEL_TIMEDAY_SqlMap.updateOverTime", overTimeReport);
	}


	@Override
	public Object queryReportUpdatetime() {
		Object object = queryForObject("T_MODEL_TIMEDAY_SqlMap.queryReportUpdatetime");
		return  object;
	}


	@Override
	public List listNodName() {
		List list = queryForList("T_MODEL_TIMEDAY_SqlMap.listNodName", null);
        return list;
	}


	@Override
	public List queryXdproForNotEnd() {
		
		List list = queryForList("T_MODEL_TIMEDAY_SqlMap.queryXdproForNotEnd", null);
        return list;
	}


	@Override
	public List queryOverTimeReport2(Map<String, Object> map, Page page) {
		
		List list;
		if(page == null){
			
			list = queryForList("T_MODEL_TIMEDAY_SqlMap.queryOverTimeReportNotEnd", map);
		}else{
			list = queryForList("T_MODEL_TIMEDAY_SqlMap.queryOverTimeReportNotEnd", map, page);
		}
        return list;
	}


	@Override
	public void insertOverTime2(OverTimeReport overTimeReport) {
		
		getSqlMapClientTemplate().insert("T_MODEL_TIMEDAY_SqlMap.insertOverTimeNotEnd", overTimeReport);
	}


	@Override
	public void deleteOverTimeReport2(OverTimeReport overTimeReport) {
		
		getSqlMapClientTemplate().delete("T_MODEL_TIMEDAY_SqlMap.deleteOverTimeReportNotEnd", overTimeReport);
		
	}

}