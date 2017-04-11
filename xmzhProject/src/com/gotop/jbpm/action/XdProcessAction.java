package com.gotop.jbpm.action;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.derby.tools.sysinfo;

import com.gotop.Generalprocess.util.SpringPropertyResourceReader;
import com.gotop.crm.util.BaseAction;
import com.gotop.jbpm.model.WaterInfo;
import com.gotop.jbpm.model.WorkTimeBean;
import com.gotop.jbpm.model.XdCdtypeBean;
import com.gotop.jbpm.model.XdProcessBean;
import com.gotop.jbpm.model.XdProcessTaskAssignee;
import com.gotop.jbpm.service.IXdProcessService;
import com.gotop.timeMachine.model.TModelTimeday;
import com.gotop.timeMachine.service.ITModelTimedayService;
import com.gotop.util.Struts2Utils;
import com.gotop.util.string.Obj2StrUtils;
import com.primeton.utils.Page;
import com.primeton.utils.pageCondExpand;
import com.primeton.workflow.util.stat.StatItem;

public class XdProcessAction   extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private XdProcessTaskAssignee xdProcessTaskAssignee;
	
	private List<XdProcessTaskAssignee> xdProcessTaskAssignees;
	
    private XdProcessBean xdProcessBean;
    
    private XdCdtypeBean xdCdtypeBean;
    
    private XdCdtypeBean xdCdtypeBean2;
    
    private WorkTimeBean workTimeBean;
    
    private List<WorkTimeBean> workTimeBeans;
    
	private List<XdProcessBean> xdProcessBeans;
	
	private List<XdCdtypeBean> xdCdtypeBeans;
	
	private List<XdCdtypeBean> xdCdtypeBeans2;
	
	protected IXdProcessService xdProcessService;
	
	protected ITModelTimedayService tModelTimedayService;
	
    private  String cdtypeJson;
    
    private WaterInfo waterInfo;
    
    private List<WaterInfo> waterInfos;
    
    private List<HashMap<String, String>> models ;
    
    public Page page2;
      
    public Page getPage2() {
    	if(page2==null){
			page2 = new Page();
			page2.setBegin(0);
			page2.setLength(10);
			page2.setCount(0);
			page2.setCount(true);
		}
		return page2;
	}
	public void setPage2(Page page2) {
		pageCondExpand pce = new pageCondExpand();
		pce.putPageCond(page2);
		this.page2 = page2;
	}
	

	
	
	public List<HashMap<String, String>> getModels() {
		return models;
	}
	public void setModels(List<HashMap<String, String>> models) {
		this.models = models;
	}
	public WaterInfo getWaterInfo() {
		return waterInfo;
	}
	public void setWaterInfo(WaterInfo waterInfo) {
		this.waterInfo = waterInfo;
	}
	
	public List<WaterInfo> getWaterInfos() {
		return waterInfos;
	}
	public void setWaterInfos(List<WaterInfo> waterInfos) {
		this.waterInfos = waterInfos;
	}
	public String getCdtypeJson() {
		return cdtypeJson;
	}
	public void setCdtypeJson(String cdtypeJson) {
		this.cdtypeJson = cdtypeJson;
	}
	public XdProcessTaskAssignee getXdProcessTaskAssignee() {
		return xdProcessTaskAssignee;
	}

	public void setXdProcessTaskAssignee(XdProcessTaskAssignee xdProcessTaskAssignee) {
		this.xdProcessTaskAssignee = xdProcessTaskAssignee;
	}

	public List<XdProcessTaskAssignee> getXdProcessTaskAssignees() {
		return xdProcessTaskAssignees;
	}

	public void setXdProcessTaskAssignees(
			List<XdProcessTaskAssignee> xdProcessTaskAssignees) {
		this.xdProcessTaskAssignees = xdProcessTaskAssignees;
	}

	public IXdProcessService getXdProcessService() {
		return xdProcessService;
	}

	public void setXdProcessService(IXdProcessService xdProcessService) {
		this.xdProcessService = xdProcessService;
	}
	
	public ITModelTimedayService gettModelTimedayService() {
		return tModelTimedayService;
	}
	public void settModelTimedayService(ITModelTimedayService tModelTimedayService) {
		this.tModelTimedayService = tModelTimedayService;
	}
	public XdProcessBean getXdProcessBean() {
		return xdProcessBean;
	}

	public void setXdProcessBean(XdProcessBean xdProcessBean) {
		this.xdProcessBean = xdProcessBean;
	}

	
	public XdCdtypeBean getXdCdtypeBean() {
		return xdCdtypeBean;
	}
	public void setXdCdtypeBean(XdCdtypeBean xdCdtypeBean) {
		this.xdCdtypeBean = xdCdtypeBean;
	}
	public XdCdtypeBean getXdCdtypeBean2() {
		return xdCdtypeBean2;
	}
	public void setXdCdtypeBean2(XdCdtypeBean xdCdtypeBean2) {
		this.xdCdtypeBean2 = xdCdtypeBean2;
	}
	public List<XdProcessBean> getXdProcessBeans() {
		return xdProcessBeans;
	}

	public void setXdProcessBeans(List<XdProcessBean> xdProcessBeans) {
		this.xdProcessBeans = xdProcessBeans;
	}	
	
	public List<XdCdtypeBean> getXdCdtypeBeans() {
		return xdCdtypeBeans;
	}
	public void setXdCdtypeBeans(List<XdCdtypeBean> xdCdtypeBeans) {
		this.xdCdtypeBeans = xdCdtypeBeans;
	}
	public List<XdCdtypeBean> getXdCdtypeBeans2() {
		return xdCdtypeBeans2;
	}
	public void setXdCdtypeBeans2(List<XdCdtypeBean> xdCdtypeBeans2) {
		this.xdCdtypeBeans2 = xdCdtypeBeans2;
	}
	
	public WorkTimeBean getWorkTimeBean() {
		return workTimeBean;
	}
	public void setWorkTimeBean(WorkTimeBean workTimeBean) {
		this.workTimeBean = workTimeBean;
	}		
	public List<WorkTimeBean> getWorkTimeBeans() {
		return workTimeBeans;
	}
	public void setWorkTimeBeans(List<WorkTimeBean> workTimeBeans) {
		this.workTimeBeans = workTimeBeans;
	}
	
	
	/**
	 * 查询信贷的待办事项
	 * @return
	 * @throws Exception 
	 */
	public String queryXdMyToDoList() throws Exception{
		//获取用户empId
    	String empId = String.valueOf(this.getCurrentOnlineUser().getEmpid());
    	
    	//获取机构代码
    	String orgCode = this.getCurrentOnlineUser().getOrgcode();
    	
    	//人员id、机构id
    	String relationids = "'" + empId + "'" + "," + "'"+ orgCode+"'" ;
    	
    	//获取角色id数组
    	String[] roleIdArray = this.getCurrentOnlineUser().getRoleid();
    	//将角色id数组转换成用","分割的字符串
    	String roleIds = Obj2StrUtils.join(roleIdArray, String.class, ",");
    	
    	//获取岗位id数组
    	String[] positionIdArray = this.getCurrentOnlineUser().getPositionId();
    	//将岗位id数组转换成用","分割的字符串
    	String positionIds = Obj2StrUtils.join(positionIdArray, String.class, ",");
    	
    	//人员id、机构id、角色id
    	if(roleIds!=null&&!"".equals(roleIds))
    		relationids+="," + roleIds ;
    	//人员id、机构id、角色id、岗位id
    	if(positionIds!=null&&!"".equals(positionIds))
    		relationids+="," + positionIds;
    	
    	//查询待办列表
		List<XdProcessTaskAssignee> xdProcessTaskAssignees = this.xdProcessService.queryXdMyToDoList(relationids,xdProcessTaskAssignee,this.getPage());
		
		//循环分页的10条记录，每条查出其派单时长和流程时长
		for (XdProcessTaskAssignee xdProcessTaskAssignee : xdProcessTaskAssignees) {
			String executionId = xdProcessTaskAssignee.getExecutionId();
			 HashMap map =  this.xdProcessService.queryTimeDiff(executionId);  
			 if(map != null){
				 
				 //计算派单时长
				 if((BigDecimal) map.get("TIME_DIFF1") != null){
					 double time_Diff1 = ((BigDecimal) map.get("TIME_DIFF1")).doubleValue();  //派单时间差timeDiff1 = 派单时间(收单派单的end_) - 报单时间(收单派单的start_)
					 double startD_diff = ((BigDecimal) map.get("STARTD_DIFF")).doubleValue();  //开始时间 那天的时间所占多少天
					 double endD_diff = ((BigDecimal) map.get("ENDD_DIFF")).doubleValue();  //结束时间 那天的时间所占多少天
					 String start_time =  (String) map.get("START_TIME") ; 
					 String end_time =  (String) map.get("END_TIME") ; 
					 
					//派单时长（单位：工作日）=（派单时间-报单时间）（单位：天） – 周末 – 节假日 + 特殊工作日
					 double pdTimeLen = getTimeLen(start_time, end_time, time_Diff1, startD_diff, endD_diff);
					 xdProcessTaskAssignee.setPdTimeLen(pdTimeLen);
				 }
				 
				 //计算流程时长
				 if((BigDecimal) map.get("TIME_DIFF2") != null){
					 double time_Diff2 = ((BigDecimal) map.get("TIME_DIFF2")).doubleValue();  //流程时间差timeDiff2 = 当前时间 - 报单时间(收单派单的start_)
					 double startD_diff = ((BigDecimal) map.get("STARTD_DIFF")).doubleValue();  //开始时间 那天的时间所占多少天
					 double currD_diff = ((BigDecimal) map.get("CURRD_DIFF")).doubleValue();  //当前时间 当天天的时间所占多少天
					 String start_time =  (String) map.get("START_TIME") ; 
					 String curr_time = (String) map.get("CURR_TIME") ; 
					 
					//流程时长（单位：工作日）=（当前时间-报单时间）（单位：天） – 周末 – 节假日 + 特殊工作日
					 double lcTimeLen = getTimeLen(start_time, curr_time, time_Diff2, startD_diff, currD_diff);
					 xdProcessTaskAssignee.setLcTimeLen(lcTimeLen);
				 }
				 
			 }
		}
		
		
		this.setXdProcessTaskAssignees(xdProcessTaskAssignees);

		return "xd_mytodo_list";
	}
	
	/**
	 * 计算两个时间范围内的 时长（除去周末、节假日，加上了特殊工作日）
	 * @param start_time 开始时间
	 * @param end_time  结束时间
	 * @param time_Diff  结束时间-开始时间 的时间差（单位：天）
	 * @param startD_diff 开始时间那天所占的时间差（单位：天）
	 * @param endD_diff 结束时间那天所占的时间差（单位：天）
	 * @return
	 * @throws ParseException
	 */
	public double  getTimeLen(String start_time, String end_time, double time_Diff, double startD_diff, double endD_diff) throws ParseException{
		
		SimpleDateFormat sd = new SimpleDateFormat("yyyy/MM/dd");
		Date startD = sd.parse(start_time);  //开始日期（不含时间）
		Date endD = sd.parse(end_time);  //结束日期（不含时间）
		String startDstr = sd.format(startD);
    	String endDstr = sd.format(endD);
		
		//将startD的时间赋给startD2，不能用等号直接赋值，否则当startD2值变了，startD也会跟着累加变化
		 Date startD2 = sd.parse(start_time); //用于日期累加
		 Date startD3; //用于存放在datelist里
		 double timediff = time_Diff;
		 
		 List<Date> datelist = new ArrayList<Date>(); //用于存放传入的开始~结束时间里遇到的 周六或周日的日期
		 while (startD2.compareTo(endD) <= 0) {
				
				if (startD2.getDay() == 6 || startD2.getDay() == 0){  //getDay()=6代表周六， getDay()=0代表周日
					startD3 = new Date();
					//将startD2的时间赋给startD3，不能用等号直接赋值，否则当startD3值变了，startD2也会跟着累加变化
					startD3 = sd.parse(sd.format(startD2));   
					datelist.add(startD3);
					
					if(startD3.compareTo(startD) != 0  && startD3.compareTo(endD) != 0 ){//说明当前这个周末日期不是开始日期，也不是结束日期，说明是除开始和结束日期外之间的天数，要扣一个工作日
						timediff = (double)Math.round((timediff - 1)*100)/100; //保留两位小数，四舍五入的方法：(double)Math.round(d*100)/100;
					}else if(startD3.compareTo(startD) == 0  && startD3.compareTo(endD) != 0 ){//说明当前这个周末日期是开始日期，并且开始日期与结束日期不是同一天
						timediff =  (double)Math.round((timediff - startD_diff)*100)/100;
					}else if(startD3.compareTo(startD) != 0  && startD3.compareTo(endD) == 0 ){//说明当前这个周末日期是结束日期，并且开始日期与结束日期不是同一天
						timediff =  (double)Math.round((timediff - endD_diff)*100)/100;
					}else{//说明开始和结束日期是同一天，并且是属于周末
						timediff = 0;
					}
				}
		
				startD2.setDate(startD2.getDate() + 1);  
			}  
		 
		 
		//查找配置的日期在 传入的日期范围之间 的节假日、工作日
		    HashMap<String , Object> map = new HashMap<String , Object>();
		    map.put("startD",startDstr );
		    map.put("endD", endDstr);
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
						timediff =  (double)Math.round((timediff - startD_diff)*100)/100;
					}
					
					//节假日是结束日期，且节假日周末不重叠
					if(timedate.compareTo(endD) == 0 && weekend_flag == false){
						timediff =  (double)Math.round((timediff - endD_diff)*100)/100;
					}
					
					//节假日不是开始日期也不是结束日期，且节假日周末不重叠
					if(timedate.compareTo(startD) != 0 && timedate.compareTo(endD) != 0 && weekend_flag == false){
						timediff =  (double)Math.round((timediff - 1)*100)/100;
					}
					
					//节假日既是开始日期也是结束日期，说明开始和结束是同一天，且节假日周末不重叠
					if(timedate.compareTo(startD) == 0 && timedate.compareTo(endD) == 0 && weekend_flag == false){
						timediff = 0;
					}
				}
				
				//当遇到配置类型为“工作日”，要加上
				if( "2".equals(tModelTimeday.getType()) ){
					//特殊维护的工作日是开始日期，且周末设为工作日
					if(timedate.compareTo(startD) == 0 && weekend_flag == true){
						timediff =  (double)Math.round((timediff + startD_diff)*100)/100;
					}
					
					//特殊维护的工作日是结束日期，且周末设为工作日
					if(timedate.compareTo(endD) == 0 && weekend_flag == true){
						timediff =  (double)Math.round((timediff + endD_diff)*100)/100;
					}
					
					//特殊维护的工作日不是开始日期也不是结束日期，且周末设为工作日
					if(timedate.compareTo(startD) != 0 && timedate.compareTo(endD) != 0 && weekend_flag == true){
						timediff =  (double)Math.round((timediff + 1)*100)/100;
					}
					
					//特殊维护的工作日既是开始日期也是结束日期，说明开始和结束是同一天，且周末设为工作日
					if(timedate.compareTo(startD) == 0 && timedate.compareTo(endD) == 0 && weekend_flag == true){
						timediff = time_Diff;
					}
				}
				
			}
			
			return timediff;
	}
	
	
	/**
	 * 查询 所有发布的信贷流程
	 * @return
	 */
	public String queryXdProcessList(){
		List<XdProcessBean> xdProcessBeans = this.xdProcessService.queryXdProcessList(xdProcessBean,this.getPage());
		this.setXdProcessBeans(xdProcessBeans);
		
		return "xd_process_list";
	}
	
	/**
	 * 查询 流程名对应的一级分类列表
	 * @return
	 */
	public String toSelectParaManage(){
		 if(xdCdtypeBean == null){
			 xdCdtypeBean = new XdCdtypeBean();
		   }
		  
		 xdCdtypeBeans = xdProcessService.queryOneCategoryList(xdCdtypeBean,this.getPage());
		   this.setXdProcessBeans(xdProcessBeans);
		   return "select_para_manage";
	}
	
	/**
	 * 查询 流程名对应的贷种分类列表
	 * @return
	 */
	public String queryLoanCategoryList(){
		 if(xdCdtypeBean2 == null){
			 xdCdtypeBean2 = new XdCdtypeBean();
		   }
		 xdCdtypeBeans = xdProcessService.queryOneCategoryList(xdCdtypeBean,this.getPage());
		 xdCdtypeBeans2 = xdProcessService.queryLoanCategoryList(xdCdtypeBean2,this.getPage2());
		   this.setXdCdtypeBeans(xdCdtypeBeans);
		   this.setXdCdtypeBeans2(xdCdtypeBeans2);
		   return "select_para_manage";
	}
	
	/**
	 * 跳转到 添加一级分类 页面
	 * @return
	 */
	public String toAddOneCategory(){
		return "add_oneCategory";
	}
	
	
	/**
	 * 跳转到 添加贷种分类 页面
	 * @return
	 */
	public String toAddLoanCategory(){
		return "add_loanCategory";
	}
	
	
	/**
	 * 添加 一级分类
	 * @return
	 * @throws Exception 
	 */
	public void addOneCategory() throws Exception{
		String info ="success";
    	try {
    		String loanCategory_str = xdCdtypeBean.getLoanCategory();
    		String[] valueArra = loanCategory_str.split(", ");
			for(int i=0; i<valueArra.length; i++){
				xdCdtypeBean.setLoanCategory(valueArra[i]);
				this.xdProcessService.insert(xdCdtypeBean);
			}
    	} catch (Exception e) {
			info="fails";
			log.error("[保存设备信息失败！]", e);
			throw e;
		}finally{	
		}
		Struts2Utils.renderText(info);
	}

	/**
	 * 删除 一级分类
	 * @return
	 * @throws Exception 
	 */
	public void delOneCategory() throws Exception{
		String info ="success";
    	try {
    		String oneCategory_str = xdCdtypeBean.getOneCategory();
    		String[] valueArra = oneCategory_str.split(",");
			for(int i=0; i<valueArra.length; i++){
				xdCdtypeBean.setOneCategory(valueArra[i]);
				this.xdProcessService.delete(xdCdtypeBean);
			}
    	} catch (Exception e) {
			info="fails";
			log.error("[保存设备信息失败！]", e);
			throw e;
		}finally{	
		}
		Struts2Utils.renderText(info);
	}
	
	
	/**
	 * 添加 贷种分类
	 * @return
	 * @throws Exception 
	 */
	public void addLoanCategory() throws Exception{
		String info ="success";
    	try {
    		String loanCategory_str = xdCdtypeBean.getLoanCategory();
    		String[] valueArra = loanCategory_str.split(", ");
			for(int i=0; i<valueArra.length; i++){
				xdCdtypeBean.setLoanCategory(valueArra[i]);
				this.xdProcessService.insert(xdCdtypeBean);
			}
    	} catch (Exception e) {
			info="fails";
			log.error("[保存设备信息失败！]", e);
			throw e;
		}finally{	
		}
		Struts2Utils.renderText(info);
	}
	
	/**
	 * 删除 贷种分类
	 * @return
	 * @throws Exception 
	 */
	public void delLoanCategory() throws Exception{
		String info ="success";
    	try {
    		String loanCategory_str = xdCdtypeBean.getLoanCategory();
    		String[] valueArra = loanCategory_str.split(",");
			for(int i=0; i<valueArra.length; i++){
				xdCdtypeBean.setLoanCategory(valueArra[i]);
				this.xdProcessService.delete(xdCdtypeBean);
			}
    	} catch (Exception e) {
			info="fails";
			log.error("[保存设备信息失败！]", e);
			throw e;
		}finally{	
		}
		Struts2Utils.renderText(info);
	}
	
	/**
	 * 校验 一级分类 是否已经存在
	 */
	public void checkOneCategory(){
		String info ="";
		
		xdCdtypeBeans = xdProcessService.checkOneCategory(xdCdtypeBean);
		if(xdCdtypeBeans.size() == 0){
			info ="success";
		}else{
			info="fails";
		}
		Struts2Utils.renderText(info);
	}
	
	/**
	 * 校验 贷款分类 是否已经存在
	 */
	public void checkLoanCategory(){
		String info ="";
		String err_info="";
		
		String loanCategory_str = xdCdtypeBean.getLoanCategory();
		String[] valueArra = loanCategory_str.split(", ");
		for(int i=0; i<valueArra.length; i++){
			xdCdtypeBean.setLoanCategory(valueArra[i]);
			xdCdtypeBeans = xdProcessService.checkLoanCategory(xdCdtypeBean);
			if(xdCdtypeBeans.size() >0){
				if("".equals(err_info)){
					err_info = err_info+xdCdtypeBean.getLoanCategory();
				}else{
					err_info = err_info+","+xdCdtypeBean.getLoanCategory();
				}
			}
		}
		if("".equals(err_info)){
			info ="success";
			Struts2Utils.renderText(info);
		}else{
			info="fails";
			Struts2Utils.renderText(err_info);
		}
		
	}
	
	 public String oneCategoryDic() throws Exception {
	    	System.out.println(cdtypeJson);
	    	return "oneCategoryDic";
	    }
	
	/**
	 * 查询 已经发起的信贷流程
	 * @return
	 * @throws Exception 
	 */
	public String queryXdStartProcessList() throws Exception{
		//获取用户empId
    	String empId = String.valueOf(this.getCurrentOnlineUser().getEmpid());
    	
    	//获取机构代码
    	String orgCode = this.getCurrentOnlineUser().getOrgcode();
    	
    	//人员id、机构id
    	String relationids = "'" + empId + "'" + "," + "'"+ orgCode+"'" ;
    	
    	//获取角色id数组
    	String[] roleIdArray = this.getCurrentOnlineUser().getRoleid();
    	//将角色id数组转换成用","分割的字符串
    	String roleIds = Obj2StrUtils.join(roleIdArray, String.class, ",");
    	
    	//获取岗位id数组
    	String[] positionIdArray = this.getCurrentOnlineUser().getPositionId();
    	//将岗位id数组转换成用","分割的字符串
    	String positionIds = Obj2StrUtils.join(positionIdArray, String.class, ",");
    	
    	//人员id、机构id、角色id
    	if(roleIds!=null&&!"".equals(roleIds))
    		relationids+="," + roleIds ;
    	//人员id、机构id、角色id、岗位id
    	if(positionIds!=null&&!"".equals(positionIds))
    		relationids+="," + positionIds;
    	
		List<XdProcessTaskAssignee> xdProcessTaskAssignees = this.xdProcessService.queryXdStartProcessList(relationids,xdProcessTaskAssignee,this.getPage());
		this.setXdProcessTaskAssignees(xdProcessTaskAssignees);
		return "xd_startprocess_list";
	}
	
	/**
	 * 返回到 贷款修改页面
	 * @return
	 */
	public String toUptLoanInfo(){
		return "upt_loan_info";
	}
	
	/**
	 * 保存 贷款修改信息
	 * @return
	 * @throws Exception 
	 */
	public void saveUptInfo() throws Exception{
		String info ="success";
		
    	try {
    		String flowid=xdProcessTaskAssignee.getExecutionId();
    		//查询修改明细表的数据，如果没数据0，则自动插入一条原始数据
			int cnt = this.xdProcessService.selectIsfirst(flowid);		
			if(cnt == 0 ){	//没数据
				XdProcessTaskAssignee isfirst=xdProcessService.getxdProcessTaskAssigneeById(xdProcessTaskAssignee.getExecutionId());
				WaterInfo waterInfo2 = new WaterInfo();
				waterInfo2.setFlow_id(xdProcessTaskAssignee.getExecutionId());
				waterInfo2.setProcessName(isfirst.getProcessName());
				waterInfo2.setCustName(isfirst.getCustName());
				waterInfo2.setApply_bal(isfirst.getApply_bal());
				waterInfo2.setOneCategory(isfirst.getOneCategory());
				waterInfo2.setLoanCategory(isfirst.getLoanCategory());
				waterInfo2.setCoorganization(isfirst.getCoorganization());
				waterInfo2.setUptEmpid(this.getCurrentOnlineUser().getEmpid());
				waterInfo2.setUptOrgcode(this.getCurrentOnlineUser().getOrgcode());
				waterInfo2.setCyxry(isfirst.getYxry());
				waterInfo2.setCyxryjg(isfirst.getYxryjg());
				waterInfo2.setCreportcnt(isfirst.getReportcnt());
				
				this.xdProcessService.insertWaterOne(waterInfo2);
			}
				int count = this.xdProcessService.uptModelOneInfo(xdProcessTaskAssignee);
			   this.xdProcessService.uptModelThreeInfo(xdProcessTaskAssignee);
				if(count > 0 ){
					if(waterInfo==null){
						waterInfo = new WaterInfo();
					}
					waterInfo.setFlow_id(xdProcessTaskAssignee.getExecutionId());
					waterInfo.setProcessName(xdProcessTaskAssignee.getProcessName());
					waterInfo.setCustName(xdProcessTaskAssignee.getCustName());
					waterInfo.setApply_bal(xdProcessTaskAssignee.getApply_bal());
					waterInfo.setOneCategory(xdProcessTaskAssignee.getOneCategory());
					waterInfo.setLoanCategory(xdProcessTaskAssignee.getLoanCategory());
					waterInfo.setCoorganization(xdProcessTaskAssignee.getCoorganization());
					waterInfo.setUptEmpid(this.getCurrentOnlineUser().getEmpid());
					waterInfo.setUptOrgcode(this.getCurrentOnlineUser().getOrgcode());
					waterInfo.setCyxry(xdProcessTaskAssignee.getYxry());
					waterInfo.setCyxryjg(xdProcessTaskAssignee.getYxryjg());
					waterInfo.setCreportcnt(xdProcessTaskAssignee.getReportcnt());
					
					this.xdProcessService.updateTitle(xdProcessTaskAssignee);
					this.xdProcessService.insertWater(waterInfo);
				}
				
    	} catch (Exception e) {
			info="fails";
			log.error("[保存设备信息失败！]", e);
			throw e;
		}finally{	
		}
		Struts2Utils.renderText(info);
	}
	/**
	 * 查询修改明细表的数据，如果没数据0，则自动插入一条原始数据
	 * 吴前贵  2016-05-24
	 * @throws Exception
	 */
	public void selectcnt() throws Exception{
		       String info ="success";
		       if(waterInfo==null){
		    	   waterInfo=new WaterInfo();
		       }
		       //当前修改人名称，所属机构（根据empid,orgcode获取，sql中有写）
				waterInfo.setUptEmpid(this.getCurrentOnlineUser().getEmpid());
				waterInfo.setUptOrgcode(this.getCurrentOnlineUser().getOrgcode());
				
				int count = this.xdProcessService.selectIsfirst(waterInfo.getFlow_id());
				
				if(count == 0 ){	//没数据
					this.xdProcessService.insertWater(waterInfo);
					info ="success";
				}else{//有数据	
					info="fails";
				}

		Struts2Utils.renderText(info);
	}

	/**
	 * 查询贷款修改流水
	 * @return
	 */
	public String queryLoanUptWater(){
		List<WaterInfo> waterInfos = this.xdProcessService.queryLoanUptWater(waterInfo,this.getPage());
		this.setWaterInfos(waterInfos);
		return "query_loanUptWater";
		
	}
	
	
	
	/**
	 * 节点工时维护
	 * @return
	 */
	public String nodeWorkTimeManage(){
		return "nodeWorkTime_manage";
	}
	
	/**
	 * 跳转到节点选择界面
	 * @return
	 */
	public String toNodeSelect(){
		 models = SpringPropertyResourceReader.getAllPro();
		this.setModels(models);
		return "to_nodeSelect";
	}
	
	/**
	 * 保存 节点模式 工作时长
	 * @throws Exception 
	 */
	public void saveNodeWorkTime() throws Exception{
		String info ="success";
		try {
			workTimeBean.setOp_empid(this.getCurrentOnlineUser().getEmpid());
			workTimeBean.setOp_orgcode(this.getCurrentOnlineUser().getOrgcode());
			
			workTimeBeans = xdProcessService.queryWorkTime(workTimeBean);
			if(workTimeBeans.size() == 0){
				xdProcessService.insertWorkTime(workTimeBean);
			}else{
				xdProcessService.updateWorkTime(workTimeBean);
			}
			
		} catch (Exception e) {
			info="fails";
			log.error("[保存设备信息失败！]", e);
			throw e;
		}finally{	
			Struts2Utils.renderText(info);
		}
	}

	
}
