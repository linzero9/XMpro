package com.gotop.peopleManagement.action;

import java.util.ArrayList;
import java.util.List;

import com.gotop.crm.util.BaseAction;
import com.gotop.peopleManagement.model.OmInformation;
import com.gotop.peopleManagement.model.OmInformationVo;
import com.gotop.peopleManagement.service.IOmInformationService;

public class OmInformationAction extends BaseAction {
	
	private OmInformation omInformation;
	private List<OmInformation> omInformationList = new ArrayList<OmInformation>();
	private IOmInformationService omInformationService;
	private List<OmInformationVo>omInformationVoList = new ArrayList<OmInformationVo>();
	public List<OmInformationVo> getOmInformationVoList() {
		return omInformationVoList;
	}
	public void setOmInformationVoList(List<OmInformationVo> omInformationVoList) {
		omInformationVoList = omInformationVoList;
	}
	public OmInformation getOmInformation() {
		return omInformation;
	}
	public void setOmInformation(OmInformation omInformation) {
		this.omInformation = omInformation;
	}
	public List<OmInformation> getOmInformationList() {
		return omInformationList;
	}
	public void setOmInformationList(List<OmInformation> omInformationList) {
		this.omInformationList = omInformationList;
	}
	public IOmInformationService getOmInformationService() {
		return omInformationService;
	}
	public void setOmInformationService(IOmInformationService omInformationService) {
		this.omInformationService = omInformationService;
	}
	/**
	 * 查询人员信息
	 * @return
	 */
	public String queryOmInformationList(){
		omInformationList=omInformationService.selectOmInformationList(this.getOmInformation(),this.getPage());
		this.setPage(page);
		this.setOmInformationList(omInformationList);
		return"queryOmInformationList";
	}
	/**
	 * 查询所有机构
	 * @return
	 */
	public String queryOrgName(){
		omInformationVoList=omInformationService.queryOrgName();
		this.setOmInformationVoList(omInformationVoList);
		return"queryOrgName";
	};
	/**
	 * 查询所有业务角色
	 * @return
	 */
	public String queryRoleName(){
		omInformationVoList=omInformationService.queryRoleName();
		this.setOmInformationVoList(omInformationVoList);
		return"queryRoleName";
	};
	/**
	 * 查询所有岗位
	 * @return
	 */
	public String queryPosiName(){
		omInformationVoList=omInformationService.queryPosiName();
		this.setOmInformationVoList(omInformationVoList);
		return"queryPosiName";
	};

	
}
