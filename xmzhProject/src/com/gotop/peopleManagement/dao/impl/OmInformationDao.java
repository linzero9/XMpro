package com.gotop.peopleManagement.dao.impl;

import java.util.List;
import java.util.Map;

import com.gotop.peopleManagement.dao.IOmInformationDao;
import com.gotop.peopleManagement.model.OmInformation;
import com.gotop.util.dataSource.SqlMapClientDao;
import com.primeton.utils.Page;

public class OmInformationDao extends SqlMapClientDao implements IOmInformationDao {

	

	

	@Override
	public List<OmInformation> selectOmInformationList(Map<String, Object> map,
			Page page) {
		return queryForList("T_OMINFORMATION_SqlMap.queryOmInformationList", map, page);
	}

}
