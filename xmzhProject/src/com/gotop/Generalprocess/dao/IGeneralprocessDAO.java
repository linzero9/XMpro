package com.gotop.Generalprocess.dao;

import java.util.List;

import com.gotop.Generalprocess.model.ProcessModelOne;

public interface IGeneralprocessDAO {

	/**
	 * 新增模式一对象
	 * @param modelOne
	 */
	public void addModelOne(ProcessModelOne modelOne);
	
	/**
	 * 修改模式一对象
	 * @param modelOne
	 */
	public void uptModelOne(ProcessModelOne modelOne);
	
	/**
	 * 根据id查找到模式一对象
	 * @param id
	 * @return
	 */
	public ProcessModelOne getProcessModelOneById(String id);
	
	/**
	 * 根据流程实例id查找到多个模式一对象
	 * @param bussinessId
	 * @return
	 */
	public List<ProcessModelOne> getProcessModelOneByBussinessId(String bussinessId);
	
	/**
	 * 根据多个empid查询出机构名称列表
	 * @param empIds
	 * @return
	 */
	public List queryOrgName(String empIds);
	
}
