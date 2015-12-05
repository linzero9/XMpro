package com.gotop.Generalprocess.action;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import com.gotop.Generalprocess.annonation.GeneralprocessFieldBean;
import com.gotop.Generalprocess.model.ProcessModelFive;
import com.gotop.Generalprocess.model.TGeneralprocessMain;
import com.gotop.Generalprocess.service.ITGeneralprocessMainService;
import com.gotop.Generalprocess.service.ITGeneralprocessModelfiveService;
import com.gotop.Generalprocess.util.GeneralprocessUtil;
import com.gotop.crm.util.BaseAction;
import com.gotop.jbpm.dto.TaskAssgineeDto;
import com.gotop.jbpm.service.JbpmService;
import com.gotop.util.Struts2Utils;
import com.gotop.vo.system.MUOUserSession;

/**
 * 模式五控制器
 * 
 * @author wsd
 * 
 */
public class TGeneralprocessModelfiveAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 是否只读
	 */
	private String isView;

	/**
	 * 页面标题展示
	 */
	private String taskName;

	/**
	 * 模式五对象
	 */
	private ProcessModelFive modelFive;

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

	public String getIsView() {
		return isView;
	}

	public void setIsView(String isView) {
		this.isView = isView;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public ProcessModelFive getModelFive() {
		return modelFive;
	}

	public void setModelFive(ProcessModelFive modelFive) {
		this.modelFive = modelFive;
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

	/**
	 * 通过spring注入的Service对象.
	 * 
	 * @abatorgenerated
	 */
	protected ITGeneralprocessModelfiveService tGeneralprocessModelfiveService;

	/**
	 * 通过spring注入Service的set类.
	 * 
	 * @abatorgenerated
	 */
	public void settGeneralprocessModelfiveService(
			ITGeneralprocessModelfiveService tGeneralprocessModelfiveService) {
		this.tGeneralprocessModelfiveService = tGeneralprocessModelfiveService;
	}

	/**
	 * 通过spring注入Service的get类.
	 * 
	 * @abatorgenerated
	 */
	public ITGeneralprocessModelfiveService gettGeneralprocessModelfiveService() {
		return this.tGeneralprocessModelfiveService;
	}

	/**
	 * @author wsd
	 * @desc 跳转到模式五的表单页面
	 * @return
	 * @throws InstantiationException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * @throws NoSuchMethodException
	 * @throws ClassNotFoundException
	 * @throws IllegalArgumentException
	 * @throws SecurityException
	 */
	public String toModelFive() throws SecurityException,
			IllegalArgumentException, ClassNotFoundException,
			NoSuchMethodException, IllegalAccessException,
			InvocationTargetException, InstantiationException {
		// 获取流程实例id
		String businessId = taskAssgineeDto.getExecutionId();

		taskName = taskAssgineeDto.getTaskName();

		// 获取流程配置主表对象
		TGeneralprocessMain main = this.generalprocessMainService
				.queryMainByBusinessId(businessId);
		
		if(main != null){
			if(main.getBeginEmpId() != null && main.getBeginOrgId() != null){
				taskAssgineeDto.setBeginAssingee(main.getBeginEmpId());
				taskAssgineeDto.setBeginOrg(main.getBeginOrgId());
			}
		}
		Map<String, Object> map = new HashMap<String, Object>();
		String taskName1 = null;
		if (taskAssgineeDto.getNextTaskId() != null) {
			// 待办-办理
			taskName1 = jbpmService.getTaskNameById(taskAssgineeDto
					.getNextTaskId());
		} else {
			if (taskAssgineeDto.getActivityName() != null) {
				// 已办-查看详情
				taskName1 = taskAssgineeDto.getActivityName();
				taskName = taskName1;
			}
		}
		
		ProcessModelFive newFive = new ProcessModelFive();
		
		if(businessId != null && taskName1 != null){
			ProcessModelFive five = new ProcessModelFive();
			five.setFlowId(businessId);
			five.setTaskName(taskName1);
			newFive = this.tGeneralprocessModelfiveService.queryModelFive(five);
		}
		

		String[] rulesArray = null;
		String[] idsArray = null;
		if (main != null) {
			if (main.getRules() != null && !"".equals(main.getRules())) {
				String rules = main.getRules();
				rulesArray = rules.split(",");
			}

			if (main.getIds() != null && !"".equals(main.getIds())) {
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
		if (newFive != null) {
			rm = "ProcessModelFive" + "-" + newFive.getProcessModelId();
			map.remove(rm);
		}

		this.setModelFive(newFive);

		List<List<GeneralprocessFieldBean>> beans = GeneralprocessUtil
				.returnAllObj(map);

		String fxJson = JSONArray.fromObject(beans).toString();
		taskAssgineeDto.setFxJson(fxJson);
		return "toModelFive";
	}

	/**
	 * 
	 * @author wsd
	 * @desc 后台处理模式五表单、结束节点、记录流程日志
	 * @return
	 * @throws Exception 
	 * 
	 */
	public void handleModelFive() throws Exception {
		String info ="success";
		String nextTaskId = this.taskAssgineeDto.getNextTaskId();
		if("".equals(nextTaskId) || nextTaskId == null){
			info = "noFirst";
		}else{
			MUOUserSession muo = getCurrentOnlineUser();
			try {
				this.tGeneralprocessModelfiveService.handleModelFive(muo,modelFive,taskAssgineeDto);
			} catch (Exception e) {
				info="fails";
				log.error("[提交模式五表单失败！]", e);
				throw e;
			}
		}
    	
		Struts2Utils.renderText(info);
	}

}