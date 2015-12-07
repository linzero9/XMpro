package com.gotop.Generalprocess.dao;

import java.util.HashMap;
import java.util.List;

import com.gotop.vo.tyjg.Omorganization;

public interface IGeneralprocessDAO {

	/**
	 * 根据多个empid查询出机构名称列表
	 * @param empIds
	 * @return
	 */
	public List queryOrgName(String empIds);

	public String isHaveParentOrgId(HashMap<String, Object> map);

	public Omorganization getParentOrgId(HashMap<String, Object> map);

}
