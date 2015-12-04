package com.gotop.Generalprocess.action;


import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import com.gotop.Generalprocess.annonation.GeneralprocessFieldBean;
import com.gotop.Generalprocess.model.ProcessModelFour;
import com.gotop.Generalprocess.model.ProcessModelSix;
import com.gotop.Generalprocess.model.TGeneralprocessMain;
import com.gotop.Generalprocess.service.ITGeneralprocessMainService;
import com.gotop.Generalprocess.service.ITGeneralprocessModelsixService;
import com.gotop.Generalprocess.util.GeneralprocessUtil;
import com.gotop.crm.util.BaseAction;

import com.gotop.jbpm.dto.TaskAssgineeDto;
import com.gotop.jbpm.service.JbpmService;
import com.gotop.util.Struts2Utils;
import com.gotop.vo.system.MUOUserSession;

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
    
    
    
    
    public String toModelSix() throws SecurityException, IllegalArgumentException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException{
    	
    	//获取流程实例id
    			String businessId = taskAssgineeDto.getExecutionId();
    			
    			taskName= taskAssgineeDto.getTaskName();
    			
    			//获取流程配置主表对象
    			TGeneralprocessMain main = this.generalprocessMainService.queryMainByBusinessId(businessId);
    			Map<String, Object>  map = new HashMap<String, Object>();
    			String taskName1 = "";
    			if(taskAssgineeDto.getNextTaskId() != null){
    				//待办-办理
    				taskName1 = jbpmService.getTaskNameById(taskAssgineeDto.getNextTaskId());
    			}else{
    				if(taskAssgineeDto.getActivityName() != null){
    					//已办-查看详情
    					taskName1 = taskAssgineeDto.getActivityName();
    					taskName=taskName1;
    				}
    			}
    			
    			
    			ProcessModelSix newModelSix = new ProcessModelSix();
    			if(businessId != null && taskName1 != null){
    				ProcessModelSix modelSix = new ProcessModelSix();
        			modelSix.setFlowId(businessId);
        			modelSix.setTaskName(taskName1);
        			newModelSix = this.tGeneralprocessModelsixService.queryModelSixByFlowIdAndTaskName(modelSix);
    			}
    			
    			String[] rulesArray = null;
    			String[] idsArray = null;
    			if(main != null){
    				if(main.getRules() != null && !"".equals(main.getRules())){
    					String rules = main.getRules();
    					rulesArray = rules.split(",");
    				}
    				
    				if(main.getIds() != null && !"".equals(main.getIds())){
    					String ids = main.getIds();
    					idsArray = ids.split(",");
    				}
    				
    				for (int i = 0; i < idsArray.length; i++) {
    					String id = idsArray[i];
    					String rule = rulesArray[i];
    					map.put(rule + "-" + id, id);
    				}
    			}
    			
    			String rm = "";
    			if(newModelSix != null){
    				rm="ProcessModelSix" + "-" + newModelSix.getProcessModelId();
    				map.remove(rm);
    			}
    			
    			
    			this.setModelSix(newModelSix);
    			
    		
    			
    			List<List<GeneralprocessFieldBean>> beans = GeneralprocessUtil.returnAllObj(map);
    			
    			String fxJson = JSONArray.fromObject(beans).toString();
    			taskAssgineeDto.setFxJson(fxJson);
    			
    	
    	return "modelSix_input";
    }
    
    
    
    
      public  void  handleModelSix() throws Exception{
    	  
    	  System.out.println("222");
    	  
    	  

  		String info ="success";
      	MUOUserSession muo = getCurrentOnlineUser();
  		try {
  			this.tGeneralprocessModelsixService.handleModelSix(muo,modelSix,taskAssgineeDto,"test1","test2");
  		} catch (Exception e) {
  			info="fails";
  			log.error("[提交模式四表单失败！]", e);
  			throw e;
  		}
  		Struts2Utils.renderText(info);

      }
    
    
    
    
    
    
    
    
    
    
	
	
	

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