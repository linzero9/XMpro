package com.gotop.deviceManagement.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import com.gotop.deviceManagement.dao.IMyMainTreeDao;
import com.gotop.tyjg.common.model.Organization;
import com.gotop.util.dataSource.SqlMapClientDao;
import com.ibatis.common.util.PaginatedList;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapSession;
import com.ibatis.sqlmap.client.event.RowHandler;
import com.ibatis.sqlmap.engine.execution.BatchException;

public class MyMainTreeDao extends SqlMapClientDao implements IMyMainTreeDao {

	//选择部室
	@Override
	public List<Organization> selectAdminTreeNode1(HashMap<String, String> hmp)
			throws Exception {
		
		return this.queryForList("MyTree_SqlMap.selectAdminTreeRoot1", hmp);
	}

	//选择支行
		@Override
		public List<Organization> selectAdminTreeNode2(HashMap<String, String> hmp)
				throws Exception {
			
			return this.queryForList("MyTree_SqlMap.selectAdminTreeRoot2", hmp);
		}

}
