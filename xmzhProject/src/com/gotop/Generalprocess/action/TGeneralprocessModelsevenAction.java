package com.gotop.Generalprocess.action;

import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import com.gotop.Generalprocess.annonation.GeneralprocessFieldBean;
import com.gotop.Generalprocess.model.ProcessModelSeven;
import com.gotop.Generalprocess.model.TGeneralprocessMain;
import com.gotop.Generalprocess.service.ITGeneralprocessMainService;
import com.gotop.Generalprocess.service.ITGeneralprocessModelsevenService;
import com.gotop.Generalprocess.util.GeneralprocessUtil;
import com.gotop.crm.util.BaseAction;
import com.gotop.jbpm.dto.TaskAssgineeDto;
import com.gotop.jbpm.service.JbpmService;
import com.gotop.util.Struts2Utils;
import com.gotop.vo.system.MUOUserSession;

public class TGeneralprocessModelsevenAction extends BaseAction {
	/**
	 * 模式七控制器
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * @author wsd
	 * @desc 与流程相关的对象
	 * 
	 */
	private TaskAssgineeDto taskAssgineeDto;

	private String taskName;

	private ProcessModelSeven modelSeven;

	/**
	 * 模式主表服务
	 */
	private ITGeneralprocessMainService generalprocessMainService;

	/**
	 * jbpm服务
	 */
	private JbpmService jbpmService;

	/**
	 * 通过spring注入的Service对象.
	 * 
	 * @abatorgenerated
	 */
	protected ITGeneralprocessModelsevenService tGeneralprocessModelsevenService;

	public ProcessModelSeven getModelSeven() {
		return modelSeven;
	}

	public void setModelSeven(ProcessModelSeven modelSeven) {
		this.modelSeven = modelSeven;
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

	public TaskAssgineeDto getTaskAssgineeDto() {
		return taskAssgineeDto;
	}

	public void setTaskAssgineeDto(TaskAssgineeDto taskAssgineeDto) {
		this.taskAssgineeDto = taskAssgineeDto;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	/**
	 * 通过spring注入Service的set类.
	 * 
	 * @abatorgenerated
	 */
	public void settGeneralprocessModelsevenService(
			ITGeneralprocessModelsevenService tGeneralprocessModelsevenService) {
		this.tGeneralprocessModelsevenService = tGeneralprocessModelsevenService;
	}

	/**
	 * 通过spring注入Service的get类.
	 * 
	 * @abatorgenerated
	 */
	public ITGeneralprocessModelsevenService gettGeneralprocessModelsevenService() {
		return this.tGeneralprocessModelsevenService;
	}

	/**
	 * 跳转到模式七页面
	 * 
	 * @return
	 * @throws InstantiationException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * @throws NoSuchMethodException
	 * @throws ClassNotFoundException
	 * @throws IllegalArgumentException
	 * @throws SecurityException
	 */
	public String toModelSeven() throws SecurityException,
			IllegalArgumentException, ClassNotFoundException,
			NoSuchMethodException, IllegalAccessException,
			InvocationTargetException, InstantiationException {

		// 获取流程实例id
		String businessId = taskAssgineeDto.getExecutionId();

		taskName = taskAssgineeDto.getTaskName();
		// 获取流程配置主表对象
		TGeneralprocessMain main = this.generalprocessMainService
				.queryMainByBusinessId(businessId);

		if (main != null) {
			if (main.getBeginEmpId() != null && main.getBeginOrgId() != null) {
				taskAssgineeDto.setBeginAssingee(main.getBeginEmpId());
				taskAssgineeDto.setBeginOrg(main.getBeginOrgId());
			}
		}

		Map<String, Object> map = new LinkedHashMap<String, Object>();
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

		ProcessModelSeven newModelSeven = new ProcessModelSeven();
		if (businessId != null && taskName1 != null) {
			ProcessModelSeven ms = new ProcessModelSeven();
			ms.setFlowId(businessId);
			ms.setTaskName(taskName1);
			newModelSeven = this.tGeneralprocessModelsevenService
					.queryModelSeven(ms);
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
				if (map.containsKey(rule + "-" + id)) {
					continue;
				} else {
					map.put(rule + "-" + id, id);
				}

			}
		}

		String rm = "";
		if (newModelSeven != null) {
			rm = "ProcessModelSeven" + "-" + newModelSeven.getProcessModelId();
			map.remove(rm);
		}

		this.setModelSeven(newModelSeven);

		List<List<GeneralprocessFieldBean>> beans = GeneralprocessUtil
				.returnAllObj(map);

		String fxJson = JSONArray.fromObject(beans).toString();
		taskAssgineeDto.setFxJson(fxJson);
		return "toModelSeven";
	}

	/**
	 * 处理模式七节点,结束节点
	 * 
	 * @throws Exception
	 */
	public void handleModelSeven() throws Exception {
		String info = "success";
		String nextTaskId = this.taskAssgineeDto.getNextTaskId();
		if ("".equals(nextTaskId) || nextTaskId == null) {
			info = "noFirst";
		} else {
			MUOUserSession muo = getCurrentOnlineUser();
			try {
				this.tGeneralprocessModelsevenService.handleModelSeven(muo,
						modelSeven, taskAssgineeDto);
			} catch (Exception e) {
				info = "fails";
				log.error("[提交模式七表单失败！]", e);
				throw e;
			}
		}
		Struts2Utils.renderText(info);
	}

}