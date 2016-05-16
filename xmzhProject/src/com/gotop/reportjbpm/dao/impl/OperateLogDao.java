package com.gotop.reportjbpm.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gotop.reportjbpm.dao.IOperateLogDao;
import com.gotop.reportjbpm.model.OperateLog;
import com.gotop.util.dataSource.SqlMapClientDao;
import com.primeton.utils.Page;

public class OperateLogDao extends SqlMapClientDao implements IOperateLogDao {

	@Override
	public List<OperateLog> queryOperateLog(Map<String, Object> map, Page page) {
		
		return queryForList("T_OPERATELOG_SqlMap.queryOperateLog",map,page);
		
	}

	@Override
	public List<OperateLog> queryOperateLogForExcel(Map<String, Object> map) {
		return queryForList("T_OPERATELOG_SqlMap.queryOperateLog",map);
	}

	@Override
	public List<OperateLog> listNodName() {
		// TODO Auto-generated method stub
		return queryForList("T_OPERATELOG_SqlMap.listNodName",new HashMap());
	}

}
