package com.gotop.Generalprocess.service;

import com.gotop.Generalprocess.model.ProcessModel;
import com.gotop.Generalprocess.model.ProcessModelOne;
import com.gotop.Generalprocess.model.ProcessModelTwo;
import com.gotop.jbpm.dto.TaskAssgineeDto;
import com.gotop.vo.system.MUOUserSession;

public interface IGeneralprocessService {

	/**
	 * 新增模式一表单内容,完成模式一节点
	 * @param muo
	 * @param modelOne
	 * @param taskAssgineeDto
	 */
	public void handleModelOne(MUOUserSession muo, ProcessModelOne modelOne,
			TaskAssgineeDto taskAssgineeDto);

	/**
	 * 新增模式二表单内容,完成模式二节点
	 * @param muo
	 * @param modelTwo
	 * @param taskAssgineeDto
	 */
	public void handleModelTwo(MUOUserSession muo, ProcessModelTwo modelTwo,
			TaskAssgineeDto taskAssgineeDto);
	
	
	public void insertApproveOpninion(ProcessModel processModel,
			MUOUserSession muo, String taskId, String type, TaskAssgineeDto dto);

}
