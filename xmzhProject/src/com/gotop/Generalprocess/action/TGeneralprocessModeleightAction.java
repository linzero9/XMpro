package com.gotop.Generalprocess.action;

import com.gotop.Generalprocess.annonation.GeneralprocessFieldBean;
import com.gotop.Generalprocess.model.ProcessModelEight;
import com.gotop.Generalprocess.model.TGeneralprocessMain;
import com.gotop.Generalprocess.service.ITGeneralprocessMainService;
import com.gotop.Generalprocess.service.ITGeneralprocessModeleightService;
import com.gotop.Generalprocess.util.GeneralprocessUtil;
import com.gotop.crm.util.BaseAction;
import com.gotop.crm.util.MUO;
import com.gotop.jbpm.dto.TaskAssgineeDto;
import com.gotop.jbpm.service.JbpmService;
import com.gotop.util.Struts2Utils;
import com.gotop.util.XmlConvert;
import com.gotop.vo.system.MUOUserSession;
import com.primeton.utils.AjaxParam;
import com.primeton.utils.Page;
import com.primeton.utils.pageCondExpand;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;

public class TGeneralprocessModeleightAction extends BaseAction {
	/**
	 * 通过spring注入的Service对象.
	 * 
	 * @abatorgenerated
	 */
	protected ITGeneralprocessModeleightService tGeneralprocessModeleigthService;

	/**
	 * 
	 * @author yyx
	 * @desc 与流程相关的对象
	 * 
	 */
	private TaskAssgineeDto taskAssgineeDto;

	/**
	 * jbpm服务
	 */
	private JbpmService jbpmService;

	private String taskName;

	private ProcessModelEight modelEight;

	/**
	 * 模式主表服务
	 */
	private ITGeneralprocessMainService generalprocessMainService;
	
	/**
	 * isView :1、为只读状态， 默认为空
	 */
	private String isView;

	public String getIsView() {
		return isView;
	}

	public void setIsView(String isView) {
		this.isView = isView;
	}

	/**
	 * 通过spring注入Service的set类.
	 * 
	 * @abatorgenerated
	 */
	public void settGeneralprocessModeleigthService(
			ITGeneralprocessModeleightService tGeneralprocessModeleigthService) {
		this.tGeneralprocessModeleigthService = tGeneralprocessModeleigthService;
	}

	/**
	 * 通过spring注入Service的get类.
	 * 
	 * @abatorgenerated
	 */
	public ITGeneralprocessModeleightService gettGeneralprocessModeleigthService() {
		return this.tGeneralprocessModeleigthService;
	}

	public TaskAssgineeDto getTaskAssgineeDto() {
		return taskAssgineeDto;
	}

	public void setTaskAssgineeDto(TaskAssgineeDto taskAssgineeDto) {
		this.taskAssgineeDto = taskAssgineeDto;
	}

	public JbpmService getJbpmService() {
		return jbpmService;
	}

	public void setJbpmService(JbpmService jbpmService) {
		this.jbpmService = jbpmService;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public ProcessModelEight getModelEight() {
		return modelEight;
	}

	public void setModelEight(ProcessModelEight modelEight) {
		this.modelEight = modelEight;
	}

	public ITGeneralprocessMainService getGeneralprocessMainService() {
		return generalprocessMainService;
	}

	public void setGeneralprocessMainService(
			ITGeneralprocessMainService generalprocessMainService) {
		this.generalprocessMainService = generalprocessMainService;
	}

	/**
	 * 
	 * @author yyx
	 * @desc 跳转到模式三的表单页面
	 * @return
	 * 
	 */
	public String toModelEight() {
		try {

			// 获取流程实例id
			String businessId = taskAssgineeDto.getExecutionId();
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
			
			taskName= taskAssgineeDto.getTaskName();
			
			String taskName1 = "";
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
			ProcessModelEight modelEight2 = new ProcessModelEight();
			modelEight2.setFlow_id(businessId);
			modelEight2.setTaskName(taskName1);
			ProcessModelEight newModelEight = new ProcessModelEight();
			newModelEight = this.tGeneralprocessModeleigthService
					.queryModelEight(modelEight2);

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
					if(map.containsKey(rule + "-" + id)){
						continue;
					}else{
						map.put(rule + "-" + id, id);
					}
				}
			}

			String rm = "";
			if (newModelEight != null) {
				rm = "ProcessModelEight" + "-"
						+ newModelEight.getProcessModelId();
				map.remove(rm);
			}

			this.setModelEight(newModelEight);

			List<List<GeneralprocessFieldBean>> beans = GeneralprocessUtil
					.returnAllObj(map);

			String fxJson = JSONArray.fromObject(beans).toString();
			taskAssgineeDto.setFxJson(fxJson);

		} catch (Exception e) {
			log.error("查询模式八表单信息失败", e);
		}
		// queryDefault();
		return "toModelEight";
	}

	/**
	 * 
	 * @author yyx
	 * @desc 后台处理模式一的新增模式八表单、结束流程、记录流程日志
	 * @return
	 * @throws Exception
	 */
	public void handleModelEight() throws Exception {
		String info = "success";
		String nextTaskId = this.taskAssgineeDto.getNextTaskId();
		if ("".equals(nextTaskId) || nextTaskId == null) {
			info = "noFirst";
		} else {
			MUOUserSession muo = getCurrentOnlineUser();
			try {
				this.tGeneralprocessModeleigthService.handleModelEight(muo,
						modelEight, taskAssgineeDto);
			} catch (Exception e) {
				info = "fails";
				log.error("[提交模式八表单失败！]", e);
				throw e;
			}
		}
		Struts2Utils.renderText(info);

	}
}