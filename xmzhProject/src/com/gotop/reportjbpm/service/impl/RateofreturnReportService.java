package com.gotop.reportjbpm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.gotop.reportjbpm.dao.IRateofreturnReportDao;
import com.gotop.reportjbpm.model.RateofreturnReport;
import com.gotop.reportjbpm.service.IRateofreturnReportService;
import com.gotop.util.string.Obj2StrUtils;
import com.primeton.utils.Page;

public class RateofreturnReportService implements IRateofreturnReportService {
	
	protected Logger log = Logger.getLogger(RateofreturnReportService.class);
	private IRateofreturnReportDao rateofreturnReportDao;
	@Override
	public IRateofreturnReportDao getIRefusalrateReportDao() {
		// TODO Auto-generated method stub
		return rateofreturnReportDao;
	}
	@Override
	public void setRateofreturnReportDao(
			IRateofreturnReportDao rateofreturnReportDao) {
		this.rateofreturnReportDao=rateofreturnReportDao;
	}
	
	/**
	 * 退单率查询
	 */
	@Override
	public List<RateofreturnReport> rateofreturnReportList(
			RateofreturnReport rateofreturnReport, Page page) {
		Map<String, Object> map=new HashMap<String, Object>();
		
		if(rateofreturnReport!=null){

			   if(!"".equals(rateofreturnReport.getAppTimeStrat()) && rateofreturnReport.getAppTimeStrat()!=null){

				   String appTimeStrat=rateofreturnReport.getAppTimeStrat();
					map.put("appTimeStrat", appTimeStrat);
				}
			
		   if(!"".equals(rateofreturnReport.getAppTimeEnd()) && rateofreturnReport.getAppTimeEnd()!=null){

			   String appTimeEnd=rateofreturnReport.getAppTimeEnd();
				map.put("appTimeEnd", appTimeEnd);
			}
			if(!"".equals(rateofreturnReport.getOneCategory())){
				String[] oneCategorys=rateofreturnReport.getOneCategory().split(", ");
				String oneCategory="";
				try {
					oneCategory = Obj2StrUtils.join(oneCategorys, String.class, ",");
				} catch (Exception e) {
					e.printStackTrace();
				}
				map.put("oneCategory", oneCategory);
			}
			if(!"".equals(rateofreturnReport.getLoanCategory())){
				String[] loanCategorys=rateofreturnReport.getLoanCategory().split(", ");
				String loanCategory="";
				try {
					loanCategory = Obj2StrUtils.join(loanCategorys, String.class, ",");
				} catch (Exception e) {
					e.printStackTrace();
				}
				 map.put("loanCategory",loanCategory);
			
			}
			
		}
		
		List list=rateofreturnReportDao.rateofreturnReportList(map, page);
		
		return list;
	}
	@Override
	public List<RateofreturnReport> rateofreturnReportListExcel(
			RateofreturnReport rateofreturnReport) {
		Map<String, Object> map=new HashMap<String, Object>();
		
		if(rateofreturnReport!=null){
		   if(!"".equals(rateofreturnReport.getAppTimeStrat()) && rateofreturnReport.getAppTimeStrat()!=null){

			   String appTimeStrat=rateofreturnReport.getAppTimeStrat();
				map.put("appTimeStrat", appTimeStrat);
			}
		
	   if(!"".equals(rateofreturnReport.getAppTimeEnd()) && rateofreturnReport.getAppTimeEnd()!=null){

		   String appTimeEnd=rateofreturnReport.getAppTimeEnd();
			map.put("appTimeEnd", appTimeEnd);
		}

			
			if(!"".equals(rateofreturnReport.getOneCategory())){
				String[] oneCategorys=rateofreturnReport.getOneCategory().split(", ");
				String oneCategory="";
				try {
					oneCategory = Obj2StrUtils.join(oneCategorys, String.class, ",");
				} catch (Exception e) {
					e.printStackTrace();
				}
				map.put("oneCategory", oneCategory);
			}
			if(!"".equals(rateofreturnReport.getLoanCategory())){
				String[] loanCategorys=rateofreturnReport.getLoanCategory().split(", ");
				String loanCategory="";
				try {
					loanCategory = Obj2StrUtils.join(loanCategorys, String.class, ",");
				} catch (Exception e) {
					e.printStackTrace();
				}
				 map.put("loanCategory",loanCategory);
			
			}

		}
		
		
		List list=rateofreturnReportDao.rateofreturnReportListExcel(map);
		
		return list;
	}



}
