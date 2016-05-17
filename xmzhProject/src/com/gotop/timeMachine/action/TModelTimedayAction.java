package com.gotop.timeMachine.action;

import com.gotop.Generalprocess.model.ProcessModelOne;
import com.gotop.Generalprocess.model.ProcessModelThree;
import com.gotop.crm.util.BaseAction;
import com.gotop.crm.util.MUO;
import com.gotop.jbpm.model.NodeTimeLimitBean;
import com.gotop.jbpm.model.ProTimeModelBean;
import com.gotop.jbpm.model.TimeBean;
import com.gotop.jbpm.model.WorkTimeSideBean;
import com.gotop.timeMachine.model.HistActinst;
import com.gotop.timeMachine.model.OverTimeReport;
import com.gotop.timeMachine.model.TModelTimeday;
import com.gotop.timeMachine.model.XdproForEnd;
import com.gotop.timeMachine.service.ITModelTimedayService;
import com.gotop.util.Struts2Utils;
import com.gotop.util.XmlConvert;
import com.opensymphony.xwork2.ActionContext;
import com.primeton.utils.AjaxParam;
import com.primeton.utils.Page;
import com.primeton.utils.pageCondExpand;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    
    private OverTimeReport overTimeReport;
    
    private List<OverTimeReport> overTimeReports;
    
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

    

    public OverTimeReport getOverTimeReport() {
		return overTimeReport;
	}

	public void setOverTimeReport(OverTimeReport overTimeReport) {
		this.overTimeReport = overTimeReport;
	}

	public List<OverTimeReport> getOverTimeReports() {
		return overTimeReports;
	}

	public void setOverTimeReports(List<OverTimeReport> overTimeReports) {
		this.overTimeReports = overTimeReports;
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
     * 超限时长报表  
     * 
     * @author liaomeiting
     * 
     * @desc  用于处理  超限时长报表 的action
     * 
     * 1.查询出所有的信贷流程，当前节点必须为“结束”
     * 2.循环流程的 flowid 获取到每个流程，然后取到表JBPM4_HIST_ACTINST 的所有记录（就是走过的所有节点）
     * 3.循环JBPM4_HIST_ACTINST的所有及节点，将 结束时间 - 开始时间 =时间差，在用时间差-非工作日时间=共消耗的时间
     * 4.消耗的时间-时限表配置的时限， 计算出 是否超时 以及超时时间 （考虑二次提交时限）
     * 5.计算后的结果insert到 临时表中 
     * 6.查询当次请求request_id的临时表信息 ，显示到页面 
     * 7.删除当次请求request_id的临时表记录
     */
    public void handleTimeReport(Long request_id) throws Exception {
    	
      // 1.查询出所有的信贷流程，当前节点必须为“结束
    	List<XdproForEnd> xdproForEnds = this.tModelTimedayService.queryXdproForEnd();
    	
    	//循环每一个信贷流程
    	for (XdproForEnd xdproForEnd : xdproForEnds) {
    		//2.循环流程的 flowid 获取到每个流程
    		Map<String, Object> map = new HashMap<String, Object>();
    		map.put("flow_id", xdproForEnd.getFlow_id());
    		
    		//通过flow_id，查询获取模式一的相关信息
			List<ProcessModelOne> processModelOnes = this.tModelTimedayService.queryModelOne(map);
			
			String custName = "";
			String coOrg = "";
			String oneCategory_name = "";
			String loanCategory_name = "";
			
			if(processModelOnes.size() == 0){
				continue;
			}else{
				custName = processModelOnes.get(0).getCust_Name(); //客户姓名
				coOrg = processModelOnes.get(0).getCoOrganization(); //合作机构
				oneCategory_name = processModelOnes.get(0).getOneCategory();  //一级分类
				loanCategory_name = processModelOnes.get(0).getLoanCategory();  //贷种分类
				
			}
			
			//通过flow_id，查询获取模式三的相关信息
			List<ProcessModelThree> processModelThrees = this.tModelTimedayService.queryModelThree(map);
			String reportTime = "";
			if(processModelThrees.size() != 0){
				reportTime = processModelThrees.get(0).getReporttime();
			}
			
			
			//查询 信贷流程的时限配置的贷种的模版
			map.put("definition_id", xdproForEnd.getDefinition_id());
			map.put("oneCategory_name", oneCategory_name);
			map.put("loanCategory_name", loanCategory_name);
			List<ProTimeModelBean> proTimeModelBeans =  this.tModelTimedayService.queryLoanModel(map);
			
			if(proTimeModelBeans.size() == 0){//无记录，说明没有对应的C_ID，故无节点配置时限，故无需判断该flow_id是否超限
				continue;
			}else{//只有一条记录，因为definedid和DID对应唯一的cid
				
				//通过flow_id，获取到表JBPM4_HIST_ACTINST 的所有记录（就是走过的所有节点）
	    		List<HistActinst> histActinsts = this.tModelTimedayService.queryHistActinst(map);
	    		
	    		//循环每一个节点，得到开始时间和结束时间
	    		for (HistActinst histActinst : histActinsts) {
	    			// 3.循环JBPM4_HIST_ACTINST的所有及节点，将 结束时间 - 开始时间 =时间差，在用时间差-非工作日时间=共消耗的时间
	    			String starttime = histActinst.getStart_();
	    			String endtime = histActinst.getEnd_();
	    			String activity_name = histActinst.getActivity_name_();
	    			Double expendtime = getExpendTime(starttime, endtime); //计算得到消耗的时间
	    			
	    			//查询节点配置的时限，判断是否超限
					Map<String, Object> map2 = new HashMap<String, Object>();
					map2.put("c_id", proTimeModelBeans.get(0).getC_id());	
					map2.put("activity_name", activity_name);
					List<NodeTimeLimitBean>  nodeTimeLimitBeans = this.tModelTimedayService.queryNodeTimeLimit(map2);
					
					//得到时间配置表的时限
					Double timeLimitOne =  nodeTimeLimitBeans.get(0).getTimeLimit();
					Double timeLimitTwo = nodeTimeLimitBeans.get(0).getTwotimeLimit();
					
					map2.put("htask_", histActinst.getHtask_());
					List list2 = this.tModelTimedayService.queryOperatorname(map2);
					String operatorname = ((HashMap<String,String>) list2.get(0)).get("operatorname");
					
					OverTimeReport overTimeReport = new OverTimeReport();
					
					//4.消耗的时间-时限表配置的时限， 计算出 是否超时 以及超时时间 （考虑二次提交时限）
					if(histActinst.getRn() == 1){//说明该节点是首次提交，则只需跟首次提交时限 作比较
						if(timeLimitOne == null){
							continue; //若首次提交时限为空，无需进行超限判断
						}else{
							if(expendtime > timeLimitOne ){
								Double overtime = expendtime - timeLimitOne;
								
								overTimeReport.setReportTime(reportTime);
								overTimeReport.setTaskName(activity_name);
								overTimeReport.setCustName(custName);
								overTimeReport.setLoanCategory_name(loanCategory_name);
								overTimeReport.setOrgname(coOrg);
								overTimeReport.setEmpname(operatorname);
								overTimeReport.setOvertime(overtime);
								//overTimeReport.setRemark(remark);
								overTimeReport.setRequest_id(request_id);
								
								// 5.计算后的结果insert到 临时表中 
								this.tModelTimedayService.insertOverTime(overTimeReport);
							}else{
								continue;
							}
						}
					}
					
					if(histActinst.getRn() != 1){//说明该节点是二次或多次提交，则只需跟二次提交时限 作比较
						if(timeLimitTwo == null){
							continue; //若二次提交时限为空，无需进行超限判断
						}else{
							if(expendtime > timeLimitTwo ){
								Double overtime = expendtime - timeLimitTwo;
								
								overTimeReport.setReportTime(reportTime);
								overTimeReport.setTaskName(activity_name);
								overTimeReport.setCustName(custName);
								overTimeReport.setLoanCategory_name(loanCategory_name);
								overTimeReport.setOrgname(coOrg);
								overTimeReport.setEmpname(operatorname);
								overTimeReport.setOvertime(overtime);
								//overTimeReport.setRemark(remark);
								overTimeReport.setRequest_id(request_id);
								
								// 5.计算后的结果insert到 临时表中 
								this.tModelTimedayService.insertOverTime(overTimeReport);
							}else{
								continue;
							}
						}
					}
					
					
					
				}
			}
			
			
		}
    	
       
    }
    
    public String queryOvertimeReport() throws Exception{
    	if(overTimeReport == null){
    		overTimeReport = new OverTimeReport();
    	}
    	
    	//得到当次请求的id
    	Long request_id = (Long) this.tModelTimedayService.queryRequestId();
    	
    	//查询并insert超限报表的相关内容到临时表里，以供后面的查询使用
		handleTimeReport(request_id);
		
    	
    	//6.分页 查询当次请求request_id的临时表信息 ，显示到页面 
    	overTimeReport.setRequest_id(request_id);
    	List<OverTimeReport> overTimeReports = this.tModelTimedayService.queryOverTimeReport(overTimeReport, this.getPage());
    	this.setOverTimeReports(overTimeReports);
    	
    	//7.删除当次的请求id的临时表记录
    	 this.tModelTimedayService.deleteOverTimeReport(overTimeReport);
    	 
    	 return "Report_OverrunCondition";
    }
    
    public String queryOvertimeReportExcel() throws Exception{
    	if(overTimeReport == null){
    		overTimeReport = new OverTimeReport();
    	}
    	
    	//得到当次请求的id
    	Long request_id = (Long) this.tModelTimedayService.queryRequestId();
    	
    	//查询并insert超限报表的相关内容到临时表里，以供后面的查询使用
    	handleTimeReport(request_id);
    	
    	//6.查询当次请求request_id的临时表信息 ，显示到页面 
    	overTimeReport.setRequest_id(request_id);
    	List<OverTimeReport> overTimeReports = this.tModelTimedayService.queryOverTimeReport(overTimeReport);
    	this.setOverTimeReports(overTimeReports);
    	
    	//7.删除当次的请求id的临时表记录
    	 this.tModelTimedayService.deleteOverTimeReport(overTimeReport);
    	 
    	return "Report_OverrunCondition_excel";
    }
    
    public Double  getExpendTime(String starttime, String endtime){
    	//消耗时间 = 结束时间-开始时间-期间的非工作日
    	Double expendtime = (double) 8;
    	return expendtime;
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
    		day.setTime(day.getTime().trim()); //日期控件会自动在日期后面加空格，故需去空格
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
    		
    		String[] valueArra = day.getTime().split(" ,");  //分隔符为 空格+逗号
    		for(int i=0; i<valueArra.length; i++){
    			day.setTime(valueArra[i]);
    			
    			//插入一条新记录
    			this.tModelTimedayService.insertWorkDay(day);
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