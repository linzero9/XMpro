package com.gotop.Generalprocess.action;


import com.gotop.Generalprocess.model.ProcessModelSix;
import com.gotop.Generalprocess.service.ITGeneralprocessMainService;
import com.gotop.Generalprocess.service.ITGeneralprocessModelsixService;
import com.gotop.crm.util.BaseAction;

import com.gotop.jbpm.dto.TaskAssgineeDto;
import com.gotop.jbpm.service.JbpmService;

/**
 * 
 * @author wujiajun
 * 
 *
 */
public class TGeneralprocessModelsixAction extends BaseAction {
	
	
	
	//output    input 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 模式四对象
	 */
	private ProcessModelSix modelSix;
	
	/**
	 * 页面传输对象
	 */
	private TaskAssgineeDto taskAssgineeDto;
	/**
	 * 模式主表服务
	 */
	private ITGeneralprocessMainService generalprocessMainService;
	/**
	 * jbpm服务
	 */
	private JbpmService jbpmService;
	
	/**
	 * 页面标题展示
	 */
	private String taskName;
	
	

    /**
     * 通过spring注入的Service对象.
     * @abatorgenerated
     */
    protected ITGeneralprocessModelsixService tGeneralprocessModelsixService;

    
    
    //action 开始
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
	
	
	

    /**
     * 通过spring注入Service的set类.
     * @abatorgenerated
     */
    public void settGeneralprocessModelsixService(ITGeneralprocessModelsixService tGeneralprocessModelsixService) {
        this.tGeneralprocessModelsixService = tGeneralprocessModelsixService;
    }

    /**
     * 通过spring注入Service的get类.
     * @abatorgenerated
     */
    public ITGeneralprocessModelsixService gettGeneralprocessModelsixService() {
        return this.tGeneralprocessModelsixService;
    }

	public ProcessModelSix getModelSix() {
		return modelSix;
	}

	public void setModelSix(ProcessModelSix modelSix) {
		this.modelSix = modelSix;
	}

	public TaskAssgineeDto getTaskAssgineeDto() {
		return taskAssgineeDto;
	}

	public void setTaskAssgineeDto(TaskAssgineeDto taskAssgineeDto) {
		this.taskAssgineeDto = taskAssgineeDto;
	}

	public ITGeneralprocessMainService getGeneralprocessMainService() {
		return generalprocessMainService;
	}

	public void setGeneralprocessMainService(
			ITGeneralprocessMainService generalprocessMainService) {
		this.generalprocessMainService = generalprocessMainService;
	}

	public JbpmService getJbpmService() {
		return jbpmService;
	}

	public void setJbpmService(JbpmService jbpmService) {
		this.jbpmService = jbpmService;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
    
    
    
    
    
    
    

}