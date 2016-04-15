package com.gotop.reportjbpm.dao;

import java.util.List;
import java.util.Map;

import com.gotop.reportjbpm.model.ErrorStatistic;
import com.primeton.utils.Page;

public interface IErrorStatisticDao {

	List<ErrorStatistic> queryErrorStatistic(Map<String, Object> map, Page page);


	List<ErrorStatistic> queryErrorStatisticForExcel(Map<String, Object> map);


	List<ErrorStatistic> querytaskNameList();

}
