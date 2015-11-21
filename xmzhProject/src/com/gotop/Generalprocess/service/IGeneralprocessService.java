package com.gotop.Generalprocess.service;

import java.util.List;

import com.gotop.Generalprocess.model.ProcessModelOne;
import com.gotop.jbpm.dto.TaskAssgineeDto;
import com.gotop.vo.system.MUOUserSession;

public interface IGeneralprocessService {

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
	 * 新增模式一表单内容,完成模式一节点
	 * @param muo
	 * @param modelOne
	 * @param taskAssgineeDto
	 */
	public void handleModelOne(MUOUserSession muo, ProcessModelOne modelOne,
			TaskAssgineeDto taskAssgineeDto);

	/**
	 * 根据业务主键和实例id查找模式一对象
	 * @param processModelId
	 * @param flowId
	 * @return
	 */
	public ProcessModelOne queryModelOne(String processModelId, String flowId);
	
}
