package com.gotop.reportjbpm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;


import com.gotop.reportjbpm.dao.TReportRefusalrateDao;
import com.gotop.reportjbpm.model.ErrorStatistic;
import com.gotop.reportjbpm.model.ReportRefusalrate;
import com.gotop.reportjbpm.service.TReportRefusalrateService;
import com.gotop.util.string.Obj2StrUtils;
import com.primeton.utils.Page;

public class ReportRefusalRateService implements TReportRefusalrateService{
	protected Logger log = Logger.getLogger(ReportRefusalRateService.class);
	private TReportRefusalrateDao reportRefusalrateDao;
		
	
	public TReportRefusalrateDao getReportRefusalrateDao() {
		return reportRefusalrateDao;
	}


	public void setReportRefusalrateDao(TReportRefusalrateDao reportRefusalrateDao) {
		this.reportRefusalrateDao = reportRefusalrateDao;
	}


	/**
	 * 查询拒贷信息列表
	 */
	@Override
	public List<ReportRefusalrate> selectReportRefusalRate(ReportRefusalrate reportRefusalrate, Page page) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		if (reportRefusalrate != null) {
			if (reportRefusalrate.getStratdate() !=null&&!"".equals(reportRefusalrate.getStratdate())) {
				map.put("stratdate", reportRefusalrate.getStratdate());
			}
			if (reportRefusalrate.getEnddate() != null&&!"".equals(reportRefusalrate.getEnddate())) {
				map.put("enddate", reportRefusalrate.getEnddate());
			}
		
			if(reportRefusalrate.getOneCategoryTxt()!=null && !"".equals(reportRefusalrate.getOneCategoryTxt())){
				String[] oneCategorys=reportRefusalrate.getOneCategoryTxt().split(", ");
				String oneCategory="";
				try {
					oneCategory = Obj2StrUtils.join(oneCategorys, String.class, ",");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				map.put("oneCategory",oneCategory);
			}
			if(reportRefusalrate.getLoanCategory()!=null && !"".equals(reportRefusalrate.getLoanCategory())){
				String[] loanCategorys=reportRefusalrate.getLoanCategoryTxt().split(", ");
				String loanCategory="";
				try {
					loanCategory = Obj2StrUtils.join(loanCategorys, String.class, ",");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				map.put("loanCategory",loanCategory);
			}
			
		}
		
		return reportRefusalrateDao.selectReportRefusalRate(map,page);
	}
	/**
	 * 导出拒贷信息列表
	 */
	@Override
	public List<ReportRefusalrate> queryReportRefusalrateExcel(ReportRefusalrate reportRefusalrate) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		if (reportRefusalrate != null) {
			if (reportRefusalrate.getStratdate() !=null&&!"".equals(reportRefusalrate.getStratdate())) {
				map.put("stratdate", reportRefusalrate.getStratdate());
			}
			if (reportRefusalrate.getEnddate() != null&&!"".equals(reportRefusalrate.getEnddate())) {
				map.put("enddate", reportRefusalrate.getEnddate());
			}
		
			if(reportRefusalrate.getOneCategoryTxt()!=null && !"".equals(reportRefusalrate.getOneCategoryTxt())){
				String[] oneCategorys=reportRefusalrate.getOneCategoryTxt().split(", ");
				String oneCategory="";
				try {
					oneCategory = Obj2StrUtils.join(oneCategorys, String.class, ",");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				map.put("oneCategory",oneCategory);
			}
			if(reportRefusalrate.getLoanCategory()!=null && !"".equals(reportRefusalrate.getLoanCategory())){
				String[] loanCategorys=reportRefusalrate.getLoanCategoryTxt().split(", ");
				String loanCategory="";
				try {
					loanCategory = Obj2StrUtils.join(loanCategorys, String.class, ",");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				map.put("loanCategory",loanCategory);
			}
			
		}
		
		return reportRefusalrateDao.queryReportRefusalrateForExcel(map);
			

	
	}
/**
 * 拒贷率合计
 */

	@Override
	public List<ReportRefusalrate> selectReportRefusalRateSum(
			ReportRefusalrate reportRefusalrate) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (reportRefusalrate != null) {
			if (reportRefusalrate.getStratdate() !=null&&!"".equals(reportRefusalrate.getStratdate())) {
				map.put("stratdate", reportRefusalrate.getStratdate());
			}
			if (reportRefusalrate.getEnddate() != null&&!"".equals(reportRefusalrate.getEnddate())) {
				map.put("enddate", reportRefusalrate.getEnddate());
			}
		
			if(reportRefusalrate.getOneCategoryTxt()!=null && !"".equals(reportRefusalrate.getOneCategoryTxt())){
				String[] oneCategorys=reportRefusalrate.getOneCategoryTxt().split(", ");
				String oneCategory="";
				try {
					oneCategory = Obj2StrUtils.join(oneCategorys, String.class, ",");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				map.put("oneCategory",oneCategory);
			}
			if(reportRefusalrate.getLoanCategory()!=null && !"".equals(reportRefusalrate.getLoanCategory())){
				String[] loanCategorys=reportRefusalrate.getLoanCategoryTxt().split(", ");
				String loanCategory="";
				try {
					loanCategory = Obj2StrUtils.join(loanCategorys, String.class, ",");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				map.put("loanCategory",loanCategory);
			}
			
		}
		
		return reportRefusalrateDao.selectReportRefusalRateSum(map);
	}	
	
	
}

	
