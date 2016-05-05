package com.gotop.deviceManagement.service;

import java.util.HashMap;
import java.util.List;

import com.gotop.tyjg.common.model.Organization;

public interface IMyMainTreeService {

	/**
	 * 查询行政树的机构节点
	 * @param hmp 查询条件
	 * @return 符合条件的机构集合
	 * @throws Exception
	 */
	public List<Organization> selectAdminTreeNode(HashMap<String, String> hmp, String orgflag) throws Exception;
}
