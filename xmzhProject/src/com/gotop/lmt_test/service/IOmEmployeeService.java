package com.gotop.lmt_test.service;

import java.util.List;

import com.gotop.lmt_test.dao.IOmEmployeeDAO;
import com.gotop.lmt_test.model.OmEmployee;
import com.primeton.utils.Page;

public interface IOmEmployeeService {
	
	/**
     * 通过spring注入DAO的set类.
     * @abatorgenerated
     */
	void setOmEmployeeDAO(IOmEmployeeDAO omEmployeeDAO) throws Exception;
	
	/**
     * 通过spring注入DAO的get类.
     * @abatorgenerated
     */
	IOmEmployeeDAO getOmEmployeeDAO() throws Exception;

	List<OmEmployee> myEmployeeList(OmEmployee employee,Page page) throws Exception;

	void save(OmEmployee employee) throws Exception;

	OmEmployee getEmployeeByEmpid(OmEmployee employee) throws Exception;

	void delete(OmEmployee employee) throws Exception;

	int queryListByEmpcode(OmEmployee employee) throws Exception;
}
