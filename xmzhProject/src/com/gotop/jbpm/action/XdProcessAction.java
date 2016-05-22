package com.gotop.jbpm.action;

import java.util.HashMap;
import java.util.List;

import com.gotop.Generalprocess.util.SpringPropertyResourceReader;
import com.gotop.crm.util.BaseAction;
import com.gotop.jbpm.model.WaterInfo;
import com.gotop.jbpm.model.WorkTimeBean;
import com.gotop.jbpm.model.XdCdtypeBean;
import com.gotop.jbpm.model.XdProcessBean;
import com.gotop.jbpm.model.XdProcessTaskAssignee;
import com.gotop.jbpm.service.IXdProcessService;
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
    	
		List<XdProcessTaskAssignee> xdProcessTaskAssignees = this.xdProcessService.queryXdMyToDoList(relationids,xdProcessTaskAssignee,this.getPage());
		this.setXdProcessTaskAssignees(xdProcessTaskAssignees);

		return "xd_mytodo_list";
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
