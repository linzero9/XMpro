package com.gotop.Generalprocess.action;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.gotop.Generalprocess.annonation.GeneralprocessFieldBean;
import com.gotop.Generalprocess.model.ProcessModelOne;
import com.gotop.Generalprocess.model.ProcessModelTwo;
import com.gotop.Generalprocess.model.TGeneralprocessMain;
import com.gotop.Generalprocess.service.IGeneralprocessService;
import com.gotop.Generalprocess.service.ITGeneralprocessMainService;
import com.gotop.Generalprocess.service.ITGeneralprocessModeloneService;
import com.gotop.Generalprocess.util.GeneralprocessUtil;
import com.gotop.crm.util.BaseAction;
import com.gotop.jbpm.dto.TaskAssgineeDto;
import com.gotop.opinion.model.TDefaultOpinion;
import com.gotop.opinion.service.ITDefaultOpinionService;
import com.gotop.util.Struts2Utils;
import com.gotop.vo.system.MUOUserSession;

public class GeneralprocessAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	/**
	 * 
	 * @author wsd
	 * @desc 模式一页面对象
	 * 
	 */
	private ProcessModelOne modelOne;
	
	/**
	 * @author wsd
	 * @desc 模式二页面对象
	 * 
	 */
	private ProcessModelTwo modelTwo;

	/**
	 * 
	 * @author wsd
	 * @desc 默认意见
	 * 
	 */
	private List<TDefaultOpinion> defaultOps;

	/**
	 * 
	 * @author wsd
	 * @desc 与流程相关的对象
	 * 
	 */
	private TaskAssgineeDto taskAssgineeDto;

	/**
	 * isView :1、为只读状态， 默认为空
	 */
	private String isView;
	
	/**
	 * 
	 * @author wsd
	 * @desc 默认意见服务
	 * 
	 */
	private ITDefaultOpinionService tDefaultOpinionService;
	
	private IGeneralprocessService generalProcessService;
	
	/**
	 * 模式一服务
	 */
	private ITGeneralprocessModeloneService generalprocessModeloneService;
	
	/**
	 * 模式主表服务
	 */
	private ITGeneralprocessMainService generalprocessMainService;
	
	public ProcessModelTwo getModelTwo() {
		return modelTwo;
	}

	public void setModelTwo(ProcessModelTwo modelTwo) {
		this.modelTwo = modelTwo;
	}

	public ITGeneralprocessModeloneService getGeneralprocessModeloneService() {
		return generalprocessModeloneService;
	}

	public void setGeneralprocessModeloneService(
			ITGeneralprocessModeloneService generalprocessModeloneService) {
		this.generalprocessModeloneService = generalprocessModeloneService;
	}

	public ITGeneralprocessMainService getGeneralprocessMainService() {
		return generalprocessMainService;
	}

	public void setGeneralprocessMainService(
			ITGeneralprocessMainService generalprocessMainService) {
		this.generalprocessMainService = generalprocessMainService;
	}

	public String getIsView() {
		return isView;
	}

	public void setIsView(String isView) {
		this.isView = isView;
	}

	public IGeneralprocessService getGeneralProcessService() {
		return generalProcessService;
	}

	public void setGeneralProcessService(
			IGeneralprocessService generalProcessService) {
		this.generalProcessService = generalProcessService;
	}

	public TaskAssgineeDto getTaskAssgineeDto() {
		return taskAssgineeDto;
	}

	public void setTaskAssgineeDto(TaskAssgineeDto taskAssgineeDto) {
		this.taskAssgineeDto = taskAssgineeDto;
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

	public ProcessModelOne getModelOne() {
		return modelOne;
	}

	public void setModelOne(ProcessModelOne modelOne) {
		this.modelOne = modelOne;
	}

	/**
	 * 
	 * @author wsd
	 * @desc 查询当前登录者的默认意见信息
	 * 
	 */
	public void queryDefault() {
		try {
			defaultOps = tDefaultOpinionService.queryDefaultOpsForshow(this.getCurrentOnlineUser().getEmpid());
		} catch (Exception e) {
			log.error("[获取默认意见失败]", e);
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @author wsd
	 * @desc 跳转到模式一的表单页面
	 * @return
	 * 
	 */
	public String toModelOne() {
		try {
    		String flowId="";
    		String processModelId="";
    		if(taskAssgineeDto!=null&&taskAssgineeDto.getBusinessKey()!=null&&!"".equals(taskAssgineeDto.getBusinessKey()))
    			processModelId=String.valueOf(taskAssgineeDto.getBusinessKey());
    		if(taskAssgineeDto!=null&&taskAssgineeDto.getExecutionId()!=null&&!"".equals(taskAssgineeDto.getExecutionId()))
    			flowId=taskAssgineeDto.getExecutionId();
    		modelOne=this.generalprocessModeloneService.queryModelOne(processModelId,flowId);
		} catch (Exception e) {
			log.error("查询模式一表单信息失败", e);
		}
		queryDefault();
		return "toModelOne";
	}

	/**
	 * 
	 * @author wsd
	 * @desc 跳转到模式二的表单页面
	 * 
	 * @return
	 * @throws ClassNotFoundException 
	 * @throws NoSuchFieldException 
	 * @throws IllegalAccessException 
	 * @throws SecurityException 
	 * @throws IllegalArgumentException 
	 * @throws InstantiationException 
	 * @throws InvocationTargetException 
	 * @throws NoSuchMethodException 
	 */
	public String toModelTwo() throws ClassNotFoundException, IllegalArgumentException, SecurityException, IllegalAccessException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException, InstantiationException{
		String businessId = taskAssgineeDto.getExecutionId();
		TGeneralprocessMain main = this.generalprocessMainService.queryMainByBusinessId(businessId);
		Map<String, Object>  map = new HashMap<String, Object>();
		
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
				//map.put(rule, id);
			}
		}
		
		String flowId="";
		String processModelId="";
		if(taskAssgineeDto!=null&&taskAssgineeDto.getBusinessKey()!=null&&!"".equals(taskAssgineeDto.getBusinessKey()))
			processModelId=String.valueOf(taskAssgineeDto.getBusinessKey());
		if(taskAssgineeDto!=null&&taskAssgineeDto.getExecutionId()!=null&&!"".equals(taskAssgineeDto.getExecutionId()))
			flowId=taskAssgineeDto.getExecutionId();
		
		List<List<GeneralprocessFieldBean>> beans = GeneralprocessUtil.returnAllObj(map);
		
		String fxJson = JSONArray.fromObject(beans).toString();
		taskAssgineeDto.setFxJson(fxJson);
		return "toModelTwo";
	}
	
	/**
	 * 
	 * @author wsd
	 * @desc 后台处理模式一的新增模式一表单、结束流程、记录流程日志
	 * @return
	 * @throws Exception 
	 * 
	 */
	public void handleModelOne() throws Exception {
		String info ="success";
    	MUOUserSession muo = getCurrentOnlineUser();
		try {
			this.generalProcessService.handleModelOne(muo,modelOne,taskAssgineeDto);
		} catch (Exception e) {
			info="fails";
			log.error("[提交模式一表单失败！]", e);
			throw e;
		}
		Struts2Utils.renderText(info);
	}
	
	/**
	 * 
	 * @author wsd
	 * @desc 后台处理模式二表单、结束节点、记录流程日志
	 * @return
	 * @throws Exception 
	 * 
	 */
	public void handleModelTwo() throws Exception {
		String info ="success";
    	MUOUserSession muo = getCurrentOnlineUser();
		try {
			this.generalProcessService.handleModelTwo(muo,modelTwo,taskAssgineeDto);
		} catch (Exception e) {
			info="fails";
			log.error("[提交模式二表单失败！]", e);
			throw e;
		}
		Struts2Utils.renderText(info);
	}

}
