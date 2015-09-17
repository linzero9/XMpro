package com.gotop.lmt_test.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.gotop.group.service.impl.TGroupService;
import com.gotop.lmt_test.dao.IOmEmployeeDAO;
import com.gotop.lmt_test.model.OmEmployee;
import com.gotop.lmt_test.service.IOmEmployeeService;
import com.primeton.utils.Page;

public class OmEmployeeService implements IOmEmployeeService {

	protected Logger log = Logger.getLogger(OmEmployeeService.class);
	
	protected  IOmEmployeeDAO omEmployeeDAO;
	
	public IOmEmployeeDAO getOmEmployeeDAO() {
		return omEmployeeDAO;
	}

	public void setOmEmployeeDAO(IOmEmployeeDAO omEmployeeDAO) {
		this.omEmployeeDAO = omEmployeeDAO;
	}

	@Override
	public List<OmEmployee> myEmployeeList(OmEmployee employee, Page page) throws Exception {
		Map<String,Object> map = new HashMap<String,Object>();
		if(employee != null && employee.getEmpname() != null && !"".equals(employee.getEmpname())){
			map.put("empName", employee.getEmpname());
		}
		List list = omEmployeeDAO.myEmployeeList(map,page);
		return list;
	}

	@Override
	public void save(OmEmployee employee) throws Exception {
		
		if(employee.getEmpid() == null){
			//保存员工信息
			omEmployeeDAO.insert(employee);
		}else{
			omEmployeeDAO.updateByPrimaryKey(employee);
		}
		
		
	}

	@Override
	public OmEmployee getEmployeeByEmpid(OmEmployee employee) throws Exception {
		OmEmployee omEmployee = omEmployeeDAO.selectByPrimaryKey(employee.getEmpid());
		return omEmployee;
	}

	@Override
	public void delete(OmEmployee employee) throws Exception {
		omEmployeeDAO.deleteByPrimaryKey(employee.getEmpid());
		
	}

	@Override
	public int queryListByEmpcode(OmEmployee employee) throws Exception {
		int count = omEmployeeDAO.queryListByEmpcode(employee);
		return count;
	}

}
