package com.gotop.peopleManagement.service;

import java.util.List;

import com.gotop.peopleManagement.dao.IOmInformationDao;
import com.gotop.peopleManagement.model.OmInformation;
import com.gotop.peopleManagement.model.OmInformationVo;
import com.primeton.utils.Page;

public interface IOmInformationService {
	
	
	IOmInformationDao getOmInformationDao();
	
	void setOmInformationDao(IOmInformationDao omInformationDao);
	
	List<OmInformation> selectOmInformationList(OmInformation omInformation,Page page);

	List<OmInformationVo> queryOrgName();

	List<OmInformationVo> queryRoleName();

	List<OmInformationVo> queryPosiName();

}
