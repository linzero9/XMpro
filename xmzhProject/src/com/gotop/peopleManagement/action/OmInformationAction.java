package com.gotop.peopleManagement.action;

import java.util.ArrayList;
import java.util.List;

import com.gotop.crm.util.BaseAction;
import com.gotop.peopleManagement.model.OmInformation;
import com.gotop.peopleManagement.service.IOmInformationService;

public class OmInformationAction extends BaseAction {
	
	private OmInformation omInformation;
	private List<OmInformation> omInformationList = new ArrayList<OmInformation>();
	private IOmInformationService omInformationService;
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

	
}
