package com.gotop.Generalprocess.action;


import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.LinkedHashMap;
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
import com.gotop.opinion.model.TDefaultOpinion;
import com.gotop.opinion.service.ITDefaultOpinionService;
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
	
	
	
	
	private  List<String>  supportCategory;
	
	
	public List<String> getSupportCategory() {
		return supportCategory;
	}


	public void setSupportCategory(List<String> supportCategory) {
		this.supportCategory = supportCategory;
	}

	/**
	 * 模式对象
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
	 * isView :1、为只读状态， 默认为空
	 */
	private String isView;
	

    /**
     * 通过spring注入的Service对象.
     * @abatorgenerated
     */
    protected ITGeneralprocessModelsixService tGeneralprocessModelsixService;

    private List<TDefaultOpinion> defaultOps;
	
	private ITDefaultOpinionService tDefaultOpinionService;
    
    //action 开始
    
    
    
    
    public String toModelSix() throws SecurityException, IllegalArgumentException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException{
    	
    	//获取流程实例id
    	
    	         
    	//显示客户姓名  不可改        
    	
    	
    			String businessId = taskAssgineeDto.getExecutionId();
    			
    			taskName= taskAssgineeDto.getTaskName();
    			
    			//获取流程配置主表对象
    			TGeneralprocessMain main = this.generalprocessMainService.queryMainByBusinessId(businessId);
    			
    			MUOUserSession muo = getCurrentOnlineUser();
    			if(main != null){
    				if(main.getBeginEmpId() != null && main.getBeginOrgId() != null){
    					taskAssgineeDto.setBeginAssingee(main.getBeginEmpId());
    					taskAssgineeDto.setBeginOrg(main.getBeginOrgId());
    				}
    			}else{
    				taskAssgineeDto.setBeginAssingee(muo.getEmpid());
					taskAssgineeDto.setBeginOrg(muo.getOrgid());
    			}
    			
    			Map<String, Object> map = new LinkedHashMap<String, Object>();
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
    					if(map.containsKey(rule + "-" + id)){
    						continue;
    					}else{
    						map.put(rule + "-" + id, id);
    					}
    				}
    			}
    			
    			String rm = "";
    			if(newModelSix != null){
    				rm="ProcessModelSix" + "-" + newModelSix.getProcessModelId();
    				map.remove(rm);
    			}
    			
    			//模式6显示 客户名称
    			this.setModelSix(newModelSix);
    			
    			
    			
    			if(modelSix==null){
    				modelSix= new ProcessModelSix();
    			}
    			
    			if((!"start".equals(taskAssgineeDto.getStartFlag()))&&(!"detial".equals(taskAssgineeDto.getStartFlag()))&&(taskAssgineeDto.getBusinessTitle()!=null)){
    				//不是第一次  才能set  custname
    				modelSix.setCustName(taskAssgineeDto.getBusinessTitle().split("-")[1]);
    				
    			}
    			
    			// 
    			//页面的支用类型！  显示的东西  更具 T_GENERALPROCESS_SIXCONFIG 的配置信息读取！
    			String seachName=  taskAssgineeDto.getProcessName();
    			
    			if(seachName==null||"".equals(seachName)){
    				//如果传入的参数为空  那么就不要去查询了 因为查询出来的会是全部
    				supportCategory=null;
    			}else{
    				
    				supportCategory = generalprocessMainService.querySupportCategory(seachName);

    				
    			}
    			

    			
    			List<List<GeneralprocessFieldBean>> beans = GeneralprocessUtil.returnAllObj(map);
    			
    			String fxJson = JSONArray.fromObject(beans).toString();
    			taskAssgineeDto.setFxJson(fxJson);
    			
    			queryDefault(); 
    	return "modelSix_input";
    }
    
	public void queryDefault() {
		try {
			defaultOps = tDefaultOpinionService.queryDefaultOpsForshow(this
					.getCurrentOnlineUser().getEmpid());
		} catch (Exception e) {
			log.error("[获取默认意见失败]", e);
			e.printStackTrace();
		}
	}
    
    
      public  void  handleModelSix() throws Exception{
    	  
    	  

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

    public String getIsView() {
		return isView;
	}




	public void setIsView(String isView) {
		this.isView = isView;
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


	public List<TDefaultOpinion> getDefaultOps() {
		return defaultOps;
	}


	public void setDefaultOps(List<TDefaultOpinion> defaultOps) {
		this.defaultOps = defaultOps;
	}


	public ITDefaultOpinionService gettDefaultOpinionService() {
		return tDefaultOpinionService;
	}


	public void settDefaultOpinionService(
			ITDefaultOpinionService tDefaultOpinionService) {
		this.tDefaultOpinionService = tDefaultOpinionService;
	}
    
    
    
    
    
    

}