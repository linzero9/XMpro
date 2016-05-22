package com.gotop.timeMachine.action;

import com.fr.script.function.ARRAY;
import com.gotop.Generalprocess.model.ProcessModelOne;
import com.gotop.Generalprocess.model.ProcessModelThree;
import com.gotop.crm.util.BaseAction;
import com.gotop.crm.util.MUO;
import com.gotop.jbpm.model.NodeTimeLimitBean;
import com.gotop.jbpm.model.ProTimeModelBean;
import com.gotop.jbpm.model.TimeBean;
import com.gotop.jbpm.model.WorkTimeMainBean;
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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
	 * @author liaomeiting
     * @desc 查询 节假日维护列表
     * @return
     */
    public String queryWorkDayList() throws Exception {
    	if(day == null){
    		day = new TModelTimeday();
    	}
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
    		String flow_id =  xdproForEnd.getFlow_id();
    		map.put("flow_id",flow_id);
    		String process_name = xdproForEnd.getProcess_name();
    		
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
	    			String start = histActinst.getStart();
	    			String end = histActinst.getEnd();
	    			String activity_name = histActinst.getActivity_name();
	    			Double expendtime = getExpendTime(start, end); //计算得到消耗的时间
	    			
	    			//查询节点配置的时限，判断是否超限
					Map<String, Object> map2 = new HashMap<String, Object>();
					map2.put("c_id", proTimeModelBeans.get(0).getC_id());	
					map2.put("activity_name", activity_name);
					List<NodeTimeLimitBean>  nodeTimeLimitBeans = this.tModelTimedayService.queryNodeTimeLimit(map2);
					
					Double timeLimitOne;
					Double timeLimitTwo;
					List list2;
					String operatorname = "";
					if(nodeTimeLimitBeans.size() == 0){
						continue;
					}else{
						
						//得到时间配置表的时限
						timeLimitOne =  nodeTimeLimitBeans.get(0).getTimeLimit();
						timeLimitTwo = nodeTimeLimitBeans.get(0).getTwotimeLimit();
						
						map2.put("htask", histActinst.getHtask());
						operatorname  = (String) this.tModelTimedayService.queryOperatorname(map2);
					}
					
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
								
								overTimeReport.setProcess_name(process_name);
								overTimeReport.setFlow_id(flow_id);
								overTimeReport.setStarttime(start); //节点开始时间
								overTimeReport.setEndtime(end);//节点结束时间
								overTimeReport.setTimeLimitOne(timeLimitOne);//一次提交时限
								overTimeReport.setTimeLimitTwo(timeLimitTwo);//二次提交时限
								overTimeReport.setRn(histActinst.getRn());//标志为一次提交还是二次提交。rn=1表示一次提交,不等于1都为二次提交
								overTimeReport.setExpendtime(expendtime);//节点消耗时长
								
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
								
								overTimeReport.setProcess_name(process_name);
								overTimeReport.setFlow_id(flow_id);
								overTimeReport.setStarttime(start); //节点开始时间
								overTimeReport.setEndtime(end);//节点结束时间
								overTimeReport.setTimeLimitOne(timeLimitOne);//一次提交时限
								overTimeReport.setTimeLimitTwo(timeLimitTwo);//二次提交时限
								overTimeReport.setRn(histActinst.getRn());//标志为一次提交还是二次提交。rn=1表示一次提交,不等于1都为二次提交
								overTimeReport.setExpendtime(expendtime);//节点消耗时长
								
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
    
    /**
     * @author liaomeiting
     * @desc查询超限报表
     * @return
     * @throws Exception
     */
    public String queryOvertimeReport() throws Exception{
    	
    	
    	if(overTimeReport == null){
    		overTimeReport = new OverTimeReport();
    		
    		//得到当次请求的id
    		Long request_id = (Long) this.tModelTimedayService.queryRequestId();
    		
   //（1）首次发起请求，查询超限报表的相关内容insert到临时表里，以供后面的查询使用
    		handleTimeReport(request_id);
    		
    		overTimeReport.setRequest_id(request_id);
    	}
    	
    	
   //（2）不是首次，则只需在之前查询的基础上在临时表里过滤数据 即可，无需再insert
    	
    	//6.分页 查询当次请求request_id的临时表信息 ，显示到页面 
    	List<OverTimeReport> overTimeReports = this.tModelTimedayService.queryOverTimeReportWithPage(overTimeReport, this.getPage());
    	this.setOverTimeReports(overTimeReports);
    	
    	//7.删除当次的请求id的临时表记录
    	 /*this.tModelTimedayService.deleteOverTimeReport(overTimeReport);*/
    	 
    	 return "Report_OverrunCondition";
    }
    
    /**
     * @author liaomeiting
     * @desc导出超限报表
     * @return
     * @throws Exception
     */
    public String queryOvertimeReportExcel() throws Exception{
    	
    	if(overTimeReport == null){
    		overTimeReport = new OverTimeReport();
    		
    		//得到当次请求的id
    		Long request_id = (Long) this.tModelTimedayService.queryRequestId();
    		
   //（1）首次发起请求，查询超限报表的相关内容insert到临时表里，以供后面的查询使用
    		handleTimeReport(request_id);
    		
    		overTimeReport.setRequest_id(request_id);
    	}
    	
    	
   //（2）不是首次，则只需在之前查询的基础上在临时表里过滤数据 即可，无需再insert
    	
    	//6.查询当次请求request_id的临时表信息 ，显示到页面 
    	List<OverTimeReport> overTimeReports = this.tModelTimedayService.queryOverTimeReport(overTimeReport);
    	this.setOverTimeReports(overTimeReports);
    	
    	//7.删除当次的请求id的临时表记录
    	/* this.tModelTimedayService.deleteOverTimeReport(overTimeReport);*/
    	 
    	return "Report_OverrunCondition_excel";
    }
  
    public double  getExpendTime2(String start, String end) throws ParseException{
    	double a = 8;
    	return a;
    }
    /**
     * @author liaomeiting
     * @desc 计算两节点消耗的工作时长
     * @return
     * @throws ParseException
     */
    public double  getExpendTime(String start, String end) throws ParseException{
    	//消耗时间 = （结束时间-开始时间）的工作时长 - 期间的非工作日
    	double expendtime = 0;
    	
    	//例时间的传入格式为20160520115501
    	String my_startDStr = start.substring(0, 8); //节点开始日期。不包含第8位
    	String my_endDStr = end.substring(0, 8); //节点结束日期
    	
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		 Date my_startD = sdf.parse(my_startDStr);//节点开始日期
		 Date my_endD = sdf.parse(my_endDStr);//节点结束日期
		 
		 SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMddHHmmss");
		 Date my_startT = sdf2.parse(start);//节点开始时间
		 Date my_endT = sdf2.parse(end);//节点结束时间
    	
		 SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHH:mm:ss");

    	//得到所有的有效日配置列表
    	List<WorkTimeMainBean> workTimeMainBeans = this.tModelTimedayService.queryWorkTimeMain();  	
    	
    	List<WorkTimeSideBean> workTimeSideBeans = new ArrayList<WorkTimeSideBean>();
    	
    	for (WorkTimeMainBean workTimeMainBean : workTimeMainBeans) {
			String startDStr = workTimeMainBean.getStartDate();
			String endDStr = workTimeMainBean.getEndDate();
			
			 Date startD = sdf.parse(startDStr);
			 Date endD = sdf.parse(endDStr);
			 Date endD2;
			 
			if( my_startD.compareTo(startD) >= 0 && my_endD.compareTo(endD) < 0 ){//因为有效日包前不包后，故不取等号
				//1.节点开始和结束日期在同一个有效日范围内
				
				double everydaytimeSum=0;//每天工作时间和
				double starttimeSum = 0; //第一天工作时间和
				double endtimeSum = 0;//最后一天工作时间和
				
				 //查询该有效日对应的工作时间配置
				 workTimeSideBeans = this.tModelTimedayService.queryWorkTimeSide(workTimeMainBean);  
				 
				for (WorkTimeSideBean workTimeSideBean : workTimeSideBeans) {
					
					String startTStr = workTimeSideBean.getStartTime();
					String endTStr = workTimeSideBean.getEndTime();
					
					//将节点日期与查到的时间字符串连接一起，用于时间比较
					 Date startT1 = sdf3.parse(my_startDStr+startTStr); //为节点开始日期，但开始时间是数据库查的
					 Date startT2 = sdf3.parse(my_endDStr+startTStr);  //为节点结束日期，但开始时间是数据库查的
					 Date endT1 = sdf3.parse(my_startDStr+endTStr);   //为节点开始日期，但结束时间是数据库查的
					 Date endT2 = sdf3.parse(my_endDStr+endTStr);    //为节点结束日期，但结束时间是数据库查的
					
					//A.计算数据库配置的每天工作时间的时间差
					double between_hours = get_betweenHours(startT1, endT1);  //用get_betweenHours(startT2, endT2)也可以，只要日期同一天即可，一个workTimeSideBean的时间差
					everydaytimeSum = everydaytimeSum + between_hours;
					
					double between_hours2 = 0;
					double between_hours3 = 0;
					
					//B.判断传入的开始时间，计算开始的那天工作和
					if( my_startT.compareTo(startT1) > 0 && my_startT.compareTo(endT1) < 0 ){
						
						//a.传入的开始时间my_startTStr 位于workTimeSideBean的某个时间段内，要累加
						between_hours2 = get_betweenHours(my_startT, endT1);
						starttimeSum = starttimeSum + between_hours2;
						
					}else if(my_startT.compareTo(startT1)	<= 0){
						
						//b.传入的开始时间my_startTStr 位于workTimeSideBean的开始时间前面或相等时，要累加
						starttimeSum = starttimeSum + between_hours;
					}else{
						//c.传入的开始时间my_startTStr 位于workTimeSideBean的结束时间后面或相等时，无需累加
					}
					
					//C.判断传入的结束时间，计算结束的那天工作和
					if( my_endT.compareTo(startT2) > 0 && my_endT.compareTo(endT2) < 0 ){
						
						//a.传入的结束时间my_endTStr 位于workTimeSideBean的某个时间段内，要累加
						between_hours3 = get_betweenHours(startT2,my_endT);
						endtimeSum = endtimeSum + between_hours3;
						
					}else if(my_endT.compareTo(endT2)	>= 0){
						
						//b.传入的结束时间my_endTStr 位于workTimeSideBean的结束时间后面或相等时，要累加
						endtimeSum = endtimeSum + between_hours;
					}else{
						//c.传入的结束时间my_endTStr 位于workTimeSideBean的开始时间前面或相等时，无需累加
						continue;
					}
				}
				
				//计算传入开始时间~结束时间 的工作时长总和（=相差天数-周末-节假日+特殊维护的工作日 的工作时长）
				expendtime = get_alltimesum(my_startD, my_endD, starttimeSum, everydaytimeSum, endtimeSum);
				break;	
				
			}else if( (my_startD.compareTo(startD) >=0 && my_startD.compareTo(endD) <0 && my_endD.compareTo(endD) >=0)
					|| (my_startD.compareTo(startD) <0 && my_endD.compareTo(endD) >=0)
					|| (my_startD.compareTo(startD) <0 && my_endD.compareTo(startD) >=0 && my_endD.compareTo(endD) <0) ){
				//2.节点开始和结束日期在两个不同的有效日范围内
				
				double everydaytimeSum=0;//每天工作时间和
				double starttimeSum = 0; //第一天工作时间和
				double endtimeSum = 0;//最后一天工作时间和
				double expendtime1 = 0;
				double expendtime2 = 0;
				double expendtime3 = 0;
				
				 //查询该有效日对应的工作时间配置
				 workTimeSideBeans = this.tModelTimedayService.queryWorkTimeSide(workTimeMainBean);  
				
				if(my_startD.compareTo(startD) >=0 && my_startD.compareTo(endD) <0 && my_endD.compareTo(endD) >=0){
					//(1)节点开始日期在有效日范围内，节点结束日期不在这个时间范围内	
				
					for (WorkTimeSideBean workTimeSideBean : workTimeSideBeans) {
						String startTStr = workTimeSideBean.getStartTime();
						String endTStr = workTimeSideBean.getEndTime();
						
						//将节点日期与查到的时间字符串连接一起，用于时间比较
						 Date startT1 = sdf3.parse(my_startDStr+startTStr); //为节点开始日期，但开始时间是数据库查的
						 Date endT1 = sdf3.parse(my_startDStr+endTStr);   //为节点开始日期，但结束时间是数据库查的
						 
						//A.计算数据库配置的每天工作时间的时间差
						double between_hours = get_betweenHours(startT1, endT1);  //get_betweenHours(startT2, endT2)也可以，只要日期同一天即可，一个workTimeSideBean的时间差
						everydaytimeSum = everydaytimeSum + between_hours;
						
						double between_hours2 = 0;
						
						//B.判断传入的开始时间，计算开始的那天工作和
						if( my_startT.compareTo(startT1) > 0 && my_startT.compareTo(endT1) < 0 ){
							
							//a.传入的开始时间my_startTStr 位于workTimeSideBean的某个时间段内，要累加
							between_hours2 = get_betweenHours(my_startT, endT1);
							starttimeSum = starttimeSum + between_hours2;
							
						}else if(my_startT.compareTo(startT1)	<= 0){
							
							//b.传入的开始时间my_startTStr 位于workTimeSideBean的开始时间前面或相等时，要累加
							starttimeSum = starttimeSum + between_hours;
						}else{
							//c.传入的开始时间my_startTStr 位于workTimeSideBean的结束时间后面或相等时，无需累加
							continue;
						}
						
					}
					
					endtimeSum = everydaytimeSum;
					endD2 = new Date();
					endD2 =sdf.parse(sdf.format(endD)) ; //因为endD有效日结束日期不包含，故需要转换一下，并取前一天
					endD2.setDate(endD2.getDate()-1);
					
					//计算传入开始时间~结束时间 的工作时长总和（=相差天数-周末-节假日+特殊维护的工作日 的工作时长）
					expendtime1 = get_alltimesum(my_startD, endD2, starttimeSum, everydaytimeSum, endtimeSum);
					expendtime = expendtime + expendtime1;
					
				}else if(my_startD.compareTo(startD) <0 && my_endD.compareTo(startD) >=0 && my_endD.compareTo(endD) <0){
					//(2)节点开始日期不在这个时间范围内	，节点结束日期在有效日范围内
					
					for (WorkTimeSideBean workTimeSideBean : workTimeSideBeans) {
						String startTStr = workTimeSideBean.getStartTime();
						String endTStr = workTimeSideBean.getEndTime();
						
						//将节点日期与查到的时间字符串连接一起，用于时间比较
						 Date startT2 = sdf3.parse(my_endDStr+startTStr);  //为节点结束日期，但开始时间是数据库查的
						 Date endT2 = sdf3.parse(my_endDStr+endTStr);    //为节点结束日期，但结束时间是数据库查的
						 
						//A.计算数据库配置的每天工作时间的时间差
						double between_hours = get_betweenHours(startT2, endT2);  //一个workTimeSideBean的时间差
						everydaytimeSum = everydaytimeSum + between_hours;
						
						double between_hours3 = 0;
						
						//B.判断传入的结束时间，计算结束的那天工作和
						if( my_endT.compareTo(startT2) > 0 && my_endT.compareTo(endT2) < 0 ){
							
							//a.传入的结束时间my_endTStr 位于workTimeSideBean的某个时间段内，要累加
							between_hours3 = get_betweenHours(startT2,my_endT);
							endtimeSum = endtimeSum + between_hours3;
							
						}else if(my_endT.compareTo(endT2)	>= 0){
							
							//b.传入的结束时间my_endTStr 位于workTimeSideBean的结束时间后面或相等时，要累加
							endtimeSum = endtimeSum + between_hours;
						}else{
							//c.传入的结束时间my_endTStr 位于workTimeSideBean的开始时间前面或相等时，无需累加
						}
					}
					
					starttimeSum = everydaytimeSum;
					
					//计算传入开始时间~结束时间 的工作时长总和（=相差天数-周末-节假日+特殊维护的工作日 的工作时长）
					expendtime2 = get_alltimesum(startD, my_endD, starttimeSum, everydaytimeSum, endtimeSum);
					expendtime = expendtime + expendtime2;
					
				}else if(my_startD.compareTo(startD) <0 && my_endD.compareTo(endD) >=0){
					//(3)节点开始日期在有效日范围之前，节点结束日期在这个有效日范围之后	
					
					for (WorkTimeSideBean workTimeSideBean : workTimeSideBeans) {
						String startTStr = workTimeSideBean.getStartTime();
						String endTStr = workTimeSideBean.getEndTime();
						
						//将节点日期与查到的时间字符串连接一起，用于时间比较
						 Date startT1 = sdf3.parse(my_startDStr+startTStr); //为节点开始日期，但开始时间是数据库查的
						 Date endT1 = sdf3.parse(my_startDStr+endTStr);   //为节点开始日期，但结束时间是数据库查的
						 
						//A.计算数据库配置的每天工作时间的时间差
						double between_hours = get_betweenHours(startT1, endT1);  //用get_betweenHours(startT2, endT2)也可以，一个workTimeSideBean的时间差
						everydaytimeSum = everydaytimeSum + between_hours;
					}
					
					starttimeSum = everydaytimeSum;
					endtimeSum = everydaytimeSum;
					
					endD2 = new Date();
					endD2 =sdf.parse(sdf.format(endD)) ; //因为endD有效日结束日期不包含，故需要转换一下，并取前一天
					endD2.setDate(endD2.getDate()-1);
					
					//计算传入开始时间~结束时间 的工作时长总和（=相差天数-周末-节假日+特殊维护的工作日 的工作时长）
					expendtime3 = get_alltimesum(startD, endD2, starttimeSum, everydaytimeSum, endtimeSum);
					expendtime = expendtime + expendtime3;
					
				}
			}else{
				//3.节点开始和结束日期都在有效日范围之前 或者 之后
				continue;
			}
    	}  	
    	
    	return expendtime;
    }
    
    
    /**
     * @desc 计算传入开始时间~结束时间 的工作时长总和（=相差天数-周末-节假日+特殊维护的工作日 的工作时长）
     * @author liaomeiting
     * @return
     * @throws ParseException
     */
    public double get_alltimesum(Date startD, Date endD, double starttimeSum, double everydaytimeSum, double endtimeSum) throws ParseException{
    	
    	SimpleDateFormat sd = new SimpleDateFormat("yyyy/MM/dd");
    	
    	//将startD的时间赋给startD2，不能用等号直接赋值，否则当startD2值变了，startD也会跟着累加变化
    	String startDstr = sd.format(startD);
    	String endDstr = sd.format(endD);
    	Date startD2 = sd.parse(startDstr);  //用于日期累加
		
		int between_days = 0;  
		Date startD3;
		List<Date> datelist = new ArrayList<Date>(); //用于存放传入的开始~结束时间里遇到的 周六或周日的日期
		
		//1.判断除去周末所占天数
		while (startD2.compareTo(endD) <= 0) {
			
			if (startD2.getDay() != 6 && startD2.getDay() != 0){  //getDay()=6代表周六， getDay()=0代表周日
				between_days++;  
			}else{
				startD3 = new Date();
				startD3 = sd.parse(sd.format(startD2));
				datelist.add(startD3);
			}
	
			startD2.setDate(startD2.getDate() + 1);  
		}  
		
		double alltimeSum = 0;
		boolean flag1 = false;
		boolean flag2 = false;
		
		for (Date date : datelist) {
			if(date.compareTo(startD) == 0){ //开始日期是周末
				flag1 = true;
			}else if(date.compareTo(endD) == 0){ //结束日期是周末
				flag2 = true;
			}else{
				continue;
			}
		}
		
		if(flag1 == true && flag2 == true){ //开始日期和结束日期都是周末
			alltimeSum = everydaytimeSum * between_days;
		}else if(flag1 == true && flag2 == false){ //开始日期是周末，而结束日期不是周末
			alltimeSum = everydaytimeSum * (between_days-1) + endtimeSum;
		}else if(flag1 == false && flag2 == true){//结束日期是周末，而开始日期不是周末
			alltimeSum = starttimeSum + everydaytimeSum * (between_days-1);
		}else{//开始日期和结束日期都不是周末
			alltimeSum = starttimeSum+everydaytimeSum*(between_days-2)+endtimeSum;
		}
		
		//2.判断为节假日要除去，为特殊维护的工作日要加上
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("startD", startDstr);
		map.put("endD", endDstr);
		
		//查找配置的日期在 传入的日期范围之间 的节假日、工作日
		List<TModelTimeday> list = this.tModelTimedayService.queryWorkDayList(map);
		 
		for (TModelTimeday tModelTimeday : list) { //循环节假日、工作日
			Date timedate =  sd.parse(tModelTimeday.getTime());
			boolean weekend_flag = false; //该标志用于判断节假日是否与周末是同一天，默认不是
			
			for (Date date : datelist) {//循环周末日期
				if(timedate.compareTo(date) == 0){//节假日与周末是同一天
					weekend_flag = true;
					break;
				}
				//节假日与周末不是同一天，则继续判断下一条
			}
			
			//当遇到配置类型为“节假日”，要扣掉
			if( "1".equals(tModelTimeday.getType()) ){
				//节假日是开始日期，且节假日周末不重叠
				if( timedate.compareTo(startD) == 0 && weekend_flag == false ){
					alltimeSum = alltimeSum - starttimeSum;
				}
				
				//节假日是结束日期，且节假日周末不重叠
				if(timedate.compareTo(endD) == 0 && weekend_flag == false){
					alltimeSum = alltimeSum - endtimeSum;
				}
				
				//节假日不是开始日期也不是结束日期，且节假日周末不重叠
				if(timedate.compareTo(startD) != 0 && timedate.compareTo(endD) != 0 && weekend_flag == false){
					alltimeSum = alltimeSum - everydaytimeSum;
				}
			}
			
			//当遇到配置类型为“工作日”，要加上
			if( "2".equals(tModelTimeday.getType()) ){
				//特殊维护的工作日是开始日期，且周末设为工作日
				if(timedate.compareTo(startD) == 0 && weekend_flag == true){
					alltimeSum = alltimeSum + starttimeSum;
				}
				
				//特殊维护的工作日是结束日期，且周末设为工作日
				if(timedate.compareTo(endD) == 0 && weekend_flag == true){
					alltimeSum = alltimeSum + endtimeSum;
				}
				
				//特殊维护的工作日不是开始日期也不是结束日期，且周末设为工作日
				if(timedate.compareTo(startD) != 0 && timedate.compareTo(endD) != 0 && weekend_flag == true){
					alltimeSum = alltimeSum + everydaytimeSum;
				}
			}
				
		}
		
		return alltimeSum;
		
    }
    
    /**
     * @desc 计算两个时间之间相差的小时数
     * @author liaomeiting
     * @param startTStr
     * @param endTStr
     * @return
     * @throws ParseException
     */
    public double get_betweenHours(Date startT, Date endT)  throws ParseException {
    	
    	long diff = endT.getTime() - startT.getTime();
    	double between_hours = diff * 1.0 / (1000 * 60 * 60);  //单位为小时
    	return between_hours;
    }
    
    /*public  void test() throws ParseException {
    	String st = "20160428090000";
    	String et = "20160510151000";
    	double expendtime = getExpendTime(st,et);
    	System.out.println("==============="+expendtime);
	}*/
    
    
/**
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