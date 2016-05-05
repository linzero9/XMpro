package com.gotop.deviceManagement.dao;

import java.util.HashMap;
import java.util.List;

import com.gotop.tyjg.common.model.Organization;

public interface IMyMainTreeDao {

	/**
	 * 查询行政树的机构节点
	 * @param hmp 查询条件
	 * @return 符合条件的根机构集合
	 * @throws Exception
	 */
	//选择部室
	public List<Organization> selectAdminTreeNode1(HashMap<String, String> hmp) throws Exception;
	
	//选择支行
	public List<Organization> selectAdminTreeNode2(HashMap<String, String> hmp) throws Exception;
}
