package com.gotop.peopleManagement.dao.impl;

import java.util.List;
import java.util.Map;

import com.gotop.peopleManagement.dao.IOmInformationDao;
import com.gotop.peopleManagement.model.OmInformation;
import com.gotop.peopleManagement.model.OmInformationVo;
import com.gotop.util.dataSource.SqlMapClientDao;
import com.primeton.utils.Page;

public class OmInformationDao extends SqlMapClientDao implements IOmInformationDao {

	

	
	/**
	 * 查询所有机构
	 * @return
	 */
	@Override
	public List<OmInformationVo> queryOrgName() {
		return queryForList("T_OMINFORMATION_SqlMap.queryOrgName",null);
	}
	/**
	 * 查询所有业务角色
	 * @return
	 */
	@Override
	public List<OmInformationVo> queryRoleName() {
		return queryForList("T_OMINFORMATION_SqlMap.queryRoleName", null);
	}
	
	/**
	 * 查询所有岗位
	 * @return
	 */
	@Override
	public List<OmInformationVo> queryPosiName() {
		return queryForList("T_OMINFORMATION_SqlMap.queryPosiName", null);
	}
	
	@Override
	public List<OmInformation> selectOmInformationList(Map<String, Object> map,
			Page page) {
		return queryForList("T_OMINFORMATION_SqlMap.queryOmInformationList", map, page);
	}

}
