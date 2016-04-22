package com.gotop.jbpm.action;

import java.util.ArrayList;
import java.util.List;

import org.jbpm.api.RepositoryService;
import org.jbpm.pvm.internal.model.ActivityImpl;
import org.jbpm.pvm.internal.model.ProcessDefinitionImpl;

import com.gotop.crm.util.BaseAction;
import com.gotop.jbpm.dto.TaskAssgineeDto;
import com.gotop.jbpm.model.NodeTimeLimitBean;
import com.gotop.jbpm.model.OneAndLoanBean;
import com.gotop.jbpm.model.ProLoanBean;
import com.gotop.jbpm.model.XdProcessBean;
import com.gotop.jbpm.service.ITimeLimitManageService;
import com.gotop.jbpm.service.IXdProcessService;
import com.gotop.jbpm.service.JbpmService;
import com.gotop.util.Struts2Utils;

public class TimeLimitManageAction extends BaseAction {

	private OneAndLoanBean oneAndLoanBean;
	
	private List<OneAndLoanBean> oneAndLoanBeans;
	
	private ProLoanBean proLoanBean;
	
	private List<ProLoanBean> proLoanBeans;
	
	private NodeTimeLimitBean nodeTimeLimitBean;
	
	private List<NodeTimeLimitBean> nodeTimeLimitBeans;
	
	private String ids;
	
	private XdProcessBean xdProcessBean;
	
	private List<XdProcessBean> xdProcessBeans ;
	
	protected ITimeLimitManageService timeLimitManageService;
	
	protected IXdProcessService xdProcessService;

	private JbpmService jbpmService;
	
	
	public NodeTimeLimitBean getNodeTimeLimitBean() {
		return nodeTimeLimitBean;
	}

	public void setNodeTimeLimitBean(NodeTimeLimitBean nodeTimeLimitBean) {
		this.nodeTimeLimitBean = nodeTimeLimitBean;
	}

	public List<NodeTimeLimitBean> getNodeTimeLimitBeans() {
		return nodeTimeLimitBeans;
	}

	public void setNodeTimeLimitBeans(List<NodeTimeLimitBean> nodeTimeLimitBeans) {
		this.nodeTimeLimitBeans = nodeTimeLimitBeans;
	}

	public JbpmService getJbpmService() {
		return jbpmService;
	}

	public void setJbpmService(JbpmService jbpmService) {
		this.jbpmService = jbpmService;
	}

	public List<ProLoanBean> getProLoanBeans() {
		return proLoanBeans;
	}

	public void setProLoanBeans(List<ProLoanBean> proLoanBeans) {
		this.proLoanBeans = proLoanBeans;
	}

	public ProLoanBean getProLoanBean() {
		return proLoanBean;
	}

	public void setProLoanBean(ProLoanBean proLoanBean) {
		this.proLoanBean = proLoanBean;
	}

	public XdProcessBean getXdProcessBean() {
		return xdProcessBean;
	}

	public void setXdProcessBean(XdProcessBean xdProcessBean) {
		this.xdProcessBean = xdProcessBean;
	}

	public List<XdProcessBean> getXdProcessBeans() {
		return xdProcessBeans;
	}

	public void setXdProcessBeans(List<XdProcessBean> xdProcessBeans) {
		this.xdProcessBeans = xdProcessBeans;
	}

	public IXdProcessService getXdProcessService() {
		return xdProcessService;
	}

	public void setXdProcessService(IXdProcessService xdProcessService) {
		this.xdProcessService = xdProcessService;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public OneAndLoanBean getOneAndLoanBean() {
		return oneAndLoanBean;
	}

	public void setOneAndLoanBean(OneAndLoanBean oneAndLoanBean) {
		this.oneAndLoanBean = oneAndLoanBean;
	}

	public List<OneAndLoanBean> getOneAndLoanBeans() {
		return oneAndLoanBeans;
	}

	public void setOneAndLoanBeans(List<OneAndLoanBean> oneAndLoanBeans) {
		this.oneAndLoanBeans = oneAndLoanBeans;
	}

	public ITimeLimitManageService getTimeLimitManageService() {
		return timeLimitManageService;
	}

	public void setTimeLimitManageService(
			ITimeLimitManageService timeLimitManageService) {
		this.timeLimitManageService = timeLimitManageService;
	}

	/**
	 * 查询 所有 一级分类与贷种分类的对应关系
	 * @return
	 */
	public String queryOneAndLoanList(){
		oneAndLoanBeans = this.timeLimitManageService.queryOneAndLoanList(oneAndLoanBean,this.getPage());
		this.setOneAndLoanBeans(oneAndLoanBeans);
		return "oneAndLoanCategory_list";
	}
	
	/**
	 * 跳转到 新增 一级分类与贷种分类的对应关系 页面
	 * @return
	 */
	public String toAddOneAndLoan(){
		return "add_oneAndLoanCategory";
	}
	
	/**
	 * 检验 一级分类与贷种分类的对应关系是否已存在
	 */
	public void checkOneAndLoan(){
		String info ="";
		String err_info="";
		
		String loanCategory_str = oneAndLoanBean.getLoanCategory_name();
		String[] valueArra = loanCategory_str.split(", ");
		for(int i=0; i<valueArra.length; i++){
			oneAndLoanBean.setLoanCategory_name(valueArra[i]);
			oneAndLoanBeans = this.timeLimitManageService.checkOneAndLoan(oneAndLoanBean);
			if(oneAndLoanBeans.size() >0){
				if("".equals(err_info)){
					err_info = err_info+oneAndLoanBean.getLoanCategory_name();
				}else{
					err_info = err_info+","+oneAndLoanBean.getLoanCategory_name();
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
	
	/**
	 * 添加 一级分类与贷种分类的对应关系
	 * @throws Exception 
	 */
	public void addOneAndLoan() throws Exception{
		String info ="success";
    	try {
    		String loanCategory_str = oneAndLoanBean.getLoanCategory_name();
    		String[] valueArra = loanCategory_str.split(", ");
    		
    		String loanCategoryId_str = oneAndLoanBean.getLoanCategory_id();
    		String[] valueArra2 = loanCategoryId_str.split(", ");
    		
			for(int i=0; i<valueArra.length; i++){
				oneAndLoanBean.setLoanCategory_name(valueArra[i]);
				oneAndLoanBean.setLoanCategory_id(valueArra2[i]);
				this.timeLimitManageService.addOneAndLoan(oneAndLoanBean);
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
	 * 删除 一级分类与贷种分类的对应关系
	 * @throws Exception 
	 */
	public void delOneAndLoan() throws Exception{
		String info ="success";
    	try {
    		String[] valueArra = ids.split(",");
			for(int i=0; i<valueArra.length; i++){
				if(oneAndLoanBean == null){
					oneAndLoanBean = new OneAndLoanBean();
				}
				oneAndLoanBean.setD_id(Long.valueOf(valueArra[i]) );
				this.timeLimitManageService.delOneAndLoan(oneAndLoanBean);
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
	 * 查询信贷流程列表 流程时限配置
	 */
	public String queryXdProcessList(){
		List<XdProcessBean> xdProcessBeans = this.xdProcessService.queryXdProcessList(xdProcessBean,this.getPage());
		this.setXdProcessBeans(xdProcessBeans);
		
		return "xdProcess_list";
	}
	
	/**
	 * 跳转到 时限管理配置 页面
	 */
	public String toTimeLimitManage(){
	//	List<XdProcessBean> xdProcessBeans = this.xdProcessService.queryXdProcessList(xdProcessBean,this.getPage());
	//	this.setXdProcessBeans(xdProcessBeans);
		System.out.println(proLoanBean);
		return "timeLimitManage";
	}
	
	public String queryOneCategorylist(){
		proLoanBeans = this.timeLimitManageService.queryOneCategorylist();
		this.setProLoanBeans(proLoanBeans);
		return "oneCategorylist";
	}
	
	public String queryLoanCategorylist(){
		proLoanBeans = this.timeLimitManageService.queryLoanCategorylist(proLoanBean);
		this.setProLoanBeans(proLoanBeans);
		return "loanCategorylist";
	}
	
	public void saveTimeLimitManage() throws Exception{
		String info ="success";
    	try {
    		
    		if(proLoanBean != null){
    			this.timeLimitManageService.insertProTimeLimitModel(proLoanBean); //插入到（C表） t_model_proTimeLimitModel 流程时限模版表
    			
    			String[] valueArra1 = proLoanBean.getOneCategory_name().split(",");
    			String[] valueArra2 = proLoanBean.getLoanCategory_name().split(",");
    			for(int i=0; i<valueArra1.length; i++){

    				ProLoanBean proLoanBean2 = new ProLoanBean();
    				proLoanBean2.setDefinitionId(proLoanBean.getDefinitionId());
    				proLoanBean2.setProcessName(proLoanBean.getProcessName());
    				proLoanBean2.setC_id(proLoanBean.getC_id());
    				proLoanBean2.setOneCategory_name(valueArra1[i] );
    				proLoanBean2.setLoanCategory_name(valueArra2[i] );
    				proLoanBean2.setOp_empid(this.getCurrentOnlineUser().getEmpid());
    				proLoanBean2.setOp_orgcode(this.getCurrentOnlineUser().getOrgcode());
    				
    				this.timeLimitManageService.insertProLoanTimeLimit(proLoanBean2); //插入到（B表） t_model_proLoanTimeLimit 流程贷种时限关表
    				
    			}
    			info += ","+proLoanBean.getC_id();
    		}
    	} catch (Exception e) {
			info="fails";	
			log.error("[保存设备信息失败！]", e);
			throw e;
		}finally{	
		}
		Struts2Utils.renderText(info);
		//Struts2Utils.renderJsonp(callbackName, object, headers);
	}
	
	public String queryNodeTimeLimitList(){
		String definitionId = this.proLoanBean.getDefinitionId();
		RepositoryService repositoryService = jbpmService
				.getRepositoryService();
		ProcessDefinitionImpl processDefinition = (ProcessDefinitionImpl) repositoryService
				.createProcessDefinitionQuery()
				.processDefinitionId(definitionId).uniqueResult();
		
		List<NodeTimeLimitBean> nodeTimeLimitBeans = new ArrayList<NodeTimeLimitBean>();
		List list = processDefinition.getActivities();
		
		for (int i = 0; i < list.size(); i++) {
			ActivityImpl activityImpl = (ActivityImpl) list.get(i);
			String type = activityImpl.getType();
			if (type.equals("task")) {
				NodeTimeLimitBean nodeTimeLimitBean = new NodeTimeLimitBean();
				nodeTimeLimitBean.setTaskName(activityImpl.getName());
				nodeTimeLimitBean.setC_id(proLoanBean.getC_id());
				List<NodeTimeLimitBean> nodeTimeLimitBeans2 = this.timeLimitManageService.queryNodeTimeLimitList(nodeTimeLimitBean);
				if(nodeTimeLimitBeans2.size() == 1){
					NodeTimeLimitBean nodeTimeLimitBean2 = nodeTimeLimitBeans2.get(0);
					nodeTimeLimitBean.setE_id(nodeTimeLimitBean2.getE_id());
					nodeTimeLimitBean.setTimeLimit(nodeTimeLimitBean2.getTimeLimit());
				}
				
				nodeTimeLimitBeans.add(nodeTimeLimitBean);
			}
		}
		this.setNodeTimeLimitBeans(nodeTimeLimitBeans);
		this.setProLoanBean(proLoanBean);
		return "nodeTimeLimit_list";
	}
	
	public String toSetNodeTimeLimit(){
		return "setNodeTimeLimit";
	}
	
	public void saveNodeTimeLimit() throws Exception{
		String info ="success";
    	try {
    		if(nodeTimeLimitBean != null ){
    			nodeTimeLimitBean.setOp_empid(this.getCurrentOnlineUser().getEmpid());
    			nodeTimeLimitBean.setOp_orgcode(this.getCurrentOnlineUser().getOrgcode());
    			
    			if(nodeTimeLimitBean.getE_id() == null){
    				this.timeLimitManageService.insertNodeTimeLimit(nodeTimeLimitBean);
    			}else{
    				this.timeLimitManageService.updateNodeTimeLimit(nodeTimeLimitBean);
    			}
    		}
				
    	} catch (Exception e) {
			info="fails";
			log.error("[保存设备信息失败！]", e);
			throw e;
		}finally{	
		}
		Struts2Utils.renderText(info);
	}
}
