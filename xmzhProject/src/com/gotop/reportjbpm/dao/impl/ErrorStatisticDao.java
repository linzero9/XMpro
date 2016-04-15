package com.gotop.reportjbpm.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gotop.reportjbpm.dao.IErrorStatisticDao;
import com.gotop.reportjbpm.model.ErrorStatistic;
import com.gotop.util.dataSource.SqlMapClientDao;
import com.primeton.utils.Page;

public class ErrorStatisticDao extends SqlMapClientDao implements IErrorStatisticDao {

	@Override
	public List<ErrorStatistic> queryErrorStatistic(Map<String, Object> map,
			Page page) {
		
		return queryForList("T_ERRORSTATISTIC_SqlMap.queryErrorStatistic",map,page);
	}



	@Override
	public List<ErrorStatistic> queryErrorStatisticForExcel(
			Map<String, Object> map) {
		return queryForList("T_ERRORSTATISTIC_SqlMap.queryErrorStatistic",map);
	}



	@Override
	public List<ErrorStatistic> querytaskNameList() {
		return queryForList("T_ERRORSTATISTIC_SqlMap.querytaskNameList", new HashMap());
	}

}
