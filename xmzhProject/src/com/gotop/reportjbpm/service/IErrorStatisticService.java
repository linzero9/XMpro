package com.gotop.reportjbpm.service;

import java.util.List;

import com.gotop.reportjbpm.model.ErrorStatistic;
import com.primeton.utils.Page;

public interface IErrorStatisticService {

	

	List<ErrorStatistic> queryErrorStatistic(ErrorStatistic errorStatistic,Page page);


	List<ErrorStatistic> querytaskNameList();

	List<ErrorStatistic> queryErrorStatisticExcel(ErrorStatistic errorStatistic);

}
