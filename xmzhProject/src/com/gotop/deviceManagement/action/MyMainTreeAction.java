package com.gotop.deviceManagement.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.gotop.crm.util.BaseAction;
import com.gotop.deviceManagement.service.IMyMainTreeService;
import com.gotop.tyjg.common.model.ChangeTree;
import com.gotop.tyjg.common.model.Employee;
import com.gotop.tyjg.common.model.Organization;
import com.gotop.tyjg.common.service.IMainTreeService;
import com.gotop.util.XmlConvert;

public class MyMainTreeAction extends BaseAction{

	private ChangeTree changeTree;
	private String orgflag;
	private IMainTreeService mainTreeService;
	private IMyMainTreeService myMainTreeService;
	
	private String loginOrgSeq;
	
	
	
	public String getLoginOrgSeq() {
		return loginOrgSeq;
	}

	public void setLoginOrgSeq(String loginOrgSeq) {
		this.loginOrgSeq = loginOrgSeq;
	}

	
	public IMyMainTreeService getMyMainTreeService() {
		return myMainTreeService;
	}

	public void setMyMainTreeService(IMyMainTreeService myMainTreeService) {
		this.myMainTreeService = myMainTreeService;
	}

	public String getOrgflag() {
		return orgflag;
	}

	public void setOrgflag(String orgflag) {
		this.orgflag = orgflag;
	}

	public ChangeTree getChangeTree() {
		return changeTree;
	}

	public void setChangeTree(ChangeTree changeTree) {
		this.changeTree = changeTree;
	}

	public IMainTreeService getMainTreeService() {
		return mainTreeService;
	}

	public void setMainTreeService(IMainTreeService mainTreeService) {
		this.mainTreeService = mainTreeService;
	}

	/**
	 * 初始化树主界面
	 * @return
	 * @throws Exception
	 */
	public String initMainTree() throws Exception{
		this.getMainTreeService().initMainTree(this.getChangeTree());
		this.getOrgflag();
		return "my_initMainTree";
	}
	
	/**
	 * 判断是行政树还是业务树
	 * @return
	 * @throws Exception
	 */
	public String isAdminOrBusessTree() throws Exception{
		StringBuffer paramBuffer = new StringBuffer(100);
		paramBuffer.append("<script>window.location.href='");
		boolean isAdmin = StringUtils.isBlank(this.getChangeTree().getTopID());
		boolean falg = false;
		if(!isAdmin){//防止格式化null出错
			falg = Integer.parseInt(this.getChangeTree().getTopID()) < 1 ? true : false;
		}
		//topID为空或小于1显示行政树
		if(isAdmin || falg){//行政树
			paramBuffer.append("/deviceManagement/myMainTreeAction_initAdminTree.action?_ts=1"); //改成调用我的方法，原来的是/tree/initAdminTree_mainTree.action
		}else{
			//业务树
			paramBuffer.append("/tree/initBusessTree_mainTree.action?_ts=");
		}
	//	paramBuffer.append(new Date());
		if(StringUtils.isNotBlank(changeTree.getCheckcount())){
			paramBuffer.append("&changeTree.checkcount=").append(changeTree.getCheckcount());
		}
		if(StringUtils.isNotBlank(changeTree.getOrgType())){
			paramBuffer.append("&changeTree.orgType=").append(changeTree.getOrgType());
		}
		if(StringUtils.isNotBlank(changeTree.getCheckTitle())){
			paramBuffer.append("&changeTree.checkTitle=").append(changeTree.getCheckTitle());
		}
		if(StringUtils.isNotBlank(changeTree.getShowTabOrg())){
			paramBuffer.append("&changeTree.showTabOrg=").append(changeTree.getShowTabOrg());
		}
		if(StringUtils.isNotBlank(changeTree.getShowTabGroup())){
			paramBuffer.append("&changeTree.showTabGroup=").append(changeTree.getShowTabGroup());
		}
		if(StringUtils.isNotBlank(changeTree.getShowTabRole())){
			paramBuffer.append("&changeTree.showTabRole=").append(changeTree.getShowTabRole());
		}
		if(StringUtils.isNotBlank(changeTree.getShowSelBox())){
			paramBuffer.append("&changeTree.showSelBox=").append(changeTree.getShowSelBox());
		}
		if(StringUtils.isNotBlank(changeTree.getPosiType())){
			paramBuffer.append("&changeTree.posiType=").append(changeTree.getPosiType());
		}
		if(StringUtils.isNotBlank(changeTree.getLookupType())){
			paramBuffer.append("&changeTree.lookupType=").append(changeTree.getLookupType());
		}
		if(StringUtils.isNotBlank(changeTree.getLookupTypeStr())){
			paramBuffer.append("&changeTree.lookupTypeStr=").append(changeTree.getLookupTypeStr());
		}
		if(StringUtils.isNotBlank(changeTree.getOrgdegree())){
			paramBuffer.append("&changeTree.orgdegree=").append(changeTree.getOrgdegree());
		}
		if(StringUtils.isNotBlank(changeTree.getStartOrgid())){
			paramBuffer.append("&changeTree.startOrgid=").append(changeTree.getStartOrgid());
		}
		if(StringUtils.isNotBlank(changeTree.getStartOrgcode())){
			paramBuffer.append("&changeTree.startOrgcode=").append(changeTree.getStartOrgcode());
		}
		if(StringUtils.isNotBlank(changeTree.getTopID())){
			paramBuffer.append("&changeTree.topID=").append(changeTree.getTopID());
		}
		if(StringUtils.isNotBlank(changeTree.getTopName())){
			paramBuffer.append("&changeTree.topName=").append(changeTree.getTopName());
		}
		if(StringUtils.isNotBlank(changeTree.getPositioncode())){
			paramBuffer.append("&changeTree.positioncode=").append(changeTree.getPositioncode());
		}
		
		
		if(StringUtils.isNotBlank(orgflag)){
			paramBuffer.append("&orgflag=").append(orgflag);
		}
		
		paramBuffer.append("';</script>");
		this.write(paramBuffer.toString());
		return null;
	}
	
	/**
	 * 初始化行政树界面
	 * @return
	 * @throws Exception
	 */
	public String initAdminTree() throws Exception{
		this.getMainTreeService().initAdminTree(changeTree);
		this.getOrgflag();
		
		//查询登录人员的机构序列，如：厦门分行是.5425.   一类支行是.5425.5478.  用于将机构树展开到当前登入机构那一级
		loginOrgSeq = this.getCurrentOnlineUser().getOrgseq();
		this.setLoginOrgSeq(loginOrgSeq);
		
		return "my_adminTree";
		/*return queryOrg();*/
	}
	
	/**
	 * 查询行政树根机构
	 * @return
	 * @throws Exception
	 */
	public String selectAdminTreeRoot() throws Exception{
		HashMap<String, String> hmp = XmlConvert.getParamsAjax();
		/*String orgflag = String.valueOf(hmp.get("orgflag"));
		if("2".equals(orgflag)){
			hmp.put("parentid", "5478");  //5478为一类支行，表示“选择支行”时一进机构树就显示一类支行下的所有支行
		}*/
		List<Organization> orgList = this.getMyMainTreeService().selectAdminTreeNode(hmp, orgflag);
		String xml = XmlConvert.getXmlListBean(orgList);
		this.write(xml);
		return null;
	}
	
	/**
	 * 查询树子机构
	 * @return
	 * @throws Exception
	 */
	public String selectAdminTreeChild() throws Exception{
		HashMap paramMap = XmlConvert.getParamsAjax();
		String orgType = String.valueOf(paramMap.get("orgType"));
		String positioncode = String.valueOf(paramMap.get("p1"));
		
		String orgflag = String.valueOf(paramMap.get("orgflag"));
		
		paramMap = (HashMap)paramMap.get("oParentOrg");
		String parentid = String.valueOf(paramMap.get("orgid"));
		paramMap.put("parentid", parentid);
		List<Organization> orgList = new ArrayList<Organization>();
		
		if(!"2".equals(orgType)){
			orgList = this.getMyMainTreeService().selectAdminTreeNode(paramMap,orgflag);
		}
		List<Employee> empList = new ArrayList<Employee>();
		if(!"4".equals(orgType)){
			if(!"".equals(positioncode) && !"null".equals(positioncode)){
				paramMap.put("positioncode", positioncode);
				empList = this.getMainTreeService().selectPositionTreeEmpNode(paramMap);
			}else{
				empList = this.getMainTreeService().selectAdminTreeEmpNode(paramMap);
			}
			
		}
		String xml = XmlConvert.getXmlListBean(orgList,empList);
		this.write(xml);
		return null;
	}
	
}
