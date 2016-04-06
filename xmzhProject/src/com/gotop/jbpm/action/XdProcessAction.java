package com.gotop.jbpm.action;

import java.util.List;

import com.gotop.crm.util.BaseAction;
import com.gotop.jbpm.model.XdCdtypeBean;
import com.gotop.jbpm.model.XdProcessBean;
import com.gotop.jbpm.model.XdProcessTaskAssignee;
import com.gotop.jbpm.service.IXdProcessService;
import com.gotop.util.Struts2Utils;
import com.primeton.utils.Page;
import com.primeton.utils.pageCondExpand;

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
	
	private List<XdProcessBean> xdProcessBeans;
	
	private List<XdCdtypeBean> xdCdtypeBeans;
	
	private List<XdCdtypeBean> xdCdtypeBeans2;
	
	protected IXdProcessService xdProcessService;

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
	 * 添加 一级分类
	 * @return
	 * @throws Exception 
	 */
	public void addOneCategory() throws Exception{
		String info ="success";
    	try {
    		this.xdProcessService.insertOneCategory(xdCdtypeBean);
    	} catch (Exception e) {
			info="fails";
			log.error("[保存设备信息失败！]", e);
			throw e;
		}finally{	
		}
		Struts2Utils.renderText(info);
	}
	
	/**
	 * 跳转到 添加贷种分类 页面
	 * @return
	 */
	public String toAddLoanCategory(){
		return "add_loanCategory";
	}
	
	/**
	 * 添加 贷种分类
	 * @return
	 */
	public String addLoanCategory(){
		return "add_loanCategory";
	}
	
	public void checkOneCategory(){
		String info ="";
		
		xdCdtypeBeans = xdProcessService.checkOneCategory(xdCdtypeBean);
		if(xdProcessBeans==null){
			info ="success";
		}else{
			info="fails";
		}
		Struts2Utils.renderText(info);
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
