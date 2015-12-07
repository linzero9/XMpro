package com.gotop.Generalprocess.action;

import com.gotop.Generalprocess.annonation.GeneralprocessFieldBean;
import com.gotop.Generalprocess.model.ProcessModelFour;
import com.gotop.Generalprocess.model.ProcessModelFourMistake;
import com.gotop.Generalprocess.model.TGeneralprocessMain;
import com.gotop.Generalprocess.service.ITGeneralprocessMainService;
import com.gotop.Generalprocess.service.ITGeneralprocessModelfourService;
import com.gotop.Generalprocess.util.GeneralprocessUtil;
import com.gotop.crm.util.BaseAction;
import com.gotop.jbpm.dto.TaskAssgineeDto;
import com.gotop.jbpm.service.JbpmService;
import com.gotop.util.Struts2Utils;
import com.gotop.vo.system.MUOUserSession;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

/**
 * 模式四控制器
 * 
 * @author wsd
 * 
 */
public class TGeneralprocessModelfourAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<ProcessModelFourMistake> fourMistakes;

	private String isView;

	/**
	 * 差错内容
	 */
	private String files;

	/**
	 * 扣罚金额
	 */
	private String jees;

	/**
	 * 模式四对象
	 */
	private ProcessModelFour modelFour;

	/**
	 * 页面标题展示
	 */
	private String taskName;

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

	public List<ProcessModelFourMistake> getFourMistakes() {
		return fourMistakes;
	}

	public void setFourMistakes(List<ProcessModelFourMistake> fourMistakes) {
		this.fourMistakes = fourMistakes;
	}

	public String getFiles() {
		return files;
	}

	public void setFiles(String files) {
		this.files = files;
	}

	public String getJees() {
		return jees;
	}

	public void setJees(String jees) {
		this.jees = jees;
	}

	public String getIsView() {
		return isView;
	}

	public void setIsView(String isView) {
		this.isView = isView;
	}

	/**
	 * 通过spring注入的Service对象.
	 * 
	 * @abatorgenerated
	 */
	protected ITGeneralprocessModelfourService tGeneralprocessModelfourService;

	public ProcessModelFour getModelFour() {
		return modelFour;
	}

	public void setModelFour(ProcessModelFour modelFour) {
		this.modelFour = modelFour;
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
	public void settGeneralprocessModelfourService(
			ITGeneralprocessModelfourService tGeneralprocessModelfourService) {
		this.tGeneralprocessModelfourService = tGeneralprocessModelfourService;
	}

	/**
	 * 通过spring注入Service的get类.
	 * 
	 * @abatorgenerated
	 */
	public ITGeneralprocessModelfourService gettGeneralprocessModelfourService() {
		return this.tGeneralprocessModelfourService;
	}

	/**
	 * 
	 * @author wsd
	 * @desc 跳转到模式四的表单页面
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
	public String toModelFour() throws ClassNotFoundException,
			IllegalArgumentException, SecurityException,
			IllegalAccessException, NoSuchFieldException,
			NoSuchMethodException, InvocationTargetException,
			InstantiationException {
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

		ProcessModelFour newModelFour = new ProcessModelFour();
		if (businessId != null && taskName1 != null) {
			ProcessModelFour modelFour = new ProcessModelFour();
			modelFour.setFlowId(businessId);
			modelFour.setTaskName(taskName1);
			newModelFour = this.tGeneralprocessModelfourService
					.queryModelFour(modelFour);
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
				if(map.containsKey(rule + "-" + id)){
					continue;
				}else{
					map.put(rule + "-" + id, id);
				}
			}
		}

		String rm = "";
		if (newModelFour != null) {
			rm = "ProcessModelFour" + "-" + newModelFour.getProcessModelId();
			map.remove(rm);
		}

		this.setModelFour(newModelFour);

		List<List<GeneralprocessFieldBean>> beans = GeneralprocessUtil
				.returnAllObj(map);

		String fxJson = JSONArray.fromObject(beans).toString();
		taskAssgineeDto.setFxJson(fxJson);
		return "toModelFour";
	}

	/**
	 * 
	 * @author wsd
	 * @desc 后台处理模式四表单、结束节点、记录流程日志
	 * @return
	 * @throws Exception
	 * 
	 */
	public void handleModelFour() throws Exception {
		String info = "success";
		String nextTaskId = this.taskAssgineeDto.getNextTaskId();
		if ("".equals(nextTaskId) || nextTaskId == null) {
			info = "noFirst";
		} else {
			MUOUserSession muo = getCurrentOnlineUser();
			try {
				this.tGeneralprocessModelfourService.handleModelFour(muo,
						modelFour, files, jees, taskAssgineeDto);
			} catch (Exception e) {
				info = "fails";
				log.error("[提交模式四表单失败！]", e);
				throw e;
			}
		}
		Struts2Utils.renderText(info);
	}

	/**
	 * 查询差错列表信息
	 * 
	 * @return
	 */
	public String queryFourMistake() {
		try {
			if (modelFour != null && modelFour.getProcessModelId() != null) {
				fourMistakes = this.tGeneralprocessModelfourService
						.queryFourMistake(modelFour);
			}
		} catch (Exception e) {
			log.error("查询差错列表失败！！", e);
		}
		return "list1";
	}
}