package com.gotop.timeMachine.service.impl;

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
import com.gotop.timeMachine.service.ITModelTimedayService;
import com.gotop.util.string.Obj2StrUtils;
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
    	
    	Map<String, Object> map = new HashMap<String, Object>();
		if(day != null){
			if(day.getStartDate()!= null && !"".equals(day.getStartDate())){
				map.put("startDate", day.getStartDate());
			}
			if(day.getEndDate() != null && !"".equals(day.getEndDate())){
				map.put("endDate", day.getEndDate());
			}
		}
        List list = tModelTimedayDAO.queryWorkDayListWithPage(map,page);
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
	public Object queryOperatorname(Map<String, Object> map2) {
		Object object = tModelTimedayDAO.queryOperatorname(map2);
        return object;
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
	public List<OverTimeReport> queryOverTimeReportWithPage(OverTimeReport overTimeReport, Page page) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		if(overTimeReport != null){
			/*if(overTimeReport.getRequest_id() != null && !"".equals(overTimeReport.getRequest_id())){
				map.put("request_id", overTimeReport.getRequest_id());
			}*/
			
			//报单查询开始日期
			if(overTimeReport.getReportStarttime() != null && !"".equals(overTimeReport.getReportStarttime())){
				map.put("reportStarttime", overTimeReport.getReportStarttime());
			}
			//报单查询结束日期
			if(overTimeReport.getReportEndtime()!= null && !"".equals(overTimeReport.getReportEndtime())){
				map.put("reportEndtime", overTimeReport.getReportEndtime());
			}
			
			//客户名称
			if(overTimeReport.getCustName()!= null && !"".equals(overTimeReport.getCustName())){
				map.put("custName", overTimeReport.getCustName());
			}
			//超限人员
			if(overTimeReport.getEmpname()!= null && !"".equals(overTimeReport.getEmpname())){
				map.put("empname", overTimeReport.getEmpname());
			}
			//超限环节
			if(overTimeReport.getTaskName()!= null && !"".equals(overTimeReport.getTaskName())){
				String[] taskName_arr=overTimeReport.getTaskName().split(",");
				String taskName="";
				try {
					//把对象数组的内容用引号与指定分隔符连接,即："A,B,C"  变成  'A','B','C'
					taskName = Obj2StrUtils.join(taskName_arr, String.class, ",");
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				map.put("taskName", taskName);
			}
		}
		List list = this.tModelTimedayDAO.queryOverTimeReportWithPage(map, page);
		return list;
	}

	@Override
	public void deleteOverTimeReport(OverTimeReport overTimeReport) {
		this.tModelTimedayDAO.deleteOverTimeReport(overTimeReport);
	}

	@Override
	public List<OverTimeReport> queryOverTimeReport(
			OverTimeReport overTimeReport) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		if(overTimeReport != null){
			/*if(overTimeReport.getRequest_id() != null && !"".equals(overTimeReport.getRequest_id())){
				map.put("request_id", overTimeReport.getRequest_id());
			}*/
			
			//报单查询开始日期
			if(overTimeReport.getReportStarttime() != null && !"".equals(overTimeReport.getReportStarttime())){
				map.put("reportStarttime", overTimeReport.getReportStarttime());
			}
			//报单查询结束日期
			if(overTimeReport.getReportEndtime()!= null && !"".equals(overTimeReport.getReportEndtime())){
				map.put("reportEndtime", overTimeReport.getReportEndtime());
			}
			
			//客户名称
			if(overTimeReport.getCustName()!= null && !"".equals(overTimeReport.getCustName())){
				map.put("custName", overTimeReport.getCustName());
			}
			//超限人员
			if(overTimeReport.getEmpname()!= null && !"".equals(overTimeReport.getEmpname())){
				map.put("empname", overTimeReport.getEmpname());
			}
			//超限环节
			if(overTimeReport.getTaskName()!= null && !"".equals(overTimeReport.getTaskName())){
				String[] taskName_arr=overTimeReport.getTaskName().split(",");
				String taskName="";
				try {
					//把对象数组的内容用引号与指定分隔符连接,即："A,B,C"  变成  'A','B','C'
					taskName = Obj2StrUtils.join(taskName_arr, String.class, ",");
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				map.put("taskName", taskName);
			}
		}
		
		List list = this.tModelTimedayDAO.queryOverTimeReport(map);
		return list;
	}

	@Override
	public List<WorkTimeMainBean> queryWorkTimeMain() {
		List list = this.tModelTimedayDAO.queryWorkTimeMain();
		return list;
	}

	@Override
	public List<WorkTimeSideBean> queryWorkTimeSide(WorkTimeMainBean workTimeMainBean) {
		List list = this.tModelTimedayDAO.queryWorkTimeSide(workTimeMainBean);
		return list;
	}

	@Override
	public List<TModelTimeday> queryWorkDayList(Map<String, Object> map) {
		List list = this.tModelTimedayDAO.queryWorkDayList(map);
		return list;
	}

	@Override
	public void updateOverTime(OverTimeReport overTimeReport) {
		
		 this.tModelTimedayDAO.updateOverTime(overTimeReport);
	}

	@Override
	public Object queryReportUpdatetime() {
		
		Object object = this.tModelTimedayDAO.queryReportUpdatetime();
		return object;
	}

	@Override
	public List<OverTimeReport> listNodName() {
		
		List list = this.tModelTimedayDAO.listNodName();
		return list;
	}

}