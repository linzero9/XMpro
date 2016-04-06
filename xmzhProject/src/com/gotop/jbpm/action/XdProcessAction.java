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
	
    private  String cdtypeJson;
    
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
