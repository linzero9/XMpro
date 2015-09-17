package com.gotop.lmt_test.dao;

import java.util.List;
import java.util.Map;

import com.gotop.lmt_test.model.OmEmployee;
import com.primeton.utils.Page;

public interface IOmEmployeeDAO {

	
	List myEmployeeList(Map<String,Object> map,Page page) throws Exception;

	void insert(OmEmployee employee) throws Exception;

	int updateByPrimaryKey(OmEmployee employee) throws Exception;

	OmEmployee selectByPrimaryKey(Long empid) throws Exception;

	int deleteByPrimaryKey(Long empid) throws Exception;

	int queryListByEmpcode(OmEmployee employee) throws Exception;
}
