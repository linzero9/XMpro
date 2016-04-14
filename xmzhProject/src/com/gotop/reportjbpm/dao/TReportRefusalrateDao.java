package com.gotop.reportjbpm.dao;

import java.util.List;
import java.util.Map;

import com.gotop.reportjbpm.model.ReportRefusalrate;
import com.primeton.utils.Page;

public interface TReportRefusalrateDao {

	List<ReportRefusalrate> selectReportRefusalRate(Map<String, Object> map,Page page);

}
