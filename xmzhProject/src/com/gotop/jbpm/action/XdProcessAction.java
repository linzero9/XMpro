package com.gotop.jbpm.action;

import java.util.List;

import com.gotop.crm.util.BaseAction;
import com.gotop.jbpm.model.XdProcessBean;
import com.gotop.jbpm.model.XdProcessTaskAssignee;
import com.gotop.jbpm.service.IXdProcessService;

public class XdProcessAction   extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private XdProcessTaskAssignee xdProcessTaskAssignee;
	
	private List<XdProcessTaskAssignee> xdProcessTaskAssignees;
	
    private XdProcessBean xdProcessBean;
	
	private List<XdProcessBean> xdProcessBeans;
	
	protected IXdProcessService xdProcessService;

	
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

	public List<XdProcessBean> getXdProcessBeans() {
		return xdProcessBeans;
	}

	public void setXdProcessBeans(List<XdProcessBean> xdProcessBeans) {
		this.xdProcessBeans = xdProcessBeans;
	}
	
	
	
	/**
	 * 查询信贷的待办事项
	 * @return
	 */
	public String queryXdMyToDoList(){
		List<XdProcessTaskAssignee> xdProcessTaskAssignees = this.xdProcessService.queryXdMyToDoList(xdProcessTaskAssignee,this.getPage());
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
	
	public String toSelectParaManage(){
		return "select_para_manage";
	}
	
	/**
	 * 查询 已经发起的信贷流程
	 * @return
	 */
	public String queryXdStartProcessList(){
		return "";
	}
	
	/**
	 * 
	 * @return
	 */
	public String loanInfoUpdate(){
		return "";
	}
}
