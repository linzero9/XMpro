package com.gotop.Generalprocess.dao;

import java.util.HashMap;
import java.util.List;

public interface IGeneralprocessDAO {

	/**
	 * 根据多个empid查询出机构名称列表
	 * @param empIds
	 * @return
	 */
	public List queryOrgName(String empIds);

	public String isHaveParentOrgId(HashMap<String, Object> map);

}
