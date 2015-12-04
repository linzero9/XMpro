package com.gotop.Generalprocess.action;

import com.gotop.Generalprocess.annonation.GeneralprocessFieldBean;
import com.gotop.Generalprocess.model.ProcessModelThree;
import com.gotop.Generalprocess.model.TGeneralprocessMain;
import com.gotop.Generalprocess.service.ITGeneralprocessMainService;
import com.gotop.Generalprocess.service.ITGeneralprocessModelthreeService;
import com.gotop.Generalprocess.util.GeneralprocessUtil;
import com.gotop.crm.util.BaseAction;
import com.gotop.jbpm.dto.TaskAssgineeDto;
import com.gotop.jbpm.service.JbpmService;
import com.gotop.opinion.model.TDefaultOpinion;
import com.gotop.opinion.service.ITDefaultOpinionService;
import com.gotop.util.Struts2Utils;
import com.gotop.vo.system.MUOUserSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

public class TGeneralprocessModelthreeAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * @author wsd
	 * @desc 模式三页面对象
	 * 
	 */
	private ProcessModelThree modelThree;

	private String taskName;

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public ProcessModelThree getModelThree() {
		return modelThree;
	}

	public void setModelThree(ProcessModelThree modelThree) {
		this.modelThree = modelThree;
	}

	public List<TDefaultOpinion> getDefaultOps() {
		return defaultOps;
	}

	public void setDefaultOps(List<TDefaultOpinion> defaultOps) {
		this.defaultOps = defaultOps;
	}

	public TaskAssgineeDto getTaskAssgineeDto() {
		return taskAssgineeDto;
	}

	public void setTaskAssgineeDto(TaskAssgineeDto taskAssgineeDto) {
		this.taskAssgineeDto = taskAssgineeDto;
	}

	public String getIsView() {
		return isView;
	}

	public void setIsView(String isView) {
		this.isView = isView;
	}

	public ITDefaultOpinionService gettDefaultOpinionService() {
		return tDefaultOpinionService;
	}

	public void settDefaultOpinionService(
			ITDefaultOpinionService tDefaultOpinionService) {
		this.tDefaultOpinionService = tDefaultOpinionService;
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

	private ITGeneralprocessModelthreeService generalprocessModelthreeService;

	public ITGeneralprocessModelthreeService getGeneralprocessModelthreeService() {
		return generalprocessModelthreeService;
	}

	public void setGeneralprocessModelthreeService(
			ITGeneralprocessModelthreeService generalprocessModelthreeService) {
		this.generalprocessModelthreeService = generalprocessModelthreeService;
	}

	/**
	 * 模式主表服务
	 */
	private ITGeneralprocessMainService generalprocessMainService;

	/**
	 * jbpm服务
	 */
	private JbpmService jbpmService;

	/**
	 * 
	 * @author yyx
	 * @desc 跳转到模式三的表单页面
	 * @return
	 * 
	 */
	public String toModelThree() {
		try {

			// 获取流程实例id
			String businessId = taskAssgineeDto.getExecutionId();
			// 获取流程配置主表对象
			TGeneralprocessMain main = this.generalprocessMainService
					.queryMainByBusinessId(businessId);
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
			ProcessModelThree newModelThree = new ProcessModelThree();
			if (businessId != null && taskName1 != null) {
				ProcessModelThree modelThree = new ProcessModelThree();
				modelThree.setFlow_id(businessId);
				modelThree.setTaskName(taskName1);
				newModelThree = this.generalprocessModelthreeService
						.queryModelThree(modelThree);
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
			if (newModelThree != null) {
				rm = "ProcessModelThree" + "-"
						+ newModelThree.getProcessModelId();
				map.remove(rm);
			}

			this.setModelThree(newModelThree);

			List<List<GeneralprocessFieldBean>> beans = GeneralprocessUtil
					.returnAllObj(map);

			String fxJson = JSONArray.fromObject(beans).toString();
			taskAssgineeDto.setFxJson(fxJson);

		} catch (Exception e) {
			log.error("查询模式三表单信息失败", e);
		}
		// queryDefault();
		return "toModelthree";
	}

	/**
	 * 
	 * @author yyx
	 * @desc 后台处理模式一的新增模式三表单、结束流程、记录流程日志
	 * @return
	 * @throws Exception
	 */
	public void handleModelThree() throws Exception {
		String info = "success";
		String nextTaskId = this.taskAssgineeDto.getNextTaskId();
		if ("".equals(nextTaskId) || nextTaskId == null) {
			info = "noFirst";
		} else {
			MUOUserSession muo = getCurrentOnlineUser();
			try {
				this.generalprocessModelthreeService.handleModelThree(muo,
						modelThree, taskAssgineeDto);
			} catch (Exception e) {
				info = "fails";
				log.error("[提交模式一表单失败！]", e);
				throw e;
			}
		}
		Struts2Utils.renderText(info);

	}
}