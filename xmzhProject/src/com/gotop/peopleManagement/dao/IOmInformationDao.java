package com.gotop.peopleManagement.dao;

import java.util.List;
import java.util.Map;

import com.gotop.peopleManagement.model.OmInformation;
import com.gotop.peopleManagement.model.OmInformationVo;
import com.primeton.utils.Page;

public interface IOmInformationDao {

	List<OmInformation> selectOmInformationList(Map<String, Object> map,Page page);

	List<OmInformationVo> queryOrgName();

	List<OmInformationVo> queryRoleName();

	List<OmInformationVo> queryPosiName();

}
