package com.gotop.timeMachine.action;

import com.gotop.crm.util.BaseAction;
import com.gotop.crm.util.MUO;
import com.gotop.jbpm.model.TimeBean;
import com.gotop.jbpm.model.WorkTimeSideBean;
import com.gotop.timeMachine.model.TModelTimeday;
import com.gotop.timeMachine.service.ITModelTimedayService;
import com.gotop.util.Struts2Utils;
import com.gotop.util.XmlConvert;
import com.primeton.utils.AjaxParam;
import com.primeton.utils.Page;
import com.primeton.utils.pageCondExpand;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

public class TModelTimedayAction extends BaseAction {
    /**
     * 通过spring注入的Service对象.
     * @abatorgenerated
     */
    protected ITModelTimedayService tModelTimedayService;
    
    private TModelTimeday day;
    
    private  List<TModelTimeday>  days;
    
    
    
    public TModelTimeday getDay() {
		return day;
	}

	public void setDay(TModelTimeday day) {
		this.day = day;
	}

	public List<TModelTimeday> getDays() {
		return days;
	}

	public void setDays(List<TModelTimeday> days) {
		this.days = days;
	}

	/**
     * 通过spring注入Service的set类.
     * @abatorgenerated
     */
    public void settModelTimedayService(ITModelTimedayService tModelTimedayService) {
        this.tModelTimedayService = tModelTimedayService;
    }

    /**
     * 通过spring注入Service的get类.
     * @abatorgenerated
     */
    public ITModelTimedayService gettModelTimedayService() {
        return this.tModelTimedayService;
    }

    

    /**
     * 查询 工作日列表
     * @return
     */
    public String queryWorkDayList() throws Exception {
    	 List<TModelTimeday>  days = this.tModelTimedayService.queryWorkDayListWithPage(day,this.getPage());
    	 this.setDays(days);
        return "workDay_list";
    }
    

    
    
    /**
     * 超限时长报表  hanld
     * 
     * @author wujiajun
     * 
     * @desc  用于处理  超限时长报表 的action
     * 
     * 1.查询出所有的信贷流程，必须为结束
     * 2.循环流程的 flowid 获取到每个流程，然后取到表JBPM4_HIST_ACTINST 的所有记录（就是走过的所有节点）
     * 3.循环JBPM4_HIST_ACTINST   根据 时间表 计算出 是否超时 以及超时时间 （考虑二次提交）
     * 3.计算后的结果存入到 临时表中 
     * 4.查询临时表信息 ，显示到页面 
     * 
     */
    public String hanldTimeReport() throws Exception {
      
        return "timeReport";
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
/*
	 * 跳转到工作日新增页面
	 * @return
	 */
	public String toAddWorkDay(){
		
		return "add_workDay";
	}
	
	
	/**
	 * 校验 非工作日 日期 是否已存在
	 * @throws Exception
	 */
	public void checkDayTime() throws Exception{
		String info ="";
    	try {
    		List list = this.tModelTimedayService.checkDayTime(day);
    		if(list.size() > 0){
    			info = "exist";
    		}else{
    			info = "notExist";
    		}
    		
    	} catch (Exception e) {
			info="fails";
			log.error("[失败！]", e);
			throw e;
		}finally{	
			Struts2Utils.renderText(info);
		}
	}
	
	/**
	 * 保存 新增 非工作日
	 * @throws Exception
	 */
	public void saveWorkDay() throws Exception{
		String info ="success";
		
    	try {
    		day.setOrgcode(this.getCurrentOnlineUser().getOrgcode());
    		day.setEmpid(this.getCurrentOnlineUser().getEmpid());
    		
    		//插入一条新记录
    		this.tModelTimedayService.insertWorkDay(day);
    		
    	} catch (Exception e) {
			info="fails";
			log.error("[失败！]", e);
			throw e;
		}finally{	
			Struts2Utils.renderText(info);
		}
	}
	
	
	/**
	 * 跳转到工作日修改页面
	 * @return
	 */
	public String toUpdateWorkDay(){
		List<TModelTimeday>  days = this.tModelTimedayService.queryWorkDayById(day);
		if(days.size() == 1){
			day.setType(days.get(0).getType());
			day.setTime(days.get(0).getTime());
			day.setRemark(days.get(0).getRemark());
			day.setStatus(days.get(0).getStatus());
		}
   	 	this.setDay(day);
		return "upt_workDay";
	}
	
	/**
	 * 修改 非工作日 数据
	 * @throws Exception
	 */
	public void updateWorkDay() throws Exception{
		String info ="success";
		
    	try {
    		day.setOrgcode(this.getCurrentOnlineUser().getOrgcode());
    		day.setEmpid(this.getCurrentOnlineUser().getEmpid());
    		
    		//修改数据
    		this.tModelTimedayService.updateWorkDayById(day);
    
    	} catch (Exception e) {
			info="fails";
			log.error("[失败！]", e);
			throw e;
		}finally{	
			Struts2Utils.renderText(info);
		}
	}
	
	public void delWorkDay() throws Exception{
		String info ="success";
    	try {
    		 this.tModelTimedayService.delWorkDayById(day);
    		
    	} catch (Exception e) {
			info="fails";
			log.error("[失败！]", e);
			throw e;
		}finally{	
			Struts2Utils.renderText(info);
		}
	}

}