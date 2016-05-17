package com.gotop.peopleManagement.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.gotop.deviceManagement.service.impl.DeviceManagementService;
import com.gotop.peopleManagement.dao.IOmInformationDao;
import com.gotop.peopleManagement.model.OmInformation;
import com.gotop.peopleManagement.model.OmInformationVo;
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
				
				 StringBuffer stringBuffer = new StringBuffer();
				
					 String[] array =omInformation.getOrgName().split(",");
					 for (int i = 0; i < array.length; i++) {
						 stringBuffer.append("'");
						stringBuffer.append(array[i]);
						stringBuffer.append("'");
						stringBuffer.append(",");
				}
					 stringBuffer=stringBuffer.deleteCharAt(stringBuffer.length()-1);
				      map.put("orgName", stringBuffer);
			}
			if (omInformation.getEmpName() != null&&!"".equals(omInformation.getEmpName())) {
				map.put("empName", omInformation.getEmpName().trim());
			}
			if (omInformation.getEmpCode()!=null&&!"".equals(omInformation.getEmpCode())) {
				map.put("empCode", omInformation.getEmpCode().trim());
			}
			if (omInformation.getPosiName()!=null&&!"".equals(omInformation.getPosiName())) {
				 StringBuffer stringBuffer = new StringBuffer();
					
				 String[] array =omInformation.getPosiName().split(",");
				 for (int i = 0; i < array.length; i++) {
					 stringBuffer.append("'");
					stringBuffer.append(array[i]);
					stringBuffer.append("'");
					stringBuffer.append(",");
			}
				 stringBuffer=stringBuffer.deleteCharAt(stringBuffer.length()-1);
			     map.put("posiName", stringBuffer);
			}
			if (omInformation.getRoleName()!=null&&!"".equals(omInformation.getRoleName())) {
				 StringBuffer stringBuffer = new StringBuffer();
					
				 String[] array =omInformation.getRoleName().split(",");
				 for (int i = 0; i < array.length; i++) {
					 stringBuffer.append("'");
					stringBuffer.append(array[i]);
					stringBuffer.append("'");
					stringBuffer.append(",");
			}
				 stringBuffer=stringBuffer.deleteCharAt(stringBuffer.length()-1);
			     map.put("roleName", stringBuffer);
				
			}
		}
		
		return omInformationDao.selectOmInformationList(map,page);
	}

	/**
	 * 查询所有机构
	 * @return
	 */
	@Override
	public List<OmInformationVo> queryOrgName() {
		return omInformationDao.queryOrgName();
	}

	/**
	 * 查询所有业务角色
	 * @return
	 */
	@Override
	public List<OmInformationVo> queryRoleName() {
		return omInformationDao.queryRoleName();
	}

	/**
	 * 查询所有岗位
	 * @return
	 */
	@Override
	public List<OmInformationVo> queryPosiName() {
		
		return omInformationDao.queryPosiName();
	}

}
