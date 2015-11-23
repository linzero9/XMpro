package com.gotop.Generalprocess.action;

import java.lang.reflect.InvocationTargetException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletContext;

import org.apache.struts2.util.ServletContextAware;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import com.gotop.Generalprocess.annonation.GeneralprocessFieldBean;
import com.gotop.Generalprocess.model.ProcessModel;
import com.gotop.Generalprocess.model.ProcessModelOne;
import com.gotop.Generalprocess.model.ProcessModelPublic;
import com.gotop.Generalprocess.model.TGeneralprocessMain;
import com.gotop.Generalprocess.service.IGeneralprocessService;
import com.gotop.Generalprocess.service.ITGeneralprocessMainService;
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
	
	private ITGeneralprocessMainService generalprocessMainService;
	
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
    		modelOne=this.generalProcessService.queryModelOne(processModelId,flowId);
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
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
		//List<ProcessModelOne> modelOnes = this.generalProcessService.getProcessModelOneByBussinessId("1");
		//Map<String, List<GeneralprocessFieldBean>> beans =  GeneralprocessUtil.fixBean(modelOnes, ProcessModelOne.class,"com.gotop.Generalprocess.model.ProcessModelOne");
		//JSONObject s = JSONObject.fromObject(beans);
		//System.out.println(s.toString());
		
		
		
		
		String businessId = taskAssgineeDto.getExecutionId();
		TGeneralprocessMain main = this.generalprocessMainService.queryMainByBusinessId(businessId);
		List<ProcessModel> pmList = new ArrayList<ProcessModel>();
		
		String flowId="";
		String processModelId="";
		if(taskAssgineeDto!=null&&taskAssgineeDto.getBusinessKey()!=null&&!"".equals(taskAssgineeDto.getBusinessKey()))
			processModelId=String.valueOf(taskAssgineeDto.getBusinessKey());
		if(taskAssgineeDto!=null&&taskAssgineeDto.getExecutionId()!=null&&!"".equals(taskAssgineeDto.getExecutionId()))
			flowId=taskAssgineeDto.getExecutionId();
		
		
		Map<String, Object>  rules = new HashMap<String, Object>();
		rules.put("com.gotop.Generalprocess.model.ProcessModelOne", "msyeszm.1320001");
		
		List<List<GeneralprocessFieldBean>> aa = GeneralprocessUtil.returnAllObj(rules);
		
		System.out.println(aa);
		System.out.println(aa);

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


}
