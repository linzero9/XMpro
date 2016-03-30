package com.gotop.peopleManagement.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.gotop.deviceManagement.service.impl.DeviceManagementService;
import com.gotop.peopleManagement.dao.IOmInformationDao;
import com.gotop.peopleManagement.model.OmInformation;
import com.gotop.peopleManagement.service.IOmInformationService;
import com.primeton.utils.Page;

public class OmInformationService implements IOmInformationService{
	protected Logger log = Logger.getLogger(OmInformationService.class);
	private IOmInformationDao omInformationDao;
		
	
	public IOmInformationDao getOmInformationDao() {
		return omInformationDao;
	}


	public void setOmInformationDao(IOmInformationDao omInformationDao) {
		this.omInformationDao = omInformationDao;
	}


	/**
	 * 查询人员信息列表
	 */
	@Override
	public List<OmInformation> selectOmInformationList(OmInformation omInformation, Page page) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		if (omInformation != null) {
			if (omInformation.getOrgName() !=null&&!"".equals(omInformation.getOrgName())) {
				map.put("orgName", omInformation.getOrgName());
			}
			if (omInformation.getEmpName() != null&&!"".equals(omInformation.getEmpName())) {
				map.put("empName", omInformation.getEmpName());
			}
			if (omInformation.getEmpCode()!=null&&!"".equals(omInformation.getEmpCode())) {
				map.put("empCode", omInformation.getEmpCode());
			}
			if (omInformation.getPosiName()!=null&&!"".equals(omInformation.getPosiName())) {
				map.put("posiName", omInformation.getPosiName());
			}
			if (omInformation.getRoleName()!=null&&!"".equals(omInformation.getRoleName())) {
				map.put("roleName", omInformation.getRoleName());
			}
		}
		
		return omInformationDao.selectOmInformationList(map,page);
	}

}
