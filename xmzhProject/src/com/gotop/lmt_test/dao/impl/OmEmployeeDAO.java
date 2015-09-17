package com.gotop.lmt_test.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.gotop.group.dao.impl.TGroupDAO;
import com.gotop.group.model.TGroup;
import com.gotop.lmt_test.dao.IOmEmployeeDAO;
import com.gotop.lmt_test.model.OmEmployee;
import com.gotop.util.dataSource.SqlMapClientDao;
import com.primeton.utils.Page;

public class OmEmployeeDAO extends SqlMapClientDao implements IOmEmployeeDAO {

	protected Logger log = Logger.getLogger(OmEmployeeDAO.class);
	
	
	public OmEmployeeDAO() {
		super();
		// TODO 自动生成的构造函数存根
	}

	@Override
	public List myEmployeeList(Map<String, Object> map, Page page) throws Exception{
		List list = queryForList("OM_EMPLOYEE_SqlMap.myEmployeeList", map, page);
		return list;
	}

	/*
	 * 插入一条新数据.
	 */
	@Override
	public void insert(OmEmployee employee) throws Exception{
		 getSqlMapClientTemplate().insert("OM_EMPLOYEE_SqlMap.insert", employee);
		
	}

	/*
	 * 过主键更新一条全部字段内容
	 */
	@Override
	public int updateByPrimaryKey(OmEmployee employee) throws Exception{
		 int rows = getSqlMapClientTemplate().update("OM_EMPLOYEE_SqlMap.updateByPrimaryKey", employee);
	        return rows;
		
	}

	/*
	 * 通过主键查询一条记录
	 */
	@Override
	public OmEmployee selectByPrimaryKey(Long empid) throws Exception{
		OmEmployee key = new OmEmployee();
        key.setEmpid(empid);
		OmEmployee record = (OmEmployee) queryForObject("OM_EMPLOYEE_SqlMap.selectByPrimaryKey", key);
		return record;
	}

	@Override
	public int deleteByPrimaryKey(Long empid) throws Exception{
		OmEmployee key = new OmEmployee();
        key.setEmpid(empid);
		int rows = getSqlMapClientTemplate().delete("OM_EMPLOYEE_SqlMap.deleteByPrimaryKey", key);
		return rows;
	}

	@Override
	public int queryListByEmpcode(OmEmployee employee) throws Exception{
		
		
		int rows;
		if(queryForObject("OM_EMPLOYEE_SqlMap.selectByEmpcode", employee)==null){
			rows=0;
		}else{rows=	 (Integer)queryForObject("OM_EMPLOYEE_SqlMap.selectByEmpcode", employee);}
		
		return rows;
	}

}
