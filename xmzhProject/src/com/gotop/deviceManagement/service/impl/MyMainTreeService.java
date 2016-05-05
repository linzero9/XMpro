package com.gotop.deviceManagement.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.gotop.deviceManagement.dao.IMyMainTreeDao;
import com.gotop.deviceManagement.service.IMyMainTreeService;
import com.gotop.tyjg.common.dao.IMainTreeDao;
import com.gotop.tyjg.common.model.Organization;

public class MyMainTreeService implements IMyMainTreeService {

	private IMainTreeDao mainTreeDao;
	private IMyMainTreeDao myMainTreeDao;
	
	
	public IMainTreeDao getMainTreeDao() {
		return mainTreeDao;
	}
	public void setMainTreeDao(IMainTreeDao mainTreeDao) {
		this.mainTreeDao = mainTreeDao;
	}
	
	
	public IMyMainTreeDao getMyMainTreeDao() {
		return myMainTreeDao;
	}
	public void setMyMainTreeDao(IMyMainTreeDao myMainTreeDao) {
		this.myMainTreeDao = myMainTreeDao;
	}
	/**
	 * 查询行政树的机构节点
	 * @param hmp 查询条件
	 * @return 符合条件的机构集合
	 * @throws Exception
	 */
	public List<Organization> selectAdminTreeNode(HashMap<String, String> hmp, String orgflag) throws Exception{
		HashMap<String, String> paramMap = new HashMap<String, String>(10);
		if(hmp.containsKey("startorgid")){
			paramMap.put("startorgid", hmp.get("startorgid"));
		}else if(hmp.containsKey("parentid")){
			paramMap.put("parentid", hmp.get("parentid"));
		}else{
			paramMap.put("parent", "parent");
		}
		if(hmp.containsKey("startorgcode")){
			paramMap.put("startorgcode", hmp.get("startorgcode"));
		}else if(hmp.containsKey("parentid")){
			paramMap.put("parentid", hmp.get("parentid"));
		}else if(!hmp.containsKey("startorgid")){
			paramMap.put("parent", "parent");
		}
		if(hmp.containsKey("jgsx")){
			paramMap.put("jgsx", hmp.get("jgsx"));
		}
		
		List<Organization> orgList = new ArrayList<Organization>();
		if("5425".equals(hmp.get("parentid")) ){
			if("1".equals(orgflag)){
				orgList =  this.getMyMainTreeDao().selectAdminTreeNode1(paramMap);
			}else if("2".equals(orgflag)){
				orgList =  this.getMyMainTreeDao().selectAdminTreeNode2(paramMap);
			}else{
				orgList =  this.getMainTreeDao().selectAdminTreeNode(paramMap);
			}
		}else{
			orgList =  this.getMainTreeDao().selectAdminTreeNode(paramMap);
		}
		return orgList;
	}

}
